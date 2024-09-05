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

    /* @PostMapping
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.criarPessoa(pessoa);
    } */

    @PostMapping
    public ResponseEntity<?> criarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa novaPessoa = pessoaService.criarPessoa(pessoa);
        if (novaPessoa == null) {
            return ResponseEntity.badRequest().body("Email inválido");
        }
        return ResponseEntity.ok(novaPessoa);
    }

    @GetMapping
    public List<Pessoa> listarPessoas(){
        return pessoaService.listarPessoas();
    }

    @GetMapping("/{nome}")
    public Pessoa buscarPorNome(@PathVariable String nome) {
        return pessoaService.buscarPorNome(nome);
    }

    @GetMapping("/buscar")
    public Pessoa buscarPorEmail(@RequestParam String email) {
        return  pessoaService.buscarPorEmail(email);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id){
        pessoaService.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }

    // NOVO PUT
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
