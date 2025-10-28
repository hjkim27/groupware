package hjkim27.dev.repository;

import hjkim27.dev.bean.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface TagRepository extends JpaRepository<TagEntity, Long> {

    /**
     * <pre>
     *     select * from tag where tag_name = #{tagName}
     * </pre>
     *
     * @param tagName 태그 이름
     * @return 태그 엔티티
     */
    List<TagEntity> findByTagName(String tagName);


    /**
     * <pre>
     *     select * from tag where tag_type = #{tagType}
     * </pre>
     *
     * @param tagType 태그 타입
     * @return
     */
    List<TagEntity> findByTagType(String tagType);

    /**
     * <pre>
     *     select * from tag where sid in (#{sids})
     * </pre>
     *
     * @param sids
     * @return
     */
    List<TagEntity> findBySidIn(Collection<Long> sids);


}
