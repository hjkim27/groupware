package hjkim27.dev.controller;

import hjkim27.dev.bean.user.vo.UserRequestLogin;
import hjkim27.dev.bean.user.vo.UserResponseLogin;
import hjkim27.dev.service.UserService;
import hjkim27.dev.util.auth.AuthUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     로그인/로그아웃 관리
 * </pre>
 */
@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthRestController {

    private final String VIEW_FOLDER = "auth/";

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
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public Map<String, Object> loginPost(
            HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute UserRequestLogin info
    ) {
        log.info("[{}] {}", request.getMethod(), request.getRequestURI());

        Map<String, Object> map = new HashMap<String, Object>();
        int status = 0;
        String message = "";
        try {
            // todo 로그인 확인 로직
            UserResponseLogin responseLogin = userService.loginCheck(info);
            if (responseLogin == null) {
                throw new Exception("사용자 정보 없음");
            }
            AuthUtil.setLogin(request, response, responseLogin);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return map;
    }

}
