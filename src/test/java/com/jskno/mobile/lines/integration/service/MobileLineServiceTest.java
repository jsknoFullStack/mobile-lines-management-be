package com.jskno.mobile.lines.integration.service;

import com.jskno.mobile.lines.domain.MobileLineDTO;
import com.jskno.mobile.lines.service.MobileLineService;
import java.time.OffsetDateTime;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MobileLineServiceTest {

    @Autowired
    private MobileLineService mobileLineService;

    @Test
    void test() {
        // Given
        String path = "";

        // When
        List<MobileLineDTO> mobileLines = mobileLineService.retrieveMobileLinesFromFile();

        // Then
        Assertions.assertNotNull(mobileLines);
    }

    @Test
    void test2() {
        // Given
        var mobileLine = MobileLineDTO.builder()
            .id(5L)
            .user("Ivan Cano")
            .company("Vodafone")
            .telephones(List.of("699322355", "655328796"))
            .extension("933")
            .registrationDate(OffsetDateTime.now().minusDays(500))
            .cancellationDate(OffsetDateTime.now().plusDays(700))
            .rate("The official Java documentation")
            .link("https://www.java.com/en/")
            .build();

        // When
        mobileLineService.addMobileLine(mobileLine);

        // Then
        Assertions.assertTrue(true);
    }

}
