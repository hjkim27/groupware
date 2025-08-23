package hjkim27.dev.bean.tag.vo;

import lombok.*;

/**
 * <pre>
 *     태그 정보 Request, Response 객체
 * </pre>
 *
 * @since 2025.08
 */
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TagData {

    private Long sid;          // 태그 고유 ID
    private String tagName;   // 태그 이름
    private String tagType;   // 태그 구분

}
