package hjkim27.dev.controller;

import hjkim27.dev.bean.search.DefaultSearch;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 *     공지사항
 * </pre>
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {


    private final String VIEW_FOLDER = "notice";

    /**
     * <pre>
     *     공지사항 메인
     * </pre>
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/container")
    public ModelAndView container(HttpServletRequest request, HttpServletResponse response) {
        log.info("[{}] {}", request.getMethod(), request.getRequestURI());
        ModelAndView mav = new ModelAndView(VIEW_FOLDER + "/container");
        return mav;
    }

    /**
     * <pre>
     *     공지사항 목록
     * </pre>
     *
     * @param request
     * @param response
     * @param search
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response, DefaultSearch search) {
        log.info("[{}] {}", request.getMethod(), request.getRequestURI());
        ModelAndView mav = new ModelAndView(VIEW_FOLDER + "/list");
        return mav;
    }

    /**
     * <pre>
     *     공지사항 상세
     * </pre>
     *
     * @param request
     * @param response
     * @param search
     * @return
     */
    @RequestMapping("/detail")
    public ModelAndView detail(HttpServletRequest request, HttpServletResponse response, DefaultSearch search) {
        log.info("[{}] {}", request.getMethod(), request.getRequestURI());
        ModelAndView mav = new ModelAndView(VIEW_FOLDER + "/detail");
        return mav;
    }


}
