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
public class UserFileService {

    private final ObjectMapper objectMapper;

    public List<UserDTO> retrieveUsersWithMobileLines() {
        return UserBuilder.buildUsers();
    }

    public List<UserDTO> retrieveUsersWithMobileLinesFromFile() {
        File file = new File(MoblileLineConstants.PATH_TO_USERS_FILE);
        try {
            InputStream inputStream = new FileInputStream(file);
            TypeReference<List<UserDTO>> myType = new TypeReference<>() {
            };
            return objectMapper.readValue(inputStream, myType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
