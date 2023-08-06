package br.com.archtech.apis.controllers;

import br.com.archtech.apis.dtos.EnderecoDto;
import br.com.archtech.apis.models.interfaces.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@PostMapping
	public void criar(@RequestBody EnderecoDto enderecoDto) {

		enderecoRepository.toString();
	}
}
