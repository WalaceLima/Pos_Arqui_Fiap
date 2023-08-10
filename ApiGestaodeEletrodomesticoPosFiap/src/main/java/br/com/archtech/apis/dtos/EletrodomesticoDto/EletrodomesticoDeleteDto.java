package br.com.archtech.apis.dtos.EletrodomesticoDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EletrodomesticoDeleteDto {

    private Long id_eletrodomestico;

    @Size(min = 2, max = 50, message = "Nome do aparelho deve ter entre 2 e 50 caracteres.")
    @NotBlank(message = "Nome do aparelho é obrigatório.")
    private String nome;
}
