package com.jskno.mobile.lines.controller;

import com.jskno.mobile.lines.domain.MobileLineDTO;
import com.jskno.mobile.lines.domain.UserDTO;
import com.jskno.mobile.lines.service.MobileLineService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/mobile-lines")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8081")
public class MobileLineController {

    private final MobileLineService mobileLineService;

    @GetMapping
    public List<UserDTO> retrieveMobileLines() {
        return mobileLineService.retrieveUsersWithMobileLinesFromFile();
    }

    @PostMapping
    public void addMobileLine(@RequestBody MobileLineDTO mobileLine) {
        mobileLineService.addMobileLine(mobileLine);
    }

}
