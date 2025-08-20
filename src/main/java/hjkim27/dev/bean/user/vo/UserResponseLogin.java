package hjkim27.dev.bean.user.vo;

import lombok.*;

import java.time.LocalDateTime;

/**
 * <pre>
 *     로그인 성공확인 시 반환 정보
 * </pre>
 *
 * @since 2025.08
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseLogin {

    private Integer sid;        // 일련번호
    private String loginId;     // 로그인아이디
    private Integer role;       // 역할 (0: 일반 사용자, 1: 관리자, 2: 서브 관리자)
    private Integer authLevel;  // 권한 정보
    private LocalDateTime passwordExpiredAt;   // 마지막 비밀번호 변경일자 (비밀번호 변경 알림용)
    private Boolean keepLogin;               // 로그인 유지여부. 사용자 로그인 시 전달받은 값

}
