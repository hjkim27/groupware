package hjkim27.dev.bean.user.vo;

import lombok.*;

/**
 * <pre>
 *     사용자 수정 시 사용
 *     수정 시 비밀번호 확인은 수정페이지 진입 시 확인.
 * </pre>
 *
 * @since 2025.08
 */
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestUpdate {

    private Long sid;           // 일련번호
    private String password;    // 새비밀번호(입력 시)
    private String name;        // 이름
    private String email;       // 이메일
    private String birth;       // 생년월일
    private String phone;       // 전화번호
    private String position;    // 직급
    private Long groupSid;      // 그룹 sid
    private Integer authLevel;  // 권한 수준

}
