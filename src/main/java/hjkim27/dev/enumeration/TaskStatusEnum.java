package hjkim27.dev.enumeration;

import hjkim27.dev.bean.task.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <pre>
 *     {@link TaskEntity#getStatus()} 의 값을 관리하기 위한 enum 클래스
 * </pre>
 *
 * @since 2025.09
 */
@Getter
@AllArgsConstructor
public enum TaskStatusEnum {

    none(0, "미처리"),
    pending(1, "보류"),
    in_progress(2, "진행중"),
    completed(3, "완료"),
    cancel(4, "취소"),
    returned(5, "반려");

    private Integer status;
    private String value;
}
