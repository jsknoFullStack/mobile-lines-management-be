package com.jskno.mobile.lines.integration.service;

import com.jskno.mobile.lines.domain.CreateMobileLineDTO;
import com.jskno.mobile.lines.domain.GetMobileLineDTO;
import com.jskno.mobile.lines.service.line.MobileLineFileService;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class MobileLineServiceTest {

    @Autowired
    private MobileLineFileService mobileLineService;

    @Test
    void test() {
        // Given
        String user = "jskno";
        Long lineId = 1L;

        // When
        GetMobileLineDTO mobileLine = mobileLineService.retrieveMobileLine(user, lineId);

        // Then
        Assertions.assertNotNull(mobileLine);
    }

    @Test
    void test2() {
        // Given
        var mobileLine = CreateMobileLineDTO.builder()
            .user("seraim")
            .company("Vodafone")
            .telephone("699322355")
            .extension("933")
            .registrationDate(LocalDate.now().minusDays(500))
            .cancellationDate(LocalDate.now().plusDays(700))
            .rate("The official Java documentation")
            .build();

        // When
        mobileLineService.addMobileLine(mobileLine);

        // Then
        Assertions.assertTrue(true);
    }

}
