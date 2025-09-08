package hjkim27.dev.mapper;

import hjkim27.dev.bean.task.TaskDTO;
import hjkim27.dev.bean.task.TaskSearch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskMapper {

    public int update(TaskDTO dto);

    public TaskDTO get(TaskSearch search);

    public List<TaskDTO> getAll(TaskSearch search);

    public int getCount(TaskSearch search);
}
