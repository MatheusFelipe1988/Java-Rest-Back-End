package com.springrest.demo2.controller.dto;

import com.springrest.demo2.domain.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class pessoaRH {
    private long id_pessoa;
    private String nome;
    private String sobrenome;


    public static pessoaRH converter(Pessoa p){
        var pessoa = new pessoaRH();
        pessoa.setId_pessoa(p.getId_pessoa());
        pessoa.setNome(p.getNome());
        pessoa.setSobrenome(p.getSobrenome());
        return pessoa;
    }
}
