package com.jskno.mobile.lines.mapper;

import com.jskno.mobile.lines.domain.CreateMobileLineDTO;
import com.jskno.mobile.lines.domain.GetMobileLineDTO;
import com.jskno.mobile.lines.domain.UpdateMobileLineDTO;
import com.jskno.mobile.lines.entity.MobileLine;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface MobileLineMapper {

    @Mapping(target = "user", source = "userLogin")
    GetMobileLineDTO mapToGetMobileLineDTO(MobileLine line);
    List<GetMobileLineDTO> mapToGetMobileLineDTO(List<MobileLine> lines);

    @InheritInverseConfiguration(name = "mapToGetMobileLineDTO")
    MobileLine mapToMobileLineEntity(GetMobileLineDTO getMobileLineDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userLogin", source = "user")
    MobileLine mapToMobileLineEntity(CreateMobileLineDTO line);

    @Mapping(target = "userLogin", source = "user")
    MobileLine mergeMobileLine(UpdateMobileLineDTO updateMobileLineDTO, @MappingTarget MobileLine mobileLine);

}
