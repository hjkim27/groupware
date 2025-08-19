package hjkim27.dev.service;

import hjkim27.dev.bean.user.UserDTO;
import hjkim27.dev.bean.user.UserEntity;
import hjkim27.dev.bean.user.UserSearch;
import hjkim27.dev.bean.user.vo.*;
import hjkim27.dev.mapper.UserMapper;
import hjkim27.dev.mapper.struct.UserStructMapper;
import hjkim27.dev.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <pre>
 *     사용자 관련 service 클래스
 * </pre>
 *
 * @since 2025.08
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserStructMapper structMapper;

    private UserResponse toResponse(UserDTO dto) {
        return (dto == null) ? new UserResponse() : structMapper.toResponse(dto);
    }

    /**
     * <pre>
     *     계정 추가
     * </pre>
     *
     * @param user
     * @return
     */
    public int insert(UserRequestCreate user) {
//        return userMapper.insert(structMapper.toDto(user));
        UserEntity entity = userRepository.save(structMapper.toEntity(user));
        return (entity != null) ? 1 : 0; // JPA save returns the saved entity or null if it fails
    }

    /**
     * <pre>
     *     계정 수정
     * </pre>
     *
     * @param user
     * @return
     */
    public int update(UserRequestUpdate user) {
        return userMapper.update(structMapper.toDto(user));
    }

    /**
     * <pre>
     *     로그인 확인
     *     로그인 실패 시 null 반환
     * </pre>
     *
     * @param user
     * @return
     */
    public UserResponseLogin loginCheck(UserRequestLogin user) {
        UserDTO dto = userMapper.loginCheck(structMapper.toDto(user));
        if (dto != null) {
            UserResponseLogin responseLogin = structMapper.toResponseLogin(dto);
            responseLogin.setKeepLogin(user.getKeepLogin());    // 로그인 유지여부
            return responseLogin;
        } else {
            return null;
        }
    }

    /**
     * <pre>
     *     개별 조회
     * </pre>
     *
     * @param search
     * @return
     */
    public UserResponse get(UserSearch search) {
        return toResponse(userMapper.get(search));
    }

    /**
     * <pre>
     *     목록 조회
     * </pre>
     *
     * @param search
     * @return
     */
    public List<UserResponse> getAll(UserSearch search) {
        List<UserDTO> list = userMapper.getAll(search);
        if (list.isEmpty()) {
            return null;
        } else {
            return list.stream().map(dto -> toResponse(dto)).toList();
        }
    }

    /**
     * <pre>
     *     전체 수 조회
     * </pre>
     *
     * @param search
     * @return
     */
    public int getCount(UserSearch search) {
        return userMapper.getCount(search);
    }

    /**
     * <pre>
     *     계정 정보 찾기
     * </pre>
     *
     * @param user
     * @return
     */
    public UserResponse getForFindInformation(UserRequestFindInfo user) {
        UserDTO dto = userMapper.getForFindInformation(user);
        return (dto == null) ? null : structMapper.toResponse(dto);
    }
}
