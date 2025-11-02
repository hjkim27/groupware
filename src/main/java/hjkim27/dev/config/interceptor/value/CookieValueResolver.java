package hjkim27.dev.config.interceptor.value;

import hjkim27.dev.util.common.CookieUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <pre>
 *     공통 cookie 를 관리하기 위한 resolver
 * </pre>
 */
public class CookieValueResolver implements CommonValueResolver {

    private final String COOKIE_NAME = "ComtrueLocaleCookie";

    @Override
    public void setValue(HttpServletRequest request, HttpServletResponse response, String value) {
        CookieUtil.setCookie(response, COOKIE_NAME, value);
    }

    @Override
    public String getResolve(HttpServletRequest request, HttpServletResponse response) {
        return CookieUtil.getCookieValue(request, COOKIE_NAME);
    }

    @Override
    public void clear(HttpServletResponse response) {
        CookieUtil.deleteCookie(response, COOKIE_NAME);
    }
}
