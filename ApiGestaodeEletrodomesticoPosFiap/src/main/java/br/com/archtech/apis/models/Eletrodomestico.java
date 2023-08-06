package br.com.archtech.apis.models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Eletrodomestico {
     @Id
     @GeneratedValue
     private Long id_eletrodomestico;
     private String nome;
     private String marca;
     private Integer tensao;
     @ManyToOne
     @JoinColumn(name="pessoa_id")
     private Pessoa pessoa;
}
