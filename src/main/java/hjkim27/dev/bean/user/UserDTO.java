package hjkim27.dev.bean.user;

import lombok.*;

import java.util.Date;

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

    private Integer sid;
    private String loginId;
    private String password;
    private String name;
    private String email;
    private String birth;
    private Integer authLevel;
    private Date createdAt;
    private Date updatedAt;
    private Date lastPwUpdatedAt;

}
