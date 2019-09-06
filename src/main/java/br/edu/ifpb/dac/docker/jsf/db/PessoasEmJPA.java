package br.edu.ifpb.dac.docker.jsf.db;

import br.edu.ifpb.dac.docker.jsf.domain.Dependente;
import br.edu.ifpb.dac.docker.jsf.domain.Pessoa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author JuliermeH
 */
@Stateless
public class PessoasEmJPA implements Facade {
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void novo(Dependente d) {
        em.persist(d);
    }
    
    @Override
    public void atualizar(Dependente d) {
        em.merge(d);
    }

    @Override
    public List<Dependente> todos() {
        return em.createQuery("FROM Dependente d",Dependente.class)
            .getResultList();
    }
    
    @Override
    public void nova(Pessoa p) {
        em.persist(p);
    }
    
    @Override
    public void atualizar(Pessoa p) {
        em.merge(p);
    }

    @Override
    public List<Pessoa> todas() {
        return em.createQuery("FROM Pessoa p",Pessoa.class)
            .getResultList();
    }
    
    @Override
    public Pessoa pesquisarPorCPF(String cpf) {
        return em.find(Pessoa.class, cpf);
    }

    @Override
    public void excluir(Pessoa p) {
        em.remove(p);
    }
    
}
