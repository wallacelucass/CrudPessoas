package com.meuprojeto.crudpessoas.Service;

import com.meuprojeto.crudpessoas.Model.Pessoa;
import com.meuprojeto.crudpessoas.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    // Validador email
    public Pessoa criarPessoa(Pessoa pessoa) {
        if (!emailValido(pessoa.getEmail())) {
            return null;
        }
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }

    public Pessoa buscarPorNome(String nome){
        return pessoaRepository.findByName(nome);
    }

    public Pessoa buscarPorEmail(String email){
        return pessoaRepository.findByEmail(email);
    }

    // Validador email
    public boolean emailValido(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    // NOVO PUT
    public Pessoa atualizarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

}
