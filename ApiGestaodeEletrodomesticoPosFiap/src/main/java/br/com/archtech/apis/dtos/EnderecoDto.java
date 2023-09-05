package br.com.archtech.apis.dtos;

import br.com.archtech.apis.models.Endereco;
import br.com.archtech.apis.models.Pessoa;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EnderecoDto {
	private Long id;
	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;

	public EnderecoDto(Endereco endereco) {
		this.id = endereco.getId_endereco();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
	}
	
	
}
