package hjkim27.dev.service;

import hjkim27.dev.bean.user.UserDTO;
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
        try {
            userRepository.save(structMapper.toEntity(user));
            return 1;
        } catch (Exception e) {
            return 0;
        }
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
        return userRepository.findByLoginIdAndPassword(user.getLoginId(), user.getPassword())
                .map(responseLogin -> {
                    responseLogin.setKeepLogin(user.getKeepLogin());
                    return responseLogin;
                }).orElse(null);
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


    /**
     * <pre>
     *     계정 일괄 삭제
     * </pre>
     *
     * @param sidList 삭제 대상 사용자 sid
     * @return
     */
    public int delete(List<Long> sidList) {
        int result = 0;
        for (Long sid : sidList) {
            result += deleteBySid(sid);
        }
        return result;
    }

    /**
     * <pre>
     *     사용자 개별 삭제
     * </pre>
     *
     * @param sid
     * @return
     */
    public int deleteBySid(Long sid) {
        try {
            userRepository.deleteById(sid);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

}
