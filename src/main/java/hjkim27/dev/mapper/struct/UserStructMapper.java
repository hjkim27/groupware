package hjkim27.dev.mapper.struct;

import hjkim27.dev.bean.data.user.UserRequestCreate;
import hjkim27.dev.bean.data.user.UserRequestUpdate;
import hjkim27.dev.bean.data.user.UserResponse;
import hjkim27.dev.bean.dto.UserDTO;
import hjkim27.dev.bean.entity.UserEntity;
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
