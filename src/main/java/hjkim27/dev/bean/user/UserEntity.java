package hjkim27.dev.bean.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * <pre>
 *     사용자 정보 Entity 클래스
 * </pre>
 *
 * @since 2025.08
 */
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_user")
public class UserEntity {

    // 사용자 고유 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    // 로그인 아이디
    @Column(nullable = false, updatable = false)
    private String loginId;

    // 비밀번호
    @Column(nullable = false)
    private String password;

    // 이름
    @Column(nullable = true)
    private String name;

    // 이메일
    @Column(nullable = true)
    private String email;

    // 생년월일
    @Column(nullable = true)
    private String birth;

    // 전화번호
    @Column(nullable = true)
    private String phone;

    // 직급
    @Column(nullable = true)
    private String position;

    // 부서 sid
    @Column(nullable = true)
    private Long groupSid;

    // 역할(admin,user)
    @Column(nullable = false)
    private String role;

    // 권한 수준(관리자일 경우)
    @Column(nullable = true)
    private Integer authLevel;

    // 생성일자
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // 수정일자
    @Column(nullable = true)
    private LocalDateTime updatedAt;

    // 비밀번호 만료일자
    @Column(nullable = true)
    private LocalDateTime passwordExpiredAt;

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
        if (this.role == null) {
            this.role = "user"; // 기본역할=사용자
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
