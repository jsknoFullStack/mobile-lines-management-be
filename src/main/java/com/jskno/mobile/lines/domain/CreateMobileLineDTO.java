package com.jskno.mobile.lines.domain;

import java.time.LocalDate;
import lombok.Builder;

@Builder
public record CreateMobileLineDTO(
    String user,
    String company,
    String telephone,
    String extension,
    LocalDate registrationDate,
    LocalDate cancellationDate,
    String notes,
    String rate
) {

}
