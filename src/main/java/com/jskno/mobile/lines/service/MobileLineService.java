package com.jskno.mobile.lines.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jskno.mobile.lines.domain.MobileLineDTO;
import com.jskno.mobile.lines.domain.UserDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileLineService {

    private final ObjectMapper objectMapper;
    private final Random random;

    public MobileLineService(@Autowired ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.random = new Random();
    }

    public List<UserDTO> retrieveUsersWithMobileLines() {
        return List.of(
            UserDTO.builder()
                .name("Jose Cano")
                .link("https://vuejs.org")
                .mobileLines(List.of(
                    MobileLineDTO.builder()
                        .id(1L)
                        .company("Vodafone")
                        .telephone("123456789")
                        .extension("123")
                        .registrationDate(LocalDate.now().minusDays(10))
                        .cancellationDate(LocalDate.now().plusDays(5))
                        .rate("ABC")
                        .build(),
                    MobileLineDTO.builder()
                        .id(2L)
                        .company("Vodafone")
                        .telephone("123456755")
                        .extension("123")
                        .registrationDate(LocalDate.now().minusDays(10))
                        .cancellationDate(LocalDate.now().plusDays(5))
                        .rate("ABC")
                        .build()))
                .build(),
            UserDTO.builder()
                .name("Alvaro Cano")
                .link("https://google.com")
                .mobileLines(List.of(
                    MobileLineDTO.builder()
                        .id(3L)
                        .company("Vodafone")
                        .telephone("987654321")
                        .extension("123")
                        .registrationDate(LocalDate.now().minusDays(10))
                        .cancellationDate(LocalDate.now().plusDays(5))
                        .rate("ABCDER")
                        .build(),
                    MobileLineDTO.builder()
                        .id(4L)
                        .company("Movistar")
                        .telephone("564456465")
                        .extension("124")
                        .registrationDate(LocalDate.now().minusDays(10))
                        .cancellationDate(LocalDate.now().plusDays(5))
                        .rate("Learn to google data in order to build apps")
                        .build()))
                .build(),
            UserDTO.builder()
                .name("Eva Cano")
                .link("https://kafka.apache.org/")
                .mobileLines(List.of(
                    MobileLineDTO.builder()
                        .id(5L)
                        .company("Orange")
                        .telephone("692345678")
                        .extension("578")
                        .registrationDate(LocalDate.now().minusDays(1))
                        .cancellationDate(LocalDate.now().plusDays(400))
                        .rate("Learn about kafka ecosystem")
                        .build()))
                .build(),
            UserDTO.builder()
                .name("Raquel Gil")
                .link("https://spring.io/")
                .mobileLines(List.of(
                    MobileLineDTO.builder()
                        .id(6L)
                        .company("Vodafone")
                        .telephone("697452563")
                        .extension("731")
                        .registrationDate(LocalDate.now().minusDays(400))
                        .cancellationDate(LocalDate.now().plusDays(500))
                        .rate("The official Spring documentation")
                        .build(),
                    MobileLineDTO.builder()
                        .id(4L)
                        .company("Movistar")
                        .telephone("630505050")
                        .extension("731566")
                        .registrationDate(LocalDate.now().minusDays(80))
                        .cancellationDate(LocalDate.now().plusDays(700))
                        .rate("EEDDFFRR")
                        .build()))
                .build()
        );
    }

    public List<UserDTO> retrieveUsersWithMobileLinesFromFile() {
        File file = new File("./mobile-lines.json");
        try {
            InputStream inputStream = new FileInputStream(file);
            TypeReference<List<UserDTO>> myType = new TypeReference<>() {
            };
            return objectMapper.readValue(inputStream, myType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addMobileLine(MobileLineDTO mobileLineDTO) {
        List<UserDTO> users = retrieveUsersWithMobileLinesFromFile();
        mobileLines.add(mobileLine);

        try (FileWriter fileWriter = new FileWriter("./mobile-lines.json")) {
            fileWriter.write(objectMapper.writeValueAsString(mobileLines));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
