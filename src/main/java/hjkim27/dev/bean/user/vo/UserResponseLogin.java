package hjkim27.dev.bean.user.vo;

import lombok.*;

import java.util.Date;

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
    private Integer authLevel;  // 권한 정보
    private Date lastPwUpdatedAt;   // 마지막 비밀번호 변경일자 (비밀번호 변경 알림용)

}
