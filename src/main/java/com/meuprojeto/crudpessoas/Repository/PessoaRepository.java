package com.meuprojeto.crudpessoas.Repository;

import com.meuprojeto.crudpessoas.Model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByNome(String nome);

    Pessoa findByEmail(String email);
}
