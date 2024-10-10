package com.jskno.mobile.lines.service.line;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jskno.mobile.lines.constants.MoblileLineConstants;
import com.jskno.mobile.lines.domain.UserDTO;
import com.jskno.mobile.lines.utils.UserBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserBuilderService {

    public List<UserDTO> retrieveUsersWithMobileLines() {
        return UserBuilder.buildUsers();
    }


}
