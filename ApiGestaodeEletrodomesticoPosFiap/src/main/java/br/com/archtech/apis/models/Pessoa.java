package br.com.archtech.apis.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String sexo;
    private String grauParentesco;

    @OneToMany(mappedBy = "pessoa",cascade = CascadeType.ALL)
    private List<Eletrodomestico> eletrodomesticos;
    
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    

}
