package br.com.archtech.apis.dtos;

import br.com.archtech.apis.models.Eletrodomestico;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class PessoaGetDto {
    private Long id_pessoa;
    private String nome;
    private String cpf;
    //    private LocalDate dataNascimento;
//    private String sexo;
//    private String grauParentesco;
    @OneToMany(mappedBy = "pessoa",cascade = CascadeType.ALL)
    private List<Eletrodomestico> eletrodomesticos;
//    @OneToMany(mappedBy = "pessoa",cascade = CascadeType.ALL)
//    private List<Endereco> enderecos;
}
