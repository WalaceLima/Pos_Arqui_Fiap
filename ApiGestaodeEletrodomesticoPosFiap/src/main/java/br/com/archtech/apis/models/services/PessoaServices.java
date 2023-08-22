package br.com.archtech.apis.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.archtech.apis.models.Pessoa;
import br.com.archtech.apis.models.interfaces.PessoaRepository;

@Service
public class PessoaServices {
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> findAll () {
		List<Pessoa> result = pessoaRepository.findAll();
		return result;
	}

	public Pessoa buscarPorId(Long id) {
		return pessoaRepository.findById(id).get();
	}

	public void deletarPorId(Long id) {
		pessoaRepository.deleteById(id);
	}
	
	public  Pessoa saveAll (Pessoa pessoa) {
	  return pessoaRepository.save(pessoa);
	}
}
