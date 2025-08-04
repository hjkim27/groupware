package hjkim27.dev.mapper.dto;

import hjkim27.dev.bean.user.UserDTO;
import hjkim27.dev.bean.user.vo.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {

    UserDtoMapper INSTANCE = Mappers.getMapper(UserDtoMapper.class);

    UserDTO toDto(UserRequestLogin user);

    UserDTO toDto(UserRequestCreate user);

    UserDTO toDto(UserRequestUpdate user);

    UserResponse toResponse(UserDTO dto);

    UserResponseLogin toResponseLogin(UserDTO dto);

}
