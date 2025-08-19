package hjkim27.dev.mapper.struct;

import hjkim27.dev.bean.user.UserDTO;
import hjkim27.dev.bean.user.UserEntity;
import hjkim27.dev.bean.user.vo.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserStructMapper {

    UserStructMapper INSTANCE = Mappers.getMapper(UserStructMapper.class);

    /* vo <-> dto ================================================== */

    UserDTO toDto(UserRequestLogin user);
//    UserDTO toDto(UserRequestCreate user);
    UserDTO toDto(UserRequestUpdate user);
    UserResponse toResponse(UserDTO dto);
    UserResponseLogin toResponseLogin(UserDTO dto);


    /* vo <-> Entity =============================================== */
    UserEntity toEntity(UserRequestCreate user);
}
