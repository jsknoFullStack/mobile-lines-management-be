package com.jskno.mobile.lines.domain;

import java.util.List;
import lombok.Builder;

@Builder
public record UserDTO(
    String name,
    List<MobileLineDTO> mobileLines,
    String link
)
{}
