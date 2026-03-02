package com.ey.cms.Service;

import com.ey.cms.Entity.CompEntity;
import com.ey.cms.Model.ComputerRequestDTO;
import com.ey.cms.Model.ComputerResponseDTO;
import com.ey.cms.Repository.Repo;
import com.ey.cms.Utils.MapperUtils;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service

public class ComputerService {
    private final Repo repo;

    // Constructor Injection (BEST PRACTICE)
    public ComputerService(Repo repo) {
        this.repo = repo;
    }

    //create computer method
    public  ComputerResponseDTO createComp(ComputerRequestDTO CompReqDTO){
    CompEntity compEntity = MapperUtils.fromReqDTOtoEntity(CompReqDTO);
    CompEntity saved = repo.save(compEntity);
    return MapperUtils.fromEntityToResDTO(saved);
    }

    //delete computer
    public void deleteComp(Long id) {
        //Optional<CompEntity> compEntity = repo.findById(id);
       // repo.deleteById(id);
        repo.findById(id).ifPresent(repo::delete);
    }

    //update computer
    public ComputerResponseDTO update(Long id, ComputerRequestDTO compReqDTO) {

        CompEntity compEntity = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Computer not found with id " + id));

        compEntity.setCompany(compReqDTO.getCompany());
        compEntity.setPrice(compReqDTO.getPrice());
        compEntity.setRAM(compReqDTO.getRAM());

        repo.save(compEntity);

        return MapperUtils.fromEntityToResDTO(compEntity);
    }


    //get all computers
    public List<ComputerResponseDTO> getAllComps (){
         List<CompEntity> allComps = repo.findAll();
         List<ComputerResponseDTO> responseList = new ArrayList<>() ;

         for (CompEntity allComp :allComps){
         ComputerResponseDTO dto= MapperUtils.fromEntityToResDTO(allComp);
             responseList.add(dto);
         }
         return responseList;
    }

    //get by id

    public ComputerResponseDTO getByID (Long id){
        CompEntity compEntity = repo.findById(id)
                .orElseThrow(()->new EntityNotFoundException("id is not found" +id));

        return  MapperUtils.fromEntityToResDTO(compEntity);
    }

}
