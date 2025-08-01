package hjkim27.dev.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import hjkim27.dev.bean.dto.UserDTO;
import hjkim27.dev.bean.vo.UserInfo;
import hjkim27.dev.config.AppConfig;
import hjkim27.dev.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class UserService {

    private ObjectMapper objectMapper = AppConfig.objectMapper;
    private final UserMapper userMapper;


    public int insert(UserInfo info) {
        return userMapper.insert(new UserDTO(info));
    }

    public int update(UserInfo info) {
        return userMapper.update(new UserDTO(info));
    }

    public UserInfo get() {
        UserDTO dto = userMapper.get();
        return new UserInfo(dto);
    }

    public List<UserInfo> getAll() {
        List<UserDTO> list = userMapper.getAll();
        if (list.isEmpty()) {
            return null;
        } else {
            return list.stream().map(UserInfo::new).toList();
        }
    }

    public int getCount() {
        return userMapper.getCount();
    }
}
