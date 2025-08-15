package hjkim27.dev.controller.auth;

import hjkim27.dev.bean.user.vo.UserRequestFindInfo;
import hjkim27.dev.bean.user.vo.UserRequestLogin;
import hjkim27.dev.bean.user.vo.UserResponse;
import hjkim27.dev.bean.user.vo.UserResponseLogin;
import hjkim27.dev.enumeration.MessageEnum;
import hjkim27.dev.exception.ClientException;
import hjkim27.dev.exception.WrongParamException;
import hjkim27.dev.service.UserService;
import hjkim27.dev.util.auth.AuthUtil;
import hjkim27.dev.util.common.ValidParamUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     인증 관련 rest controller
 *     - 로그인 / 비밀번호 찾기 / 중복확인
 * </pre>
 *
 * @since 2025.08
 */
@Slf4j
@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthRestController {

    private final UserService userService;

    /**
     * <pre>
     *     로그인 동작
     * </pre>
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> loginPost(
            HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute UserRequestLogin info
    ) {
        log.info("[{}] {}", request.getMethod(), request.getRequestURI());

        Map<String, Object> map = new HashMap<String, Object>();
        MessageEnum messageEnum = null;

        try {
            // 필수 정보 입력 확인
            if (!ValidParamUtil.isValidParam(info)) {
                messageEnum = MessageEnum.INVALID_PARAMETER;
                throw new WrongParamException(messageEnum.getMessage());
            }
            // 로그인 정보 확인
            UserResponseLogin responseLogin = userService.loginCheck(info);
            if (responseLogin == null) {
                messageEnum = MessageEnum.USER_NOT_FOUND;
                throw new ClientException(messageEnum.getMessage());
            }
            // 로그인 성공
            AuthUtil.setLogin(request, response, responseLogin);
            messageEnum = MessageEnum.SUCCESS;

            // 비밀번호 만료 확인
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime passwordExpiredAt = responseLogin.getPasswordExpiredAt();
            if (passwordExpiredAt != null && now.isAfter(passwordExpiredAt)) {
                // 비밀번호 만료 시 비밀번호 변경 페이지로 리다이렉트
                map.put("redirectUrl", "/auth/change/password");
                messageEnum = MessageEnum.SUCCESS;
            } else {
                // 비밀번호가 유효한 경우 메인 페이지로 리다이렉트
                map.put("redirectUrl", "/");
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            if (messageEnum == null) {
                messageEnum = MessageEnum.INVALID_AUTHENTICATION;
            }
            map.putAll(messageEnum.getMessageInfo());
        }
        return map;
    }

    /**
     * <pre>
     *     계정 정보 찾기
     * </pre>
     *
     * @param request
     * @param response
     * @param info
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/find/information", method = RequestMethod.POST)
    public Map<String, Object> findInformation(
            HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute UserRequestFindInfo info) {
        log.info("[{}] {}", request.getMethod(), request.getRequestURI());

        Map<String, Object> map = new HashMap<>();
        MessageEnum messageEnum = null;
        try {
            String excludeField = null;
            // loginId 찾기일 경우 loginId 필드 제외
            if (info.getFindPassword()) {
                excludeField = "loginId";
            }

            // 필수 정보 입력 확인
            if (!ValidParamUtil.isValidParam(info, excludeField)) {
                messageEnum = MessageEnum.INVALID_PARAMETER;
                throw new WrongParamException(messageEnum.getMessage());
            }
            /*
                사용자 정보 조회
                - 아이디찾기 : 이름, 이메일
                - 비밀번호찾기 : 이름, 이메일, 로그인아이디
             */
            UserResponse userResponse = userService.getForFindInformation(info);
            if (userResponse == null) {
                messageEnum = MessageEnum.USER_NOT_FOUND;
                throw new ClientException(messageEnum.getMessage());
            }

            // 정보가 있을 경우
            // 비밀번호 찾기
            if (info.getFindPassword()) {
                // todo 이메일 발송 - html 페이지 작업 후 전달 필요
            }
            // 아이디 찾기 - 아이디 일부 반환
            else {
                String loginId = userResponse.getLoginId();
                map.put("loginId", loginId.substring(0, 3) + "****");
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            if (messageEnum == null) {
                messageEnum = MessageEnum.INVALID_AUTHENTICATION;
            }
            map.putAll(messageEnum.getMessageInfo());
        }
        return map;
    }

}
