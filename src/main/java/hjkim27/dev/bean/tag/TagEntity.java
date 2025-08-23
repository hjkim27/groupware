package hjkim27.dev.bean.tag;

import jakarta.persistence.*;
import lombok.*;

/**
 * <pre>
 *     태그 정보 Entity 클래스
 * </pre>
 *
 * @since 2025.08
 */
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_tag")
public class TagEntity {

    // 태그 고유 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    // 태그 이름
    @Column(nullable = false, updatable = false)
    private String tagName;

    // 태그 구분
    @Column(nullable = false, updatable = false)
    private String tagType;
}
