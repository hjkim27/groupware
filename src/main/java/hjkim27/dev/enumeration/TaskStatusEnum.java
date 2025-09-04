package hjkim27.dev.enumeration;

import hjkim27.dev.bean.task.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
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
public enum TaskStatusEnum {

    none(0, "미처리"),
    isDeleted(1, "삭제"),
    isArchived(2, "보관"),
    isCompleted(3, "완료");

    private Integer status;
    private String value;

}
