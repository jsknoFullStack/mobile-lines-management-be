package com.jskno.mobile.lines.utils;

import com.jskno.mobile.lines.domain.GetMobileLineDTO;
import com.jskno.mobile.lines.domain.UserDTO;
import java.time.LocalDate;
import java.util.List;

public class UserBuilder {

    public static List<UserDTO> buildUsers() {
        return List.of(
            UserDTO.builder()
                .login("jskno")
                .fullName("Jose Cano")
                .delegation("Telaviv")
                .mobileLines(List.of(
                    GetMobileLineDTO.builder()
                        .user("jskno")
                        .id(1L)
                        .company("Vodafone")
                        .telephone("123456789")
                        .extension("123")
                        .registrationDate(LocalDate.now().minusDays(10))
                        .cancellationDate(LocalDate.now().plusDays(5))
                        .rate("ABC")
                        .notes("Some notes about Jose Cano telephone 1")
                        .build(),
                    GetMobileLineDTO.builder()
                        .user("jskno")
                        .id(2L)
                        .company("Vodafone")
                        .telephone("123456755")
                        .extension("123")
                        .registrationDate(LocalDate.now().minusDays(10))
                        .cancellationDate(LocalDate.now().plusDays(5))
                        .rate("ABC")
                        .notes("Some notes about Jose Cano telephone 2")
                        .build()))
                .build(),
            UserDTO.builder()
                .login("arocano")
                .fullName("Alvaro Cano")
                .delegation("London")
                .mobileLines(List.of(
                    GetMobileLineDTO.builder()
                        .user("arocano")
                        .id(3L)
                        .company("Vodafone")
                        .telephone("987654321")
                        .extension("123")
                        .registrationDate(LocalDate.now().minusDays(10))
                        .cancellationDate(LocalDate.now().plusDays(5))
                        .rate("ABCDER")
                        .build(),
                    GetMobileLineDTO.builder()
                        .user("arocano")
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
                .login("evacano")
                .fullName("Eva Cano")
                .delegation("Geneve")
                .mobileLines(List.of(
                    GetMobileLineDTO.builder()
                        .user("evacano")
                        .id(5L)
                        .company("Orange")
                        .telephone("692345678")
                        .extension("578")
                        .registrationDate(LocalDate.now().minusDays(1))
                        .cancellationDate(LocalDate.now().plusDays(400))
                        .rate("Learn about kafka ecosystem")
                        .notes("Some notes about Eva Cano telephone 1")
                        .build()))
                .build(),
            UserDTO.builder()
                .login("seraim")
                .fullName("Raquel Gil")
                .delegation("Paris")
                .mobileLines(List.of(
                    GetMobileLineDTO.builder()
                        .user("seraim")
                        .id(6L)
                        .company("Vodafone")
                        .telephone("697452563")
                        .extension("731")
                        .registrationDate(LocalDate.now().minusDays(400))
                        .cancellationDate(LocalDate.now().plusDays(500))
                        .rate("The official Spring documentation")
                        .notes("Some notes about Raquel Gil telephone 1")
                        .build(),
                    GetMobileLineDTO.builder()
                        .user("seraim")
                        .id(4L)
                        .company("Movistar")
                        .telephone("630505050")
                        .extension("731566")
                        .registrationDate(LocalDate.now().minusDays(80))
                        .cancellationDate(LocalDate.now().plusDays(700))
                        .rate("EEDDFFRR")
                        .notes("Some notes about Raquel Gil telephone 2")
                        .build()))
                .build()
        );
    }

}
