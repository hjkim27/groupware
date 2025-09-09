package hjkim27.dev.bean.task;

import hjkim27.dev.enumeration.TaskStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <pre>
 *     업무관련 Entity  클래스
 * </pre>
 *
 * @since 2025.09
 */
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_task")
public class TaskEntity {

    // 고유 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    // 업무제목
    @Column(nullable = false)
    private String title;

    //  업무설명
    @Column(nullable = true)
    private String description;

    // 업무상태(TaskStatusEnum) 참고
    @Column(nullable = false)
    private Integer status;

    // 우선순위 (0:low, 1:normal, 2:high)
    @Column(nullable = false)
    private Integer priority;

    // 마감일
    @Column(nullable = true)
    private LocalDateTime dueDate;

    //생성자 sid
    @Column(nullable = false)
    private Integer createdUserSid;

    // 담당자 sid
    @Column(nullable = true)
    private List<Integer> assignedUserSids;

    // 글을 확인한 담당자 sid
    @Column(nullable = true)
    private List<Integer> viewUserSids;

    // 태그 sid
    @Column(nullable = true)
    private List<Integer> tagSids;

    // 그룹 sid
    @Column(nullable = true)
    private Integer groupSid;

    // 시작일
    @Column(nullable = true)
    private LocalDateTime startDate;

    // 종료일
    @Column(nullable = true)
    private LocalDateTime endDate;

    // 아카이브여부
    @Column(nullable = true)
    private Boolean isArchived;

    // 중요여부
    @Column(nullable = true)
    private Boolean isImportant;

    // 생성일자
    @Column(nullable = false)
    private LocalDateTime createdAt;

    // 수정일자
    @Column(nullable = true)
    private LocalDateTime updatedAt;

    // 삭제일자
    @Column(nullable = true)
    private LocalDateTime deletedAt;


    @PrePersist
    public void prePersist() {
        if (this.status == null) {
            status = TaskStatusEnum.none.getStatus();
        }
        if (this.priority == null) {
            priority = 1;
        }
        if (this.isArchived == null) {
            isArchived = false;
        }
        if (this.isImportant == null) {
            isImportant = false;
        }
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
