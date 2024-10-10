package com.jskno.mobile.lines.service;

import com.jskno.mobile.lines.domain.CreateMobileLineDTO;
import com.jskno.mobile.lines.domain.GetMobileLineDTO;
import com.jskno.mobile.lines.domain.UpdateMobileLineDTO;
import com.jskno.mobile.lines.entity.MobileLine;
import com.jskno.mobile.lines.exception.MobileLineException;
import com.jskno.mobile.lines.mapper.MobileLineMapper;
import com.jskno.mobile.lines.repository.MobileLineRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MobileLineService {

    private final MobileLineMapper mobileLineMapper;
    private final MobileLineRepository mobileLineRepository;

    public List<GetMobileLineDTO> retrieveAllMobileLines() {
        List<MobileLine> lines = mobileLineRepository.findAll();
        return mobileLineMapper.mapToGetMobileLineDTO(lines);
    }

    public GetMobileLineDTO addMobileLine(CreateMobileLineDTO mobileLineDTO) {
        MobileLine mobileLine = mobileLineMapper.mapToMobileLineEntity(mobileLineDTO);
        MobileLine savedLine = mobileLineRepository.save(mobileLine);
        return mobileLineMapper.mapToGetMobileLineDTO(savedLine);
    }

    public GetMobileLineDTO retrieveMobileLineDTO(String userId, Long lineId) {
        MobileLine byId = retrieveMobileLine(userId, lineId);
        return mobileLineMapper.mapToGetMobileLineDTO(byId);
    }

    public MobileLine retrieveMobileLine(String userId, Long lineId) {
        MobileLine byId = mobileLineRepository.findById(lineId)
            .orElseThrow(() -> new MobileLineException(String.format("Line with id %s, not found", lineId)));
        if (!byId.getUserLogin().equals(userId)) {
            throw new MobileLineException(String.format("The line with id: %s, does not belong to user: %s", lineId, userId));
        }
        return byId;
    }

    public void updateMobileLine(UpdateMobileLineDTO updateMobileLineDTO) {
        MobileLine mobileLine = retrieveMobileLine(updateMobileLineDTO.user(), updateMobileLineDTO.id());
        MobileLine updatedMobileLine = mobileLineMapper.mergeMobileLine(updateMobileLineDTO, mobileLine);
        mobileLineRepository.save(updatedMobileLine);
    }

    public void deleteMobileLine(String userId, Long lineId) {
        MobileLine mobileLine = retrieveMobileLine(userId, lineId);
        mobileLineRepository.delete(mobileLine);
    }

}
