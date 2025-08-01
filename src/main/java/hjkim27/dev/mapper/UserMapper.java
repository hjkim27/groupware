package hjkim27.dev.mapper;

import hjkim27.dev.bean.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(UserDTO dto);

    int update(UserDTO dto);

    UserDTO get();

    List<UserDTO> getAll();

    int getCount();

}
