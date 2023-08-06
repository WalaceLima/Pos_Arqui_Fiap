package br.com.archtech.apis.models.interfaces;

import br.com.archtech.apis.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {}
