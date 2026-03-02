package com.ey.cms.Utils;

import com.ey.cms.Entity.CompEntity;
import com.ey.cms.Model.ComputerRequestDTO;
import com.ey.cms.Model.ComputerResponseDTO;

public class MapperUtils {
    public static CompEntity fromReqDTOtoEntity(ComputerRequestDTO DTO){
        if(DTO==null){return null;}
        CompEntity e= new CompEntity();
        e.setCompany(DTO.getCompany());
        e.setPrice(DTO.getPrice());
        e.setRAM(DTO.getRAM());
        return e;
    }
    public static ComputerResponseDTO fromEntityToResDTO(CompEntity e){
        if(e==null){return null;}
        ComputerResponseDTO DTO= new ComputerResponseDTO();
        DTO.setId(e.getId());
        DTO.setCompany(e.getCompany());
        DTO.setPrice(e.getPrice());
        DTO.setRAM(e.getRAM());
        return DTO;
    }

}
