package csw.estoquecsw.controller;

import csw.estoquecsw.dto.EstoqueDTO;
import csw.estoquecsw.model.EstoqueModel;
import csw.estoquecsw.service.EstoqueService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/estoque_csw")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping(value = "listartodos")
    public List<EstoqueModel>getAllProdutos(){
        return estoqueService.findAll();
    }

    @PostMapping
    public ResponseEntity<Object>saveProduto(@RequestBody @Valid EstoqueDTO estoqueDTO){

        var estoqueModel = new EstoqueModel();
        BeanUtils.copyProperties(estoqueDTO, estoqueModel);
        if (!estoqueModel.getSituacao().equalsIgnoreCase("vendido") && !estoqueModel.getSituacao().equalsIgnoreCase("em estoque")) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Illegal argument, return only 'vendido' or 'em estoque'...");
        }

        if(estoqueService.existsByProduto(estoqueDTO.getProduto())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Product already exists!");
        }
        if(estoqueService.existsBySku(estoqueDTO.getSku())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Sku already exists!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(estoqueService.save(estoqueModel));


    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Object> getProduto(@PathVariable(value="id") Integer id){

        Optional<EstoqueModel>estoqueModelOptional=estoqueService.findByIdProduto(id);
        if(estoqueModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(estoqueModelOptional.get());
        }

    }
    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Object> deletProduto(@PathVariable(value="id") Integer id){

        Optional<EstoqueModel>estoqueModelOptional=estoqueService.findByIdProduto(id);
        if(estoqueModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }else{
            estoqueService.deletById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Product deleted succesfully!");
        }

    }
    @PutMapping(value ="/{id}")
    public ResponseEntity<Object> updateProduto(@PathVariable(value="id") Integer id,@RequestBody EstoqueDTO estoqueDTO){

        Optional<EstoqueModel>estoqueModelOptional=estoqueService.findByIdProduto(id);
        if(estoqueModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }else{
            var estoqueModel=new EstoqueModel();
            estoqueModel.setProduto(estoqueDTO.getProduto());
            estoqueModel.setSituacao(estoqueDTO.getSituacao());
            estoqueModel.setVolumeQtd(estoqueDTO.getVolumeQtd());
            estoqueModel.setValorCp(estoqueDTO.getValorCp());
            estoqueModel.setValorVd(estoqueDTO.getValorVd());
            estoqueModel.setSku(estoqueDTO.getSku());


            return ResponseEntity.status(HttpStatus.OK).body(estoqueService.save(estoqueModel));
        }

    }



}
