package br.com.archtech.apis.dtos;

import br.com.archtech.apis.models.Eletrodomestico;
import br.com.archtech.apis.models.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {
    private Long id_pessoa;
    private String nome;
    private LocalDate dataNascimento;
    private String sexo;
    private String grauParentesco;
    private List<Eletrodomestico> eletrodomesticos;
    private List<Endereco> enderecos;
}
