package hjkim27.dev.repository;

import hjkim27.dev.bean.data.user.UserResponseLogin;
import hjkim27.dev.bean.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     * <pre>
     *     사용자 로그인 확인용
     * </pre>
     *
     * @param loginId
     * @param password
     * @return
     */
    @Query("select new hjkim27.dev.bean.data.user.UserResponseLogin(u.sid, u.loginId, u.role, u.authLevel, u.passwordExpiredAt, false) " +
            "from UserEntity u where u.loginId = :loginId and u.password = :password")
    Optional<UserResponseLogin> findByLoginIdAndPassword(
            @Param("loginId") String loginId,
            @Param("password") String password
    );


}
