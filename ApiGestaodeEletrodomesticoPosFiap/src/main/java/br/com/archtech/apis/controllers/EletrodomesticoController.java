package br.com.archtech.apis.controllers;

import br.com.archtech.apis.dtos.EletrodomesticoDto.EletrodomesticoGetDto;
import br.com.archtech.apis.dtos.EletrodomesticoDto.EletrodomesticoPostDto;
import br.com.archtech.apis.dtos.EletrodomesticoDto.EletrodomesticoPutDto;
import br.com.archtech.apis.dtos.PessoaGetDto;
import br.com.archtech.apis.models.Eletrodomestico;
import br.com.archtech.apis.models.interfaces.EletrodomesticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//@AllArgsConstructor
@Service
@RestController
@RequestMapping(path = "/api/eletrodomesticos", produces = MediaType.APPLICATION_JSON_VALUE)
public class EletrodomesticoController {
    //pg 498
    @Autowired
    EletrodomesticoRepository  eletrodomesticoRepository;
   // private final EletrodomesticoService eletrodomesticoService;

    @GetMapping
    public ResponseEntity<List<EletrodomesticoGetDto>> get() {
        try {
            List<EletrodomesticoGetDto> resultado = new ArrayList<EletrodomesticoGetDto>();

            for (Eletrodomestico eletrodomestico : eletrodomesticoRepository.findAll()) {

                EletrodomesticoGetDto eletrodomesticoDto = new EletrodomesticoGetDto();

                eletrodomesticoDto.setId_eletrodomestico(eletrodomestico.getId_eletrodomestico());
                eletrodomesticoDto.setMarca(eletrodomestico.getMarca());
                eletrodomesticoDto.setNome(eletrodomestico.getNome());
                eletrodomesticoDto.setTensao(eletrodomestico.getTensao());

//                eletrodomesticoDto.setPessoa(new PessoaGetDto());
//                eletrodomesticoDto.getPessoa().setId_pessoa(eletrodomestico.getPessoa().getId_pessoa());
//                eletrodomesticoDto.getPessoa().setNome(eletrodomestico.getPessoa().getNome());
//                eletrodomesticoDto.getPessoa().setCpf(eletrodomestico.getPessoa().getCpf());

                resultado.add(eletrodomesticoDto);
            }
            return ResponseEntity.status(HttpStatus.OK).body(resultado);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
}
    @GetMapping("/{id}")// pg 511
    public ResponseEntity<String> getById(@PathVariable("id")Long id){

            try{
                Optional<Eletrodomestico> resultado=eletrodomesticoRepository.findById(id);
                if(resultado == null || resultado.isEmpty()){
                    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Eletrodomestico não encontrado.");
                }
                Eletrodomestico eletrodomestico=resultado.get();
                eletrodomesticoRepository.delete(eletrodomestico);
                return ResponseEntity.status(HttpStatus.OK)
                        .body("Eletrodoméstico excluído com sucesso.");
            }catch (Exception e){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Erro" + e.getMessage());
            }
    }
@PostMapping
public ResponseEntity<String> post(@RequestBody EletrodomesticoPostDto eletrodomesticoDto){
        try {
            //validar se CPF já cadastrado
            //if(eletrodomesticoRepository.findById(eletrodomesticoDto){}
            Eletrodomestico eletrodomestico= new Eletrodomestico();
            eletrodomestico.setNome(eletrodomesticoDto.getNome());
            eletrodomestico.setMarca(eletrodomesticoDto.getMarca());
            eletrodomestico.setTensao(eletrodomesticoDto.getTensao());
            eletrodomesticoRepository.save(eletrodomestico);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(eletrodomestico.getNome()+", cadastrado com Sucesso!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
        }
}

    @PutMapping
    public ResponseEntity<String> put(@RequestBody EletrodomesticoPutDto eletrodomesticoDto){
        try{
            Optional<Eletrodomestico> buscar= eletrodomesticoRepository.findById(eletrodomesticoDto.getId_eletrodomestico());
            if (buscar == null || buscar.isEmpty()){
                    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                            .body("Eletrodoméstico não localizado");
            }
            Eletrodomestico atualizarEletro= buscar.get();
            atualizarEletro.setNome(eletrodomesticoDto.getNome());
            atualizarEletro.setMarca(eletrodomesticoDto.getMarca());
            atualizarEletro.setTensao(eletrodomesticoDto.getTensao());
            eletrodomesticoRepository.save(atualizarEletro);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Eletrodoméstico atualizado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro:" + e.getMessage());
        }
    }
       @PatchMapping ("/{id}")
    public ResponseEntity<String> incrementarEletrodomestico(@PathVariable("id_eletrodomestico")Long id_eletrodomestico,@RequestBody Eletrodomestico eletrodomestico){
        try{
            Optional<Eletrodomestico> incrementarEletro= eletrodomesticoRepository.findById(eletrodomestico.getId_eletrodomestico());
            if (incrementarEletro == null || incrementarEletro.isEmpty()){
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Eletrodomestico não localizado");
            }
            Eletrodomestico atualizarEletro= incrementarEletro.get();
            atualizarEletro.setMarca(eletrodomestico.getMarca());
            atualizarEletro.setNome(eletrodomestico.getNome());
            atualizarEletro.setTensao(eletrodomestico.getTensao());
            eletrodomesticoRepository.save(atualizarEletro);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Atualizado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro" + e.getMessage());
        }
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<String> apagar(@PathVariable("id")Long id) {
        try{
            Optional<Eletrodomestico> resultado=eletrodomesticoRepository.findById(id);
            if(resultado == null || resultado.isEmpty()){
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Eletrodomestico não encontrado.");
            }
            Eletrodomestico eletrodomestico=resultado.get();
            eletrodomesticoRepository.delete(eletrodomestico);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Eletrodoméstico excluído com sucesso.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro" + e.getMessage());
        }

    }
}
