package hjkim27.dev.mapper.struct;

import hjkim27.dev.bean.user.UserDTO;
import hjkim27.dev.bean.user.UserEntity;
import hjkim27.dev.bean.user.vo.UserRequestCreate;
import hjkim27.dev.bean.user.vo.UserRequestUpdate;
import hjkim27.dev.bean.user.vo.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserStructMapper {

    /* vo <-> dto ================================================== */
    @Mapping(target = "loginId", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "passwordExpiredAt", ignore = true)
    UserDTO toDto(UserRequestUpdate user);

    @Mapping(target = "keepLogin", ignore = true)
    UserResponse toResponse(UserDTO dto);


    /* vo <-> Entity =============================================== */
    @Mapping(target = "sid", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "passwordExpiredAt", ignore = true)
    UserEntity toEntity(UserRequestCreate user);
}
