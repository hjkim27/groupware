package hjkim27.dev.bean.data.task;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <pre>
 *     업무 생성/수정
 * </pre>
 *
 * @since 2025.09
 */
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {

    private Long sid;               // 수정불가
    private String title;
    private String description;

    private Integer priority;
    private LocalDateTime dueDate;
    private Integer createdUserSid; // 수정불가
    private List<Integer> assignedUserSid;

    private List<Integer> tagSid;
    private Integer groupSid;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
