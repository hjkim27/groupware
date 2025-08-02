package hjkim27.dev.util.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class AuthUtil {

    private static final String LOGIN_SESSION_ID = "LOGIN_ID";
    private static final String ADMIN_SESSION_ID = "ADMIN_ID";

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
    public static Boolean isLogin(HttpServletRequest request) {
        return getValue(request, LOGIN_SESSION_ID) != null;
    }

    /**
     * <pre>
     *     관리자여부 확인
     * </pre>
     *
     * @return
     */
    public static Boolean isAdmin(HttpServletRequest request) {
        return getValue(request, ADMIN_SESSION_ID) != null;
    }

    /**
     * <pre>
     *     로그인
     * </pre>
     */
    public static void setLogin(HttpServletRequest request, Integer sid, Boolean isAdmin) {
        setValue(request, LOGIN_SESSION_ID, sid);
        if (isAdmin) {
            setAdmin(request, sid);
        }
    }

    /**
     * <pre>
     *     관리자 확인
     * </pre>
     *
     * @param request
     * @param admin
     */
    public static void setAdmin(HttpServletRequest request, Integer admin) {
        setValue(request, ADMIN_SESSION_ID, admin);
    }

    /**
     * <pre>
     *     로그아웃
     * </pre>
     */
    public static void setLogout(HttpServletRequest request) {
        removeValue(request, LOGIN_SESSION_ID);
        // 관리자 로그인일 경우 관리자 세션도 삭제
        if (isAdmin(request)) {
            removeValue(request, ADMIN_SESSION_ID);
        }
    }
}
