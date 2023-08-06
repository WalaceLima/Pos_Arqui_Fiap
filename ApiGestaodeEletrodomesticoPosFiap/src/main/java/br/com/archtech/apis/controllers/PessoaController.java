package br.com.archtech.apis.controllers;

import br.com.archtech.apis.dtos.PessoaDto;
import br.com.archtech.apis.models.interfaces.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository repository;

	@PostMapping
	public void criar(@RequestBody PessoaDto dto) {

		repository.toString();
	}
}
