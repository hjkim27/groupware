package hjkim27.dev.bean.user.vo;

import lombok.*;

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
