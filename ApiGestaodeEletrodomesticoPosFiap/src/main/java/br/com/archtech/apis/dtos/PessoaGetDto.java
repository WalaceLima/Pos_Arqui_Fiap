package br.com.archtech.apis.dtos;

import br.com.archtech.apis.models.Eletrodomestico;
import br.com.archtech.apis.models.Pessoa;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
public class PessoaGetDto {

	
	public PessoaGetDto(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.dataNascimento = pessoa.getDataNascimento();
		this.sexo = pessoa.getSexo();
		this.grauParentesco = pessoa.getGrauParentesco();
	}	

	private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String sexo;
    private String grauParentesco;

    private List<Eletrodomestico> eletrodomesticos;
//    @OneToMany(mappedBy = "pessoa",cascade = CascadeType.ALL)
//    private List<Endereco> enderecos;
}
