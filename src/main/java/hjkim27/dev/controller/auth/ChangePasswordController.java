package hjkim27.dev.controller.auth;

import hjkim27.dev.enumeration.MessageEnum;
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
 *     - 비밀번호 변경 분리 (2025.08)
 * </pre>
 *
 * @since 2025.08
 */
@Slf4j
@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class ChangePasswordController {

    private final String VIEW_FOLDER = "auth";

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
