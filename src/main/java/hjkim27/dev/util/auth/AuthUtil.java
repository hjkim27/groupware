package hjkim27.dev.util.auth;

import hjkim27.dev.bean.user.vo.UserResponseLogin;
import hjkim27.dev.util.common.CookieUtil;
import hjkim27.dev.util.common.SessionUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthUtil {

    private static final String USER_LOGIN_SESSION_ID = "USER_LOGIN";
    private static final String ADMIN_LOGIN_SESSION_ID = "ADMIN_LOGIN";
    private static final String KEEP_LOGIN_COOKIE_ID = "KEEP_LOGIN_ID";


    /**
     * <pre>
     *     로그인여부 확인
     * </pre>
     *
     * @return
     */
    public static Boolean isLogin(HttpServletRequest request) {
        return SessionUtil.getValue(request, USER_LOGIN_SESSION_ID) != null;
    }

    /**
     * <pre>
     *     관리자여부 확인
     * </pre>
     *
     * @return
     */
    public static Boolean isAdmin(HttpServletRequest request) {
        return SessionUtil.getValue(request, ADMIN_LOGIN_SESSION_ID) != null;
    }

    /**
     * <pre>
     *     로그인
     * </pre>
     */
    public static void setLogin(HttpServletRequest request, HttpServletResponse response, UserResponseLogin info) {
        setLogin(request, response, info, info.getAuthLevel() == 1); // 1: 관리자, 0: 사용자
    }

    /**
     * <pre>
     *     로그인
     * </pre>
     *
     * @param request
     * @param response
     * @param info     로그인 정보
     * @param isAdmin
     */
    public static void setLogin(HttpServletRequest request, HttpServletResponse response, UserResponseLogin info, boolean isAdmin) {
        SessionUtil.setValue(request, USER_LOGIN_SESSION_ID, info);
        if (isAdmin) {
            SessionUtil.setValue(request, ADMIN_LOGIN_SESSION_ID, info);
        }

        // 로그인 유지 설정
        if (info.getKeepLogin()) {
            CookieUtil.setCookie(response, KEEP_LOGIN_COOKIE_ID, info.getSid().toString());
        }
    }

    /**
     * <pre>
     *     로그아웃
     * </pre>
     */
    public static void setLogout(HttpServletRequest request, HttpServletResponse response, boolean isAdmin) {
        SessionUtil.removeValue(request, USER_LOGIN_SESSION_ID);
        if (isAdmin) {
            SessionUtil.removeValue(request, ADMIN_LOGIN_SESSION_ID);
        }
        CookieUtil.deleteCookie(response, KEEP_LOGIN_COOKIE_ID);

    }

}
