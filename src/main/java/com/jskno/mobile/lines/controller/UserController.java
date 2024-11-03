package com.jskno.mobile.lines.controller;

import com.jskno.mobile.lines.domain.CreateMobileLineDTO;
import com.jskno.mobile.lines.domain.GetMobileLineDTO;
import com.jskno.mobile.lines.domain.UpdateMobileLineDTO;
import com.jskno.mobile.lines.domain.UserDTO;
import com.jskno.mobile.lines.service.ManagementService;
import com.jskno.mobile.lines.service.MobileLineService;
import com.jskno.mobile.lines.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
//@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"})
@Slf4j
public class UserController {

    private final ManagementService managementService;
    private final MobileLineService mobileLineService;

    @GetMapping
    public List<UserDTO> retrieveMobileLines() {
        return managementService.retrieveUsersWithMobileLines();
    }

    @GetMapping("/{userId}/mobile-lines/{lineId}")
    public GetMobileLineDTO retrieveUserMobileLine(@PathVariable String userId, @PathVariable Long lineId) {
        return mobileLineService.retrieveMobileLineDTO(userId, lineId);
    }

    @PostMapping("/{userId}/mobile-lines")
    public GetMobileLineDTO updateUserMobileLine(@PathVariable String userId, @RequestBody CreateMobileLineDTO createMobileLineDTO) {
        return mobileLineService.addMobileLine(createMobileLineDTO);
    }

    @PutMapping("/{userId}/mobile-lines/{lineId}")
    public void updateUserMobileLine(@PathVariable String userId, @PathVariable String lineId,
        @RequestBody UpdateMobileLineDTO updateMobileLineDTO) {
        mobileLineService.updateMobileLine(updateMobileLineDTO);
    }

    @DeleteMapping("/{userId}/mobile-lines/{lineId}")
    public void deleteMobileLine(@PathVariable String userId, @PathVariable Long lineId) {
        mobileLineService.deleteMobileLine(userId, lineId);
    }

}
