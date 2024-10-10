package com.jskno.mobile.lines.controller.file;

import com.jskno.mobile.lines.domain.CreateMobileLineDTO;
import com.jskno.mobile.lines.domain.GetMobileLineDTO;
import com.jskno.mobile.lines.service.line.MobileLineFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/mobile-lines/file")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class MobileLineFileController {

    private final MobileLineFileService mobileLineService;

    @PostMapping
    public GetMobileLineDTO addMobileLine(@RequestBody CreateMobileLineDTO mobileLine) {
        return mobileLineService.addMobileLine(mobileLine);
    }




}
