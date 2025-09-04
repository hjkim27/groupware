package hjkim27.dev.bean.user.vo;

import lombok.*;

import java.time.LocalDateTime;

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

    private String name;        // 이름
    private String email;       // 이메일
    private String birth;       // 생년월일
    private String phone;       // 전화번호
    private String position;    // 직급
    private Long groupSid;      // 그룹 sid
    private LocalDateTime createdAt;     // 생성일자
    private LocalDateTime updatedAt;     // 수정일자

}
