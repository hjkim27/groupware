package hjkim27.dev.enumeration;

import hjkim27.dev.bean.task.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * fixme task 가 아니라 approval 관련으로 수정 필요
 * <pre>
 *     {@link TaskEntity#getStatus()} 의 값을 관리하기 위한 enum 클래스
 *     - 업무 수정 불가 상태 : 보류, 진행중, 완료, 반려
 *     - 업무 수정 가능 상태 : 미처리, 취소
 * </pre>
 *
 * @since 2025.09
 */
@Getter
@AllArgsConstructor
public enum ApprovalStatusEnum {

    none(0, "미처리"),
    pending(1, "보류"),
    in_progress(2, "진행중"),
    completed(3, "완료"),
    cancel(4, "취소"),
    returned(5, "반려");

    private Integer status;
    private String value;
}
