package com.jskno.mobile.lines.controller;

import com.jskno.mobile.lines.domain.CreateMobileLineDTO;
import com.jskno.mobile.lines.domain.GetMobileLineDTO;
import com.jskno.mobile.lines.service.MobileLineService;
import com.jskno.mobile.lines.service.line.MobileLineFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/mobile-lines")
@Slf4j
@RequiredArgsConstructor
//@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
public class MobileLineController {

    private final MobileLineService mobileLineService;

    @PostMapping
    public GetMobileLineDTO addMobileLine(@RequestBody CreateMobileLineDTO mobileLine) {
        return mobileLineService.addMobileLine(mobileLine);
    }




}
