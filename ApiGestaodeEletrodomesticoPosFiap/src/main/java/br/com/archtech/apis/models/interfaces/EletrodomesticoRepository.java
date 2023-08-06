package br.com.archtech.apis.models.interfaces;

import br.com.archtech.apis.models.Eletrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EletrodomesticoRepository extends JpaRepository<Eletrodomestico,Long> {
}
