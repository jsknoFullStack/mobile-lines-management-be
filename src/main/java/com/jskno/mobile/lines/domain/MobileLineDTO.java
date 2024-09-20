package com.jskno.mobile.lines.domain;

import java.time.LocalDate;
import lombok.Builder;

@Builder
public record MobileLineDTO(
    Long id,
    String company,
    String telephone,
    String extension,
    LocalDate registrationDate,
    LocalDate cancellationDate,
    String rate,
    String user

) {

}
