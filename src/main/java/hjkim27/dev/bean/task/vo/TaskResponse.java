package hjkim27.dev.bean.task.vo;

import hjkim27.dev.enumeration.ApprovalStatusEnum;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <pre>
 *     업무 조회(목록)
 * </pre>
 *
 * @since 2025.09
 */
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponse {

    private Long sid;                       // 고유ID
    private String title;                   // 업무제목
    private String description;             // 업무설명
    private Integer status;                 // 업무상태(TaskStatusEnum) 참고
    private Integer priority;               // 우선순위 (0:low, 1:normal, 2:high)
    private LocalDateTime dueDate;          // 마감일
    private Integer createdUserSid;         // 생성자 sid
    private List<Integer> assignedUserSid;  // 담장자 sid
    private List<Integer> viewUserSids;     // 글을 확인한 담당자 sid
    private List<String> tagName;           // 태그sid 에 해당하는 태그명
    private Integer groupSid;               // 그룹 sid


    private Boolean isArchived;
    private Boolean isImportant;
    private LocalDateTime createdAt;

    private String getStatusValue() {
        String statusValue = "";
        for (ApprovalStatusEnum taskStatus : ApprovalStatusEnum.values()) {
            if (taskStatus.getStatus() == this.status) {
                statusValue = taskStatus.getValue();
                break;
            }
        }
        return statusValue;
    }

}
