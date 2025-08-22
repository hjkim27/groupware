package hjkim27.dev.bean.user.vo;

import lombok.*;

/**
 * <pre>
 *     사용자 정보 찾기 요청 시 사용
 * </pre>
 *
 * @since 2025.08
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestFindInfo {

    private Boolean findPassword = false;

    /* 필수 입력 값 */
    private String name;    // 이름
    private String email;   // 이메일

    /* type 이 password 일 경우 필수 값 */
    private String loginId; // 로그인 아이디

}
