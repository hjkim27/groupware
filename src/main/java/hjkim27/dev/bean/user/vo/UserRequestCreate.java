package hjkim27.dev.bean.user.vo;

import lombok.*;

/**
 * <pre>
 *     사용자 추가 시 사용
 * </pre>
 *
 * @since 2025.08
 */
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestCreate {

    private String loginId;     // 로그인아이디
    private String password;    // 비밀번호
    private String name;        // 이름
    private String email;       // 이메일
    private String birth;       // 생년월일
    private Integer authLevel;  // 권한 수준

}
