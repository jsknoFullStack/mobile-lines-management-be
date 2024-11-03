package com.jskno.mobile.lines.mapper;

import com.jskno.mobile.lines.domain.CreateMobileLineDTO;
import com.jskno.mobile.lines.domain.GetMobileLineDTO;
import com.jskno.mobile.lines.domain.GetMobileLineDTO.GetMobileLineDTOBuilder;
import com.jskno.mobile.lines.domain.UpdateMobileLineDTO;
import com.jskno.mobile.lines.entity.MobileLine;
import com.jskno.mobile.lines.entity.MobileLine.MobileLineBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class MobileLineMapperImpl implements MobileLineMapper {

    @Override
    public GetMobileLineDTO mapToGetMobileLineDTO(MobileLine line) {
        if ( line == null ) {
            return null;
        }

        GetMobileLineDTOBuilder getMobileLineDTO = GetMobileLineDTO.builder();

        getMobileLineDTO.user( line.getUserLogin() );
        getMobileLineDTO.id( line.getId() );
        getMobileLineDTO.company( line.getCompany() );
        getMobileLineDTO.telephone( line.getTelephone() );
        getMobileLineDTO.extension( line.getExtension() );
        getMobileLineDTO.registrationDate( line.getRegistrationDate() );
        getMobileLineDTO.cancellationDate( line.getCancellationDate() );
        getMobileLineDTO.notes( line.getNotes() );
        getMobileLineDTO.rate( line.getRate() );

        return getMobileLineDTO.build();
    }

    @Override
    public List<GetMobileLineDTO> mapToGetMobileLineDTO(List<MobileLine> lines) {
        if ( lines == null ) {
            return null;
        }

        List<GetMobileLineDTO> list = new ArrayList<GetMobileLineDTO>( lines.size() );
        for ( MobileLine mobileLine : lines ) {
            list.add( mapToGetMobileLineDTO( mobileLine ) );
        }

        return list;
    }

    @Override
    public MobileLine mapToMobileLineEntity(GetMobileLineDTO getMobileLineDTO) {
        if ( getMobileLineDTO == null ) {
            return null;
        }

        MobileLineBuilder<?, ?> mobileLine = MobileLine.builder();

        mobileLine.userLogin( getMobileLineDTO.user() );
        mobileLine.id( getMobileLineDTO.id() );
        mobileLine.company( getMobileLineDTO.company() );
        mobileLine.telephone( getMobileLineDTO.telephone() );
        mobileLine.extension( getMobileLineDTO.extension() );
        mobileLine.registrationDate( getMobileLineDTO.registrationDate() );
        mobileLine.cancellationDate( getMobileLineDTO.cancellationDate() );
        mobileLine.notes( getMobileLineDTO.notes() );
        mobileLine.rate( getMobileLineDTO.rate() );

        return mobileLine.build();
    }

    @Override
    public MobileLine mapToMobileLineEntity(CreateMobileLineDTO line) {
        if ( line == null ) {
            return null;
        }

        MobileLineBuilder<?, ?> mobileLine = MobileLine.builder();

        mobileLine.userLogin( line.user() );
        mobileLine.company( line.company() );
        mobileLine.telephone( line.telephone() );
        mobileLine.extension( line.extension() );
        mobileLine.registrationDate( line.registrationDate() );
        mobileLine.cancellationDate( line.cancellationDate() );
        mobileLine.notes( line.notes() );
        mobileLine.rate( line.rate() );

        return mobileLine.build();
    }

    @Override
    public MobileLine mergeMobileLine(UpdateMobileLineDTO updateMobileLineDTO, MobileLine mobileLine) {
        if ( updateMobileLineDTO == null ) {
            return null;
        }

        mobileLine.setUserLogin( updateMobileLineDTO.user() );
        mobileLine.setId( updateMobileLineDTO.id() );
        mobileLine.setCompany( updateMobileLineDTO.company() );
        mobileLine.setTelephone( updateMobileLineDTO.telephone() );
        mobileLine.setExtension( updateMobileLineDTO.extension() );
        mobileLine.setRegistrationDate( updateMobileLineDTO.registrationDate() );
        mobileLine.setCancellationDate( updateMobileLineDTO.cancellationDate() );
        mobileLine.setNotes( updateMobileLineDTO.notes() );
        mobileLine.setRate( updateMobileLineDTO.rate() );

        return mobileLine;
    }
}
