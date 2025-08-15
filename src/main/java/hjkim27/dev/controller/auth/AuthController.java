package hjkim27.dev.controller.auth;

import hjkim27.dev.enumeration.MessageEnum;
import hjkim27.dev.util.auth.AuthUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * <pre>
     *     계정 정보 찾기
     * </pre>
     *
     * @param request
     * @param response
     * @param type     login-id, password
     * @return
     */
    @RequestMapping("/find/information/{type}")
    public ModelAndView findInformation(HttpServletRequest request, HttpServletResponse response,
                                        @PathVariable(name = "type", required = true) String type) {
        log.info("[{}] {}", request.getMethod(), request.getRequestURI());
        ModelAndView mav = new ModelAndView(VIEW_FOLDER + "/find/information");
        // 정상 요청
        if ("login-id".equals(type) || "password".equals(type)) {
            mav.addObject("type", type);
        }
        // 잘못된 요청
        else {
            mav = new ModelAndView(new RedirectView(request.getContextPath() + "/auth/login"));
            mav.addObject("message", MessageEnum.INVALID_PARAMETER.getMessageInfo());
        }
        return mav;
    }

    /**
     * <pre>
     *     비밀번호 변경 페이지
     *     - 비밀번호 만료 시
     * </pre>
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/change/password")
    public ModelAndView changePassword(HttpServletRequest request, HttpServletResponse response) {
        log.info("[{}] {}", request.getMethod(), request.getRequestURI());
        ModelAndView mav = new ModelAndView(VIEW_FOLDER + "/change/password");
        // 비밀번호 만료 시에만 접근 가능
        if (!AuthUtil.isPasswordExpired(request)) {
            mav = new ModelAndView(new RedirectView(request.getContextPath() + "/auth/login"));
            mav.addObject("message", MessageEnum.INVALID_AUTHENTICATION.getMessageInfo());
        }
        return mav;
    }
}
