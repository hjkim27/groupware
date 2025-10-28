package hjkim27.dev.service;


import hjkim27.dev.bean.dto.TaskDTO;
import hjkim27.dev.bean.search.TaskSearch;
import hjkim27.dev.bean.data.task.TaskRequest;
import hjkim27.dev.bean.data.task.TaskResponse;
import hjkim27.dev.mapper.mybatis.TaskMapper;
import hjkim27.dev.mapper.struct.TaskStructMapper;
import hjkim27.dev.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final TaskStructMapper taskStructMapper;

    private TaskResponse toResponse(TaskDTO dto) {
        return (dto == null) ? new TaskResponse() : taskStructMapper.toResponse(dto);
    }

    public int insert(TaskRequest task) {
        try {
            taskRepository.save(taskStructMapper.toEntity(task));
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int update(TaskRequest task) {
        return taskMapper.update(taskStructMapper.toDto(task));
    }

    public TaskResponse get(TaskSearch search) {
        return toResponse(taskMapper.get(search));
    }

    public List<TaskResponse> getAll(TaskSearch search) {
        List<TaskDTO> list = taskMapper.getAll(search);
        if (list.isEmpty()) {
            return null;
        } else {
            return list.stream().map(taskStructMapper::toResponse).toList();
        }
    }

    public int getCount(TaskSearch search) {
        return taskMapper.getCount(search);
    }
}
