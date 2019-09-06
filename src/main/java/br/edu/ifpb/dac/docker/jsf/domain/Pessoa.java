/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.docker.jsf.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author JuliermeH
 */
@Entity
public class Pessoa implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    private String cpf;
    private String nome;
    @OneToOne
    private Dependente dependente;

    public Pessoa() { }

    public Pessoa(String nome, String cpf, Dependente dependente) {
        this.nome = nome;
        this.cpf = cpf;
        this.dependente = dependente;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }
       
}
