package br.com.archtech.apis.models.interfaces;

import br.com.archtech.apis.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {}
