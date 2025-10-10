package hjkim27.dev.mapper.struct;

import hjkim27.dev.bean.tag.TagEntity;
import hjkim27.dev.bean.tag.vo.TagData;
import org.mapstruct.Mapper;

/**
 * <pre>
 *     Tag Struct Mapper
 * </pre>
 *
 * @since 2025.08
 */
@Mapper(componentModel = "spring")
public interface TagStructMapper {

    /* vo <-> dto ================================================== */
    TagData toData(TagEntity entity);

    /* vo <-> Entity =============================================== */
    TagEntity toEntity(TagData dto);

}
