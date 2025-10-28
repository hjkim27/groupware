package hjkim27.dev.mapper.struct;

import hjkim27.dev.bean.data.task.TaskRequest;
import hjkim27.dev.bean.data.task.TaskResponse;
import hjkim27.dev.bean.dto.TaskDTO;
import hjkim27.dev.bean.entity.TaskEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskStructMapper {

    /* vo <-> dto ================================================== */

    TaskDTO toDto(TaskRequest task);

    TaskResponse toResponse(TaskDTO task);

    /* vo <-> Entity =============================================== */
    TaskEntity toEntity(TaskRequest task);

}
