package hjkim27.dev.config.interceptor.value;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <pre>
 *     변수를 저장 관리하기 위한 resolver
 * </pre>
 *
 * @since 2025.11
 */
public interface CommonValueResolver {

    /**
     * <pre>
     *     저장
     * </pre>
     *
     * @param request
     * @param response
     * @param value
     */
    void setValue(HttpServletRequest request, HttpServletResponse response, String value);

    /**
     * <pre>
     *     값을 조회
     * </pre>
     *
     * @param request
     * @param response
     * @return
     */
    String getResolve(HttpServletRequest request, HttpServletResponse response);

    /**
     * <pre>
     *     초기화
     * </pre>
     *
     * @param response
     */
    void clear(HttpServletResponse response);
}
