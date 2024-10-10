package com.jskno.mobile.lines.mapper;

import com.jskno.mobile.lines.client.UserDirectory;
import com.jskno.mobile.lines.domain.GetMobileLineDTO;
import com.jskno.mobile.lines.domain.UserDTO;
import com.jskno.mobile.lines.domain.UserDTO.UserDTOBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO mapFromDirectoryToUserDTO(UserDirectory userDirectory, List<GetMobileLineDTO> userLines) {
        if ( userDirectory == null && userLines == null ) {
            return null;
        }

        UserDTOBuilder userDTO = UserDTO.builder();

        if ( userDirectory != null ) {
            userDTO.login( userDirectory.login() );
            userDTO.fullName( userDirectory.fullName() );
            userDTO.delegation( userDirectory.delegation() );
        }
        if ( userLines != null ) {
            List<GetMobileLineDTO> list = userLines;
            if ( list != null ) {
                userDTO.mobileLines( new ArrayList<GetMobileLineDTO>( list ) );
            }
        }

        return userDTO.build();
    }

    @Override
    public List<UserDTO> mapFromDirectoryToUsersDTO(List<UserDirectory> usersDirectory) {
        if ( usersDirectory == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( usersDirectory.size() );
        for ( UserDirectory userDirectory : usersDirectory ) {
            list.add( userDirectoryToUserDTO( userDirectory ) );
        }

        return list;
    }

    protected UserDTO userDirectoryToUserDTO(UserDirectory userDirectory) {
        if ( userDirectory == null ) {
            return null;
        }

        UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.login( userDirectory.login() );
        userDTO.fullName( userDirectory.fullName() );
        userDTO.delegation( userDirectory.delegation() );

        return userDTO.build();
    }
}
