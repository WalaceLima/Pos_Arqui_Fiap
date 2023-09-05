package br.com.archtech.apis.controllers;

import br.com.archtech.apis.dtos.EnderecoDto;
import br.com.archtech.apis.models.Endereco;
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
import br.com.archtech.apis.models.services.EnderecoServices;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoServices enderecoServices;
	
	@GetMapping
	public List<EnderecoDto> findAll(){
		List<Endereco> result = enderecoServices.findAll();
		List<EnderecoDto> dto = result.stream().map(x -> new EnderecoDto(x)).toList();
		return dto;
	}

	@GetMapping("/{id}")
	public  ResponseEntity<Endereco> buscarPorId(@PathVariable Long id) {
		Endereco endereco = enderecoServices.buscarPorId(id);
		return ResponseEntity.ok(endereco);
	}

	@DeleteMapping ("/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		try{
			Optional<Endereco> endereco = Optional.ofNullable(enderecoServices.buscarPorId(id));

			if(endereco == null || endereco.isEmpty())
				return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Endereço não encontrado.");

			enderecoServices.deletarPorId(id);

			ResponseEntity<String> body = ResponseEntity.status(HttpStatus.OK).body("Endereço excluído com sucesso.");
			return body;

		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro" + e.getMessage());
		}

	}

	@PutMapping
	public ResponseEntity<String> atualizar(@RequestBody Endereco novoEndereco) {
		try{

			Optional<Endereco> endereco = Optional.ofNullable(enderecoServices.buscarPorId(novoEndereco.getId_endereco()));

			if (endereco == null || endereco.isEmpty()){
				return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
						.body("Endereço não localizado");
			}
			
			endereco.map(item -> {
						item.setRua(novoEndereco.getRua());
						item.setNumero(novoEndereco.getNumero());
						item.setBairro(novoEndereco.getBairro());
						item.setCidade(novoEndereco.getCidade());
						item.setEstado(novoEndereco.getEstado());
						return enderecoServices.saveAll(item);
			}) ;


			return ResponseEntity.status(HttpStatus.OK).body("Endereço atualizada com sucesso!");

		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro:" + e.getMessage());
		}
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Endereco salvar (@Valid @RequestBody Endereco endereco) {
		return enderecoServices.saveAll(endereco);
	}
}
