package com.ey.cms.Controller;

import com.ey.cms.Model.ComputerRequestDTO;
import com.ey.cms.Model.ComputerResponseDTO;
import com.ey.cms.Repository.Repo;
import com.ey.cms.Service.ComputerService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/computers")

public class Controller {
    //Constuctor Injection
    private final ComputerService computerService;

    public Controller(ComputerService computerService) {
        this.computerService = computerService;
    }

    @PostMapping
    public ResponseEntity<ComputerResponseDTO> createComp(@RequestBody ComputerRequestDTO ComReqDTO) {
        ComputerResponseDTO created = computerService.createComp(ComReqDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ComputerResponseDTO>> getAllComputers() {
        List<ComputerResponseDTO> list = computerService.getAllComps();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComputerResponseDTO> getbyId(@PathVariable Long id) {
        ComputerResponseDTO computer = computerService.getByID(id);
        return ResponseEntity.ok(computer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComputerResponseDTO> updatecomp(@PathVariable Long id, @RequestBody ComputerRequestDTO ComReqDTO) {
        ComputerResponseDTO updated = computerService.update(id,ComReqDTO);
        return ResponseEntity.ok(updated);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        computerService.deleteComp(id);
       // return ResponseEntity.ok("deleted")
        return ResponseEntity.noContent().build();
    }
}