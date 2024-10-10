package com.jskno.mobile.lines.controller.file;

import com.jskno.mobile.lines.domain.CreateMobileLineDTO;
import com.jskno.mobile.lines.domain.GetMobileLineDTO;
import com.jskno.mobile.lines.domain.UpdateMobileLineDTO;
import com.jskno.mobile.lines.domain.UserDTO;
import com.jskno.mobile.lines.service.line.MobileLineFileService;
import com.jskno.mobile.lines.service.line.UserFileService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/users/file")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
@Slf4j
public class UserFileController {

    private final UserFileService userService;
    private final MobileLineFileService mobileLineService;

    @GetMapping
    public List<UserDTO> retrieveMobileLines() {
        return userService.retrieveUsersWithMobileLinesFromFile();
    }

    @GetMapping("/error")
    public List<UserDTO> retrieveMobileLinesWhenException() {
        throw new IllegalStateException("");
    }

    @GetMapping("/builder")
    public List<UserDTO> retrieveMobileLinesFromBuilder() {
        return userService.retrieveUsersWithMobileLines();
    }

    @GetMapping("/{userId}/mobile-lines/{lineId}")
    public GetMobileLineDTO retrieveUserMobileLine(@PathVariable String userId, @PathVariable Long lineId) {
        return mobileLineService.retrieveMobileLine(userId, lineId);
    }

    @PostMapping("/{userId}/mobile-lines")
    public void updateUserMobileLine(@PathVariable String userId, @RequestBody CreateMobileLineDTO createMobileLineDTO) {
        mobileLineService.addMobileLine(createMobileLineDTO);
    }

    @PutMapping("/{userId}/mobile-lines/{lineId}")
    public void updateUserMobileLine(@PathVariable String userId, @PathVariable String lineId,
        @RequestBody UpdateMobileLineDTO updateMobileLineDTO) {
        mobileLineService.updateMobileLine(updateMobileLineDTO);
    }

}
