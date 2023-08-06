package br.com.archtech.apis.models;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_endereco;
	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	@ManyToOne
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa;

}
