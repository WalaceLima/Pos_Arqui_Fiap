package br.com.archtech.apis.models.services;

import br.com.archtech.apis.models.Eletrodomestico;
import br.com.archtech.apis.models.interfaces.EletrodomesticoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EletrodomesticoService {

private final EletrodomesticoRepository eletrodomesticoRepository;

    public void criarEletrodomestico(Eletrodomestico eletrodomestico) {
        eletrodomesticoRepository.save(eletrodomestico);
    }
//    public void atualizarEletrodomestico(Eletrodomestico eletrodomesticoAtualizado) {
//
//        eletrodomesticoRepository.save(eletrodomesticoAtualizado);
//    }
//    public void incrementarEletrodomestico(Eletrodomestico eletrodomestico, int quantidade) {
//        Eletrodomestico eletro = eletrodomesticoRepository.findById(eletrodomestico.getId_eletrodomestico())
//                .orElseThrow(() -> new IllegalArgumentException("Eletrodomestico não encontrado"));
//
//        eletro.setMarca(eletro.getMarca());
//        eletro.setNome(eletro.getNome());
//        eletro.setTensao(eletro.getTensao());
//        eletrodomesticoRepository.save(eletro);
//    }
//    public void apagarEletrodomestico(Eletrodomestico eletrodomestico) {
//        eletrodomesticoRepository.deleteById(eletrodomestico.getId_eletrodomestico());
//    }
}
