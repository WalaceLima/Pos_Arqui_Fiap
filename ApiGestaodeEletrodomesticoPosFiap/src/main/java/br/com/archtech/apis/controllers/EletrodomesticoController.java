package br.com.archtech.apis.controllers;

import br.com.archtech.apis.dtos.EletrodomesticoDto;
import br.com.archtech.apis.models.Eletrodomestico;
import br.com.archtech.apis.models.interfaces.EletrodomesticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @Autowired
    EletrodomesticoRepository eletrodomesticoRepository;
    //private final EletrodomesticoService eletrodomesticoService;

    @GetMapping
    public ResponseEntity<List<EletrodomesticoDto>> listarEletrodomesticos() {
        try {
            List<EletrodomesticoDto> resultado = new ArrayList<EletrodomesticoDto>();
            for (Eletrodomestico eletrodomestico : eletrodomesticoRepository.findAll()) {
                EletrodomesticoDto eletrodomesticoDto = new EletrodomesticoDto();
                eletrodomesticoDto.setId_eletrodomestico(eletrodomestico.getId_eletrodomestico());
                eletrodomesticoDto.setNome(eletrodomestico.getNome());
                eletrodomesticoDto.setMarca(eletrodomestico.getMarca());
                eletrodomesticoDto.setTensao(eletrodomestico.getTensao());

//                eletrodomesticoDto.setPessoa(new PessoaDto());
//
//                eletrodomesticoDto.getPessoa().setId_pessoa(eletrodomestico.getPessoa().getId_pessoa());
//                eletrodomesticoDto.getPessoa().setNome(eletrodomestico.getPessoa().getNome());
//                eletrodomesticoDto.getPessoa().setSexo(eletrodomestico.getPessoa().getSexo());
//                eletrodomesticoDto.getPessoa().setDataNascimento(eletrodomestico.getPessoa().getDataNascimento());
//                eletrodomesticoDto.getPessoa().setGrauParentesco(eletrodomestico.getPessoa().getGrauParentesco());

                resultado.add(eletrodomesticoDto);
            }
            return ResponseEntity.status(HttpStatus.OK).body(resultado);
        } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
    @GetMapping("/{id}")
    public ResponseEntity<EletrodomesticoDto> buscarEletrodomesticos(@PathVariable("id_eletrodomestico")Long id_eletrodomestico){
        try {
            Optional<Eletrodomestico> resultado = eletrodomesticoRepository.findById(id_eletrodomestico);
            if (resultado == null || resultado.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            } else {
                Eletrodomestico eletrodomestico = resultado.get();
                EletrodomesticoDto eletrodomesticoDto = new EletrodomesticoDto();
                eletrodomesticoDto.setId_eletrodomestico(eletrodomestico.getId_eletrodomestico());
                eletrodomesticoDto.setMarca(eletrodomestico.getMarca());
                eletrodomesticoDto.setNome(eletrodomestico.getNome());
                eletrodomesticoDto.setTensao(eletrodomestico.getTensao());
                return ResponseEntity.status(HttpStatus.OK).body(eletrodomesticoDto);
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }
@PostMapping
public ResponseEntity<String> criarEletrodomestico(@RequestBody EletrodomesticoDto eletrodomesticoDto){
        try {
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
    //ToDo
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarEletrodomestico(@PathVariable("id")Long id,@RequestBody EletrodomesticoDto eletrodomesticoDto){
        try{
            Optional<Eletrodomestico> buscarEletrodomesticos= eletrodomesticoRepository.findById(eletrodomesticoDto.getId_eletrodomestico());
            if (buscarEletrodomesticos == null || buscarEletrodomesticos.isEmpty()){
                    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Eletrodomestico não localizado");
            }
            Eletrodomestico atualizarEletro= buscarEletrodomesticos.get();
            atualizarEletro.setMarca(eletrodomesticoDto.getMarca());
            atualizarEletro.setNome(eletrodomesticoDto.getNome());
            atualizarEletro.setTensao(eletrodomesticoDto.getTensao());
            eletrodomesticoRepository.save(atualizarEletro);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Atualizado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro" + e.getMessage());
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
    public ResponseEntity<String> apagarEletrodomestico(@PathVariable("id")Long id) {
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
