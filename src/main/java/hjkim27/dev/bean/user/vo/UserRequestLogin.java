package hjkim27.dev.bean.user.vo;

import lombok.*;

/**
 * <pre>
 *     로그인 시 사용자 입력 값
 * </pre>
 *
 * @since 2025.08
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestLogin {

    private String loginId;     // 로그인 아이디
    private String password;    // 비밀번호
    private Boolean keepLogin = false;  // 로그인 유지여부

}
