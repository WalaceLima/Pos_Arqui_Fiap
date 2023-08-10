package br.com.archtech.apis.dtos.EletrodomesticoDto;

import br.com.archtech.apis.dtos.PessoaGetDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EletrodomesticoGetDto {

    private Long id_eletrodomestico;

    @Size(min = 2, max = 50, message = "Nome do aparelho deve ter entre 2 e 50 caracteres.")
    @NotBlank(message = "Nome do aparelho é obrigatório.")
    private String nome;

    @Size(min = 2, max = 50, message = "Nome do aparelho deve ter entre 2 e 50 caracteres.")
    @NotBlank(message = "Marca do aparelho é obrigatório.")
    private String marca;

    @Size(min = 2, max = 4, message = "Nome do aparelho deve ter entre 2 e 50 caracteres.")
    @NotBlank(message = "Tensão do aparelho é obrigatório.")
    private Integer tensao;

    private PessoaGetDto pessoa;
}
