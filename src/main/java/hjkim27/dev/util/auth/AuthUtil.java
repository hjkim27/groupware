package hjkim27.dev.util.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class AuthUtil {

    private final String LOGIN_SESSION_ID = "USER_ID";
    private final String ADMIN_SESSION_ID = "ADMIN_ID";

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

    /**
     * <pre>
     *     로그인여부 확인
     * </pre>
     *
     * @return
     */
    public Boolean isLogin(HttpServletRequest request) {
        return getValue(request, LOGIN_SESSION_ID) != null;
    }

    /**
     * <pre>
     *     관리자여부 확인
     * </pre>
     *
     * @return
     */
    public Boolean isAdmin(HttpServletRequest request) {
        return getValue(request, ADMIN_SESSION_ID) != null;
    }

    /**
     * <pre>
     *     로그인
     * </pre>
     */
    public void setLogin(HttpServletRequest request, Integer sid) {
    }

    /**
     * <pre>
     *     로그아웃
     * </pre>
     */
    public void setLogout(HttpServletRequest request) {
        removeValue(request, LOGIN_SESSION_ID);
    }
}
