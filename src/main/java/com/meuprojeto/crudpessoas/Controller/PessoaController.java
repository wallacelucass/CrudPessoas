package com.meuprojeto.crudpessoas.Controller;

import com.meuprojeto.crudpessoas.Model.Pessoa;
import com.meuprojeto.crudpessoas.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    // Comentários do código anterior:
    // Chamar o pessoaRepository na classe Service ✔
    // Antes de chamar o metodo que persiste, verificar se o campo email contem pelo menos um "." e apenas um "@" ✔
    // O controller não acessa o repository, essa responsabilidade é do Service ✔
    // Endpoint GET utilizando @PathVariable buscando por nome ✔
    // Endpoint GET utilizando @RequestParam buscando por email ✔
    // Estudar sobre injeção de dependencias via construtor privado. Como seria feita a injeção de mais de uma dependencia?

    // Cria pessoa antigo
    /* @PostMapping
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.criarPessoa(pessoa);
    } */

    // Cria uma pessoa, verificando se o email possui pelo menos um "@" e um ".", caso contrario retorna "Email inválido"
    @PostMapping
    public ResponseEntity<?> criarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa novaPessoa = pessoaService.criarPessoa(pessoa);
        if (novaPessoa == null) {
            return ResponseEntity.badRequest().body("Email inválido");
        }
        return ResponseEntity.ok(novaPessoa);
    }

    // Lista todas as pessoas criadas
    @GetMapping
    public List<Pessoa> listarPessoas(){
        return pessoaService.listarPessoas();
    }

    // Busca pessoas através do nome
    @GetMapping("/buscar/{nome}")
    public Pessoa buscarPorNome(@PathVariable String nome) {
        return pessoaService.buscarPorNome(nome);
    }

    // Busca pessoas através do email
    @GetMapping("/buscar")
    public Pessoa buscarPorEmail(@RequestParam String email) {
        return  pessoaService.buscarPorEmail(email);
    }

    // Deleta pessoas através do ID
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id){
        pessoaService.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }

    // Atualiza pessoas através do nome
    @PutMapping("/atualizar/{nome}")
    public ResponseEntity<Pessoa> atualizarPessoaPorNome(@PathVariable String nome, @RequestBody Pessoa pessoaAtualizada) {
        Pessoa pessoaExistente = pessoaService.buscarPorNome(nome);
        if (pessoaExistente == null) {
            return ResponseEntity.notFound().build();
        }
        pessoaExistente.setNome(pessoaAtualizada.getNome());
        pessoaExistente.setEmail(pessoaAtualizada.getEmail());
        Pessoa pessoaAtualizadaFinal = pessoaService.atualizarPessoa(pessoaExistente);
        return ResponseEntity.ok(pessoaAtualizadaFinal);
    }


}
