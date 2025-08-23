package hjkim27.dev.service;

import hjkim27.dev.bean.common.DefaultSearch;
import hjkim27.dev.bean.tag.TagEntity;
import hjkim27.dev.bean.tag.vo.TagData;
import hjkim27.dev.mapper.struct.TagStructMapper;
import hjkim27.dev.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <pre>
 *     태그 관련 service 클래스
 * </pre>
 *
 * @since 2025.08
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;
    private final TagStructMapper structMapper;

    /**
     * <pre>
     *     태그 추가
     * </pre>
     *
     * @param data
     * @return
     */
    public int insert(TagData data) {
        TagEntity tagEntity = tagRepository.save(structMapper.toEntity(data));
        return (tagEntity != null) ? 1 : 0; // JPA save returns the saved entity or null if it fails
    }

    /**
     * <pre>
     *     태그 목록 조회
     * </pre>
     *
     * @param search 검색 객체
     * @return
     */
    public List<TagData> findAll(DefaultSearch search) {
        List<TagEntity> entities = List.of();
        switch (search.getSearchType()) {
            case "type":
                entities = tagRepository.findByTagType(search.getSearchValue());
                break;
            case "name":
                entities = tagRepository.findByTagName(search.getSearchValue());
                break;
            case "sidList":
                entities = tagRepository.findBySidIn(search.getSidList());
                break;
        }
        if (entities.isEmpty()) {
            return List.of(); // Return an empty list if no entities found
        }
        return entities.stream()
                .map(structMapper::toData)
                .toList();
    }


    /**
     * <pre>
     *     태그 일괄 삭제
     *     - todo 다른곳에서 이미 사용중인 태그일 경우 어떻게 할 것인지 확인 필요
     * </pre>
     *
     * @param sidList 삭제 대상 tag sid
     * @return
     */
    public int delete(List<Long> sidList) {
        int result = 0;
        for (Long sid : sidList) {
            result += deleteBySid(sid);
        }
        return result;
    }

    /**
     * <pre>
     *     태그 개별 삭제
     * </pre>
     *
     * @param sid 삭제 대상 sid
     * @return
     */
    public int deleteBySid(Long sid) {
        try {
            tagRepository.deleteById(sid);
            return 1;
        } catch (Exception e) {
            log.error("Error deleting tag with sid {}: {}", sid, e.getMessage());
            return 0;
        }
    }


}
