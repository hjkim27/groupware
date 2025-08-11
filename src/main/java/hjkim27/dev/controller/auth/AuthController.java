package hjkim27.dev.controller.auth;

import hjkim27.dev.util.auth.AuthUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * <pre>
 *     인증관련 view controller
 *     - 로그인, 로그아웃 / 비밀번호 찾기 / 인증
 * </pre>
 *
 * @since 2025.08
 */
@Slf4j
@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final String VIEW_FOLDER = "auth";

    /**
     * <pre>
     *     로그인 페이지
     * </pre>
     *
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        log.info("[{}] {}", request.getMethod(), request.getRequestURI());

        ModelAndView mav = new ModelAndView(VIEW_FOLDER + "/login/user");
        if (AuthUtil.isLogin(request)) {
            // todo 메인페이지로
        }
        return mav;
    }

    /**
     * <pre>
     *     관리자 로그인 페이지
     * </pre>
     *
     * @param request
     * @return
     */
    @RequestMapping("/admin/login")
    public ModelAndView loginAdmin(HttpServletRequest request, HttpServletResponse response) {
        log.info("[{}] {}", request.getMethod(), request.getRequestURI());

        ModelAndView mav = new ModelAndView(VIEW_FOLDER + "/login/admin");
        if (AuthUtil.isAdmin(request)) {
            // todo 관리자 메인 페이지로
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
}
