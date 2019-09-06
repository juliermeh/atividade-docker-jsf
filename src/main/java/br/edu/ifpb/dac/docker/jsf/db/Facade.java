package br.edu.ifpb.dac.docker.jsf.db;

import br.edu.ifpb.dac.docker.jsf.domain.Dependente;
import br.edu.ifpb.dac.docker.jsf.domain.Pessoa;
import java.util.List;

/**
 *
 * @author JuliermeH
 */
public interface Facade {
    
    public void novo(Dependente d);
    public void atualizar(Dependente d);
    public List<Dependente> todos();
    public void nova(Pessoa p);
    public void atualizar(Pessoa p);
    public List<Pessoa> todas();
    public void excluir(Pessoa p);
    public Pessoa pesquisarPorCPF(String cpf);
    
}
