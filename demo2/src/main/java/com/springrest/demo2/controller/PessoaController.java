package com.springrest.demo2.controller;

import com.springrest.demo2.controller.dto.pessoaRH;
import com.springrest.demo2.controller.dto.pessoaRQ;
import com.springrest.demo2.domain.Pessoa;
import com.springrest.demo2.repositorio.PessoaRepository;
import com.springrest.demo2.repositorio.PessoaCustomRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
public class PessoaController{

    private final PessoaRepository pessoaRepository;
    private final PessoaCustomRepository pessoaCustomRepository;

    public PessoaController(PessoaRepository pessoaRepository, PessoaCustomRepository pessoaCustomRepository) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaCustomRepository = pessoaCustomRepository;
    }


    @GetMapping("/")
    public List<pessoaRH> findAll(){
        var pessoas = pessoaRepository.findAll();
        return pessoas.stream().map(pessoaRH::converter).collect(Collectors.toList());
    }
    @GetMapping("{id}")
    public pessoaRH findById(@PathVariable("id") Long id) {
        var pessoa = pessoaRepository.getOne(id);
        return pessoaRH.converter(pessoa);
    }
    @PostMapping("/")
    public void personSave(@RequestBody pessoaRQ pessoa){
        var p = new Pessoa();
        p.setNome(pessoa.getNome());
        p.setSobrenome(pessoa.getSobrenome());
        pessoaRepository.save(p);
    }
    @PutMapping("/{id}")
    public void updatePerson(@PathVariable("id") Long id,@RequestBody pessoaRQ pessoa)throws Exception{
        var p = pessoaRepository.findById(id);

        if (p.isPresent()){
            var pessoaSave = p.get();
            pessoaSave.setNome(pessoa.getNome());
            pessoaSave.setSobrenome(pessoa.getSobrenome());
            pessoaRepository.save(pessoaSave);
        }else{
            throw new Exception("Pessoa nao encontrada");
        }
    }
    @GetMapping("/filter")
    public List<pessoaRH> findPersonByName(@RequestParam("name") String name){
        return this.pessoaRepository.findByNomeContains(name)
                .stream()
                .map(pessoaRH::converter)
                .collect(Collectors.toList());
    }
    @GetMapping("/filter/custom")
    public List<pessoaRH> findPersonByCustom(
            @RequestParam(value = "id",required = false)Long id,
            @RequestParam(value = "name", required = false)String name,
            @RequestParam(value = "sobrenome",required = false)String sobrenome
    ){
        return this.pessoaCustomRepository.find(id,name,sobrenome)
                .stream()
                .map(pessoaRH::converter)
                .collect(Collectors.toList());

    }
}