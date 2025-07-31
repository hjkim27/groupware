package hjkim27.dev.bean.vo;

import lombok.*;

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
public class UserInfo {

    private Integer sid;
    private String loginId;
    private String password;
    private String email;
    private Boolean loginKeep;

    private String birth;
}
