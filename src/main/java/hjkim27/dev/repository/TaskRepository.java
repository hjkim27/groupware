package hjkim27.dev.repository;

import hjkim27.dev.bean.task.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
