package hjkim27.dev.service;

import hjkim27.dev.bean.user.UserDTO;
import hjkim27.dev.bean.user.UserSearch;
import hjkim27.dev.bean.user.vo.*;
import hjkim27.dev.mapper.UserMapper;
import hjkim27.dev.mapper.dto.UserDtoMapper;
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

    private final UserMapper userMapper;
    private final UserDtoMapper dtoMapper;

    private UserResponse toResponse(UserDTO dto) {
        return (dto == null) ? new UserResponse() : dtoMapper.toResponse(dto);
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
        return userMapper.insert(dtoMapper.toDto(user));
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
        return userMapper.update(dtoMapper.toDto(user));
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
        UserDTO dto = userMapper.loginCheck(dtoMapper.toDto(user));
        if (dto != null) {
            UserResponseLogin responseLogin = dtoMapper.toResponseLogin(dto);
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
}
