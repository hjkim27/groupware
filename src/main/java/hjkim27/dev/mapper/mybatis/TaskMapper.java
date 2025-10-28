package hjkim27.dev.mapper.mybatis;

import hjkim27.dev.bean.dto.TaskDTO;
import hjkim27.dev.bean.search.TaskSearch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskMapper {

    int update(TaskDTO dto);

    TaskDTO get(TaskSearch search);

    List<TaskDTO> getAll(TaskSearch search);

    int getCount(TaskSearch search);
}
