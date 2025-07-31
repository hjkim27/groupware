package hjkim27.dev.bean.dto;

import lombok.*;

import java.util.Date;

/**
 * <pre>
 *     사용자 정보
 * </pre>
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
    private String email;
    private Boolean loginKeep;

    private String birth;

    private Date createdAt;
    private Date updatedAt;
}
