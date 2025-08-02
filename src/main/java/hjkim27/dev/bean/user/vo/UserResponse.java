package hjkim27.dev.bean.user.vo;

import lombok.*;

import java.util.Date;

/**
 * <pre>
 *     사용자 정보 조회
 * </pre>
 *
 * @since 2025.08
 */
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse extends UserResponseLogin {

    private String email;       // 이메일
    private String birth;       // 생년월일
    private Date createdAt;     // 생성일자
    private Date updatedAt;     // 수정일자

}
