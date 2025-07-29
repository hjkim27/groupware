package hjkim27.dev.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     로그인/로그아웃 관리
 * </pre>
 */
@Slf4j
@Controller
@RequestMapping("/auth")
public class AuthController {

    private final String VIEW_FOLDER = "auth/";

    /**
     * <pre>
     *     로그인 페이지
     * </pre>
     *
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request) {
        log.info("[{}] {}", request.getMethod(), request.getRequestURI());

        ModelAndView mav = new ModelAndView(VIEW_FOLDER + "login/user");
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
    public ModelAndView loginAdmin(HttpServletRequest request) {
        log.info("[{}] {}", request.getMethod(), request.getRequestURI());

        ModelAndView mav = new ModelAndView(VIEW_FOLDER + "login/admin");
        return mav;
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
    @RequestMapping(value = {"/login", "/admin/login"}, method = RequestMethod.POST)
    public Map<String, Object> loginPost(HttpServletRequest request) {
        log.info("[{}] {}", request.getMethod(), request.getRequestURI());

        Map<String, Object> map = new HashMap<String, Object>();
        int status = 0;
        String message = "";
        try {
            // todo 로그인 확인 로직
            //      @modelAttribute 로 bean 추가
            //      해당 bean 에서 admin 일 경우 admin 로그인 확인으로 동작
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return map;
    }

}
