package hjkim27.dev.mapper;

import hjkim27.dev.bean.user.UserDTO;
import hjkim27.dev.bean.user.UserSearch;
import hjkim27.dev.bean.user.vo.UserRequestFindInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <pre>
 *     사용자 관련 dto <-> vo
 * </pre>
 *
 * @since 2025.08
 */
@Mapper
public interface UserMapper {

    int insert(UserDTO dto);

    int update(UserDTO dto);

    UserDTO loginCheck(UserDTO dto);

    UserDTO get(UserSearch search);

    List<UserDTO> getAll(UserSearch search);

    int getCount(UserSearch search);

    /**
     * <pre>
     *     사용자 아이디, 비밀번호 찾기 시 사용
     * </pre>
     *
     * @param dto
     * @return
     */
    UserDTO getForFindInformation(UserRequestFindInfo dto);

}
