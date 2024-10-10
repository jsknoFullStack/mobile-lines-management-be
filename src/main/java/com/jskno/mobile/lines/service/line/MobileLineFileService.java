package com.jskno.mobile.lines.service.line;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jskno.mobile.lines.constants.MoblileLineConstants;
import com.jskno.mobile.lines.domain.CreateMobileLineDTO;
import com.jskno.mobile.lines.domain.GetMobileLineDTO;
import com.jskno.mobile.lines.domain.UpdateMobileLineDTO;
import com.jskno.mobile.lines.domain.UserDTO;
import com.jskno.mobile.lines.utils.CustomCollectors;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileLineFileService {

    private final UserFileService userService;
    private final ObjectMapper objectMapper;
    private final Random random;

    public MobileLineFileService(UserFileService userService, @Autowired ObjectMapper objectMapper) {
        this.userService = userService;
        this.objectMapper = objectMapper;
        this.random = new Random();
    }

    public GetMobileLineDTO addMobileLine(CreateMobileLineDTO mobileLineDTO) {
        GetMobileLineDTO getMobileLineDTO = mapCreateToGetMobileLineDTO(mobileLineDTO);
        List<UserDTO> users = userService.retrieveUsersWithMobileLinesFromFile();
        users.stream()
            .filter(userDTO -> userDTO.login().equals(mobileLineDTO.user()))
            .collect(CustomCollectors.toSingleton())
            .mobileLines().add(getMobileLineDTO);

        try (FileWriter fileWriter = new FileWriter(MoblileLineConstants.PATH_TO_USERS_FILE)) {
            fileWriter.write(objectMapper.writeValueAsString(users));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return getMobileLineDTO;
    }

    public GetMobileLineDTO retrieveMobileLine(String userId, Long lineId) {
        List<UserDTO> users = userService.retrieveUsersWithMobileLinesFromFile();
        return users.stream()
            .filter(userDTO -> userDTO.login().equals(userId))
            .collect(CustomCollectors.toSingleton())
            .mobileLines().stream()
            .filter(line -> line.id().equals(lineId))
            .collect(CustomCollectors.toSingleton());
    }

    public void updateMobileLine(UpdateMobileLineDTO updateMobileLineDTO) {
        List<UserDTO> users = userService.retrieveUsersWithMobileLinesFromFile();
        UserDTO filteredUser = users.stream()
            .filter(userDTO -> userDTO.login().equals(updateMobileLineDTO.user()))
            .collect(CustomCollectors.toSingleton());

        GetMobileLineDTO getMobileLineDTO = filteredUser
            .mobileLines().stream()
            .filter(line -> line.id().equals(updateMobileLineDTO.id()))
            .collect(CustomCollectors.toSingleton());

        int indexOf = filteredUser.mobileLines().indexOf(getMobileLineDTO);

        GetMobileLineDTO newMobileLine = mapUpdateToGetMobileLineDTO(updateMobileLineDTO);
        filteredUser.mobileLines().set(indexOf, newMobileLine);

        try (FileWriter fileWriter = new FileWriter(MoblileLineConstants.PATH_TO_USERS_FILE)) {
            fileWriter.write(objectMapper.writeValueAsString(users));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private GetMobileLineDTO mapCreateToGetMobileLineDTO(CreateMobileLineDTO mobileLineDTO) {
        return GetMobileLineDTO.builder()
            .id(random.nextLong())
            .company(mobileLineDTO.company())
            .telephone(mobileLineDTO.telephone())
            .extension(mobileLineDTO.extension())
            .registrationDate(mobileLineDTO.registrationDate())
            .cancellationDate(mobileLineDTO.cancellationDate())
            .rate(mobileLineDTO.rate())
            .notes(mobileLineDTO.notes())
            .build();
    }

    private GetMobileLineDTO mapUpdateToGetMobileLineDTO(UpdateMobileLineDTO updateMobileLineDTO) {
        return GetMobileLineDTO.builder()
            .id(updateMobileLineDTO.id())
            .user(updateMobileLineDTO.user())
            .company(updateMobileLineDTO.company())
            .telephone(updateMobileLineDTO.telephone())
            .extension(updateMobileLineDTO.extension())
            .registrationDate(updateMobileLineDTO.registrationDate())
            .cancellationDate(updateMobileLineDTO.cancellationDate())
            .rate(updateMobileLineDTO.rate())
            .notes(updateMobileLineDTO.notes())
            .build();
    }

}
