package br.edu.ifpb.dac.docker.jsf.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author JuliermeH
 */
@Entity
public class Dependente implements Serializable {
    
    @Id
    private String uuid;
    private String nome;
    @Temporal(TemporalType.DATE)
    private LocalDate dataDeNascimento;

    public Dependente() { }

    public Dependente(String nome, LocalDate dataDeNascimento) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }
    
    public String getUuid() {
        return uuid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
    
    public boolean nomeInvalido() {
        return (nome != null);
    }
    
    public boolean dataInvalida() {
        return (!LocalDate.now().toString().equals(this.dataDeNascimento));
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.uuid);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dependente other = (Dependente) obj;
        if (!Objects.equals(this.uuid, other.uuid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dependente{" + "/n nome: " + nome + "/n dataDeNascimento: " + dataDeNascimento + "/n}";
    }
    
}
