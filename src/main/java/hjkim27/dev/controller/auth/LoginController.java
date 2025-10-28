package hjkim27.dev.controller.auth;

import hjkim27.dev.bean.data.user.UserRequestLogin;
import hjkim27.dev.bean.data.user.UserResponseLogin;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     인증관련 view controller
 *     - 로그인, 로그아웃 분리 (2025.08)
 * </pre>
 *
 * @since 2025.08
 */
@Slf4j
@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

    private final String VIEW_FOLDER = "auth";

    private final UserService userService;

    /**
     * <pre>
     *     로그인 페이지
     * </pre>
     *
     * @param request
     * @param response
     * @param type     user:사용자(default), admin:관리자
     * @return
     */
    @RequestMapping("/login/{type}")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
                              @PathVariable(name = "type", value = "user") String type) {
        log.info("[{}] {}", request.getMethod(), request.getRequestURI());

        String viewName = VIEW_FOLDER + "/login/";
        viewName += ("admin".equals(type)) ? "admin" : "user";

        ModelAndView mav = new ModelAndView(viewName);

        // cookie확인 > cookie 가 있을 경우 자동 로그인 처리
        if (AuthUtil.isLogin(request)) {
            // todo 메인페이지로
        }
        return mav;
    }

    /**
     * <pre>
     *     로그아웃
     * </pre>
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = {"/logout", "/admin/logout"})
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        log.info("[{}] {}", request.getMethod(), request.getRequestURI());
        try {
            boolean isAdmin = request.getRequestURI().contains("admin");
            AuthUtil.setLogout(request, response, isAdmin);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ModelAndView(new RedirectView(request.getContextPath() + "/auth/login"));
    }


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

}
