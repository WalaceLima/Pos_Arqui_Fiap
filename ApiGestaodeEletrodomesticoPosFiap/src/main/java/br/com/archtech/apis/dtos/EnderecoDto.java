package br.com.archtech.apis.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDto {
	private Long codigo;
	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
}
