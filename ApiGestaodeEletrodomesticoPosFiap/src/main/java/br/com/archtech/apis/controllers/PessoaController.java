package br.com.archtech.apis.controllers;

import br.com.archtech.apis.dtos.PessoaGetDto;
import br.com.archtech.apis.models.Pessoa;
import br.com.archtech.apis.models.interfaces.PessoaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.archtech.apis.models.services.PessoaServices;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaServices pessoaServices;
	
	@GetMapping
	public List<PessoaGetDto> findAll(){
		List<Pessoa> result = pessoaServices.findAll();
		List<PessoaGetDto> dto = result.stream().map(x -> new PessoaGetDto(x)).toList();
		return dto;
	}

	@GetMapping("/{id}")
	public  ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id) {
		Pessoa pessoa = pessoaServices.buscarPorId(id);
		return ResponseEntity.ok(pessoa);
	}

	@DeleteMapping ("/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		try{
			Optional<Pessoa> pessoa = Optional.ofNullable(pessoaServices.buscarPorId(id));

			if(pessoa == null || pessoa.isEmpty())
				return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Pessoa não encontrada.");

			pessoaServices.deletarPorId(id);

			ResponseEntity<String> body = ResponseEntity.status(HttpStatus.OK).body("Pessoa excluída com sucesso.");
			return body;

		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro" + e.getMessage());
		}

	}

	@PutMapping
	public ResponseEntity<String> atualizar(@RequestBody Pessoa novaPessoa) {
		try{

			Optional<Pessoa> pessoa = Optional.ofNullable(pessoaServices.buscarPorId(novaPessoa.getId()));

			if (pessoa == null || pessoa.isEmpty()){
				return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
						.body("Pessoa não localizada");
			}
			pessoa.map(item -> {
						item.setSexo(novaPessoa.getSexo());
						item.setNome(novaPessoa.getNome());
						item.setDataNascimento(novaPessoa.getDataNascimento());
						item.setGrauParentesco(novaPessoa.getGrauParentesco());
						return pessoaServices.saveAll(item);
			}) ;


			return ResponseEntity.status(HttpStatus.OK).body("Pessoa atualizada com sucesso!");

		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro:" + e.getMessage());
		}
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa salvar (@Valid @RequestBody Pessoa pessoa) {
		return pessoaServices.saveAll(pessoa);
	}
}
