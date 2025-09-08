package hjkim27.dev.mapper.struct;

import hjkim27.dev.bean.task.TaskDTO;
import hjkim27.dev.bean.task.TaskEntity;
import hjkim27.dev.bean.task.vo.TaskRequest;
import hjkim27.dev.bean.task.vo.TaskResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TaskStructMapper {

    TaskStructMapper INSTANCE = Mappers.getMapper(TaskStructMapper.class);

    /* vo <-> dto ================================================== */

    TaskDTO toDto(TaskRequest task);

    TaskResponse toResponse(TaskDTO task);

    /* vo <-> Entity =============================================== */
    TaskEntity toEntity(TaskRequest task);

}
