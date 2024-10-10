package com.jskno.mobile.lines.domain;

import java.util.List;
import lombok.Builder;

@Builder
public record UserDTO(
    String login,
    String fullName,
    String delegation,
    List<GetMobileLineDTO> mobileLines
)
{}
