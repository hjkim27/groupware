package hjkim27.dev.mapper.mybatis;

import hjkim27.dev.bean.data.user.UserRequestFindInfo;
import hjkim27.dev.bean.dto.UserDTO;
import hjkim27.dev.bean.search.UserSearch;
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
