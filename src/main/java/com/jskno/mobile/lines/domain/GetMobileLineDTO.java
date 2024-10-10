package com.jskno.mobile.lines.domain;

import java.time.LocalDate;
import lombok.Builder;

@Builder
public record GetMobileLineDTO(
    String user,
    Long id,
    String company,
    String telephone,
    String extension,
    LocalDate registrationDate,
    LocalDate cancellationDate,
    String notes,
    String rate
) {

}
