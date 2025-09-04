package hjkim27.dev.bean.task.vo;

import lombok.*;

import java.util.List;

/**
 * <pre>
 *     업무 조회(상세)
 * </pre>
 *
 * @since 2025.09
 */
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponseDetail extends TaskResponse {

    private String description;
    private List<Integer> assignedUserSid;  // 담장자 sid
    private List<Integer> viewUserSids;     // 글을 확인한 담당자 sid
}
