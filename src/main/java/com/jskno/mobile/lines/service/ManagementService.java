package com.jskno.mobile.lines.service;

import com.jskno.mobile.lines.client.UserDirectory;
import com.jskno.mobile.lines.domain.GetMobileLineDTO;
import com.jskno.mobile.lines.domain.UserDTO;
import com.jskno.mobile.lines.mapper.UserMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagementService {

    private final UserService userService;
    private final MobileLineService mobileLineService;
    private final UserMapper userMapper;

    public List<UserDTO> retrieveUsersWithMobileLines() {
        // Invoke AD ClouseService with Feign Client
        List<UserDirectory> usersFromAD = userService.retrieveUsers();
        // Bring all mobile lines from Postgres
        List<GetMobileLineDTO> lines = mobileLineService.retrieveAllMobileLines();

        List<UserDTO> users = new ArrayList<>();
        usersFromAD.forEach(userAD -> {
            List<GetMobileLineDTO> userLines = lines.stream()
                .filter(line -> line.user().equals(userAD.login()))
                .collect(Collectors.toList());
            UserDTO userDTO = userMapper.mapFromDirectoryToUserDTO(userAD, userLines);
            users.add(userDTO);
            lines.removeAll(userLines);

        });

        // Mix the data to return userDTOs
        return users;
    }

}
