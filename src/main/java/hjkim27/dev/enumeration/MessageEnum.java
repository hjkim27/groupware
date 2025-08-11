package hjkim27.dev.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     공통 메시지 관리 enum
 * </pre>
 *
 * @since 2025.08
 */
@Getter
@AllArgsConstructor
public enum MessageEnum {

    // 성공
    SUCCESS("S000", HttpStatus.SC_OK, "Request completed successfully.", "성공"),

    // 사용자 요청 오류
    INVALID_PARAMETER("C001", HttpStatus.SC_BAD_REQUEST, "Invalid request parameter(s).", "잘못된 파라미터가 존재합니다."),
    NOT_LOGGED_IN("C002", HttpStatus.SC_UNAUTHORIZED, "Authentication is required.", "로그인 정보가 존재하지 않습니다."),
    USER_NOT_FOUND("C003", HttpStatus.SC_NOT_FOUND, "User information not found.", "사용자 정보를 찾을 수 없습니다."),
    INVALID_AUTHENTICATION("C004", HttpStatus.SC_FORBIDDEN, "You do not have permission to access this resource.", "권한이 존재하지 않습니다."),

    // 통신 오류
    API_COMMUNICATION_FAILED("A001", HttpStatus.SC_SERVICE_UNAVAILABLE, "Failed to communicate with the API.", "API 통신 실패"),
    AJAX_REQUEST_FAILED("A002", HttpStatus.SC_BAD_GATEWAY, "AJAX request failed.", "Ajax 통신 실패"),

    // DB 조회 오류
    DATABASE_QUERY_FAILED("D001", HttpStatus.SC_INTERNAL_SERVER_ERROR, "Database query failed.", "Database 쿼리 실패");

    private final String code;  // S(Success:성공), C(Client:사용자요청), A(API:통신), D(DB)
    private final int status;   // httpStatus
    private final String message;       // 영문 에러 메시지
    private final String messageKor;    // 한글 에러 메시지


    public Map<String, Object> getMessageInfo() {
        Map<String, Object> values = new HashMap<>();
        values.put("code", this.getCode());
        values.put("status", this.getStatus());
        values.put("message", this.getMessage());
        values.put("messageKor", this.getMessageKor());
        return values;
    }

}
