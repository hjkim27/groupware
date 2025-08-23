package hjkim27.dev.mapper.struct;

import hjkim27.dev.bean.tag.TagEntity;
import hjkim27.dev.bean.tag.vo.TagData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * <pre>
 *     Tag Struct Mapper
 * </pre>
 *
 * @since 2025.08
 */
@Mapper
public interface TagStructMapper {

    TagStructMapper INSTANCE = Mappers.getMapper(TagStructMapper.class);

    TagData toData(TagEntity entity);

    TagEntity toEntity(TagData dto);

}
