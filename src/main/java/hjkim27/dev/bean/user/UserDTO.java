package hjkim27.dev.bean.user;

import lombok.*;

import java.time.LocalDateTime;

/**
 * <pre>
 *     사용자 정보
 * </pre>
 *
 * @since 2025.07
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long sid;
    private String loginId;
    private String password;
    private String name;
    private String email;
    private String birth;
    private String phone;
    private String position;
    private Long groupSid;
    private String role;
    private Integer authLevel;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime passwordExpiredAt;

}
