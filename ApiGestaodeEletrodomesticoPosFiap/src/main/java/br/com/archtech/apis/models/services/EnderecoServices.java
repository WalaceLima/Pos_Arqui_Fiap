package br.com.archtech.apis.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.archtech.apis.models.Endereco;
import br.com.archtech.apis.models.interfaces.EnderecoRepository;

@Service
public class EnderecoServices {
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Endereco> findAll () {
		List<Endereco> result = enderecoRepository.findAll();
		return result;
	}

	public Endereco buscarPorId(Long id) {
		return enderecoRepository.findById(id).get();
	}

	public void deletarPorId(Long id) {
		enderecoRepository.deleteById(id);
	}
	
	public  Endereco saveAll (Endereco pessoa) {
	  return enderecoRepository.save(pessoa);
	}
}
