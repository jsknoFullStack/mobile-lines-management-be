package com.jskno.mobile.lines.mapper;

import com.jskno.mobile.lines.client.UserDirectory;
import com.jskno.mobile.lines.domain.GetMobileLineDTO;
import com.jskno.mobile.lines.domain.UserDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(target = "mobileLines", source = "userLines")
    UserDTO mapFromDirectoryToUserDTO(UserDirectory userDirectory, List<GetMobileLineDTO> userLines);

    List<UserDTO> mapFromDirectoryToUsersDTO(List<UserDirectory> usersDirectory);

}
