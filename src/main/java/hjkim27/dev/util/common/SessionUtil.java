package hjkim27.dev.util.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * <pre>
 *     Session 관리 util class
 * </pre>
 *
 * @since 2025.08
 */public class SessionUtil {

    private static HttpSession getSession(HttpServletRequest request) {
        return request.getSession(true);
    }

    public static Object getValue(HttpServletRequest request, String key) {
        return getSession(request).getAttribute(key);
    }

    public static void setValue(HttpServletRequest request, String key, Object value) {
        getSession(request).setAttribute(key, value);
    }

    public static void removeValue(HttpServletRequest request, String key) {
        getSession(request).removeAttribute(key);
    }

}
