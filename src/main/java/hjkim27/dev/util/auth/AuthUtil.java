package hjkim27.dev.util.auth;

import hjkim27.dev.bean.user.vo.UserResponseLogin;
import hjkim27.dev.util.common.CookieUtil;
import hjkim27.dev.util.common.SessionUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.time.LocalDateTime;

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
     *     로그인 정보 조회
     * </pre>
     *
     * @param request
     * @return
     */
    public static UserResponseLogin getInfo(HttpServletRequest request) {
        return (UserResponseLogin) SessionUtil.getValue(request, USER_LOGIN_SESSION_ID);
    }

    /**
     * <pre>
     *     로그인 정보 조회 : 사용자 일련번호
     * </pre>
     *
     * @param request
     * @return
     */
    public static int getSid(HttpServletRequest request) {
        return getInfo(request).getSid();
    }

    /**
     * <pre>
     *     로그인 정보 조회 : 사용자 아이디
     * </pre>
     *
     * @param request
     * @return
     */
    public static String getLoginId(HttpServletRequest request) {
        return getInfo(request).getLoginId();
    }

    /**
     * <pre>
     *     비밀번호 만료 여부 확인
     * </pre>
     *
     * @param request
     * @return
     */
    public static Boolean isPasswordExpired(HttpServletRequest request) {
        LocalDateTime passwordExpiredAt = getInfo(request).getPasswordExpiredAt();
        LocalDateTime now = LocalDateTime.now();
        if (passwordExpiredAt.isAfter(now)) {
            return true; // 비밀번호가 만료된 경우
        }
        return false;
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
        if (isAdmin) {
            SessionUtil.setValue(request, ADMIN_LOGIN_SESSION_ID, info);
        } else {
            SessionUtil.setValue(request, USER_LOGIN_SESSION_ID, info);
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
        if (isAdmin) {
            SessionUtil.removeValue(request, ADMIN_LOGIN_SESSION_ID);
        } else {
            SessionUtil.removeValue(request, USER_LOGIN_SESSION_ID);
        }
        CookieUtil.deleteCookie(response, KEEP_LOGIN_COOKIE_ID);

    }

}
