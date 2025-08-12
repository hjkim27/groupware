package hjkim27.dev.bean.user.vo;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestFindInfo {

    private String type;    // login-id, password
    private String email;   // 이메일
}
