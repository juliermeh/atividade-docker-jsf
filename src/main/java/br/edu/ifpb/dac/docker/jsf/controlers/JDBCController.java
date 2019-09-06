package br.edu.ifpb.dac.docker.jsf.controlers;

import br.edu.ifpb.dac.docker.jsf.db.Facade;
import br.edu.ifpb.dac.docker.jsf.db.PessoasEmJDBC;
import br.edu.ifpb.dac.docker.jsf.domain.Dependente;
import br.edu.ifpb.dac.docker.jsf.domain.Pessoa;
import java.util.List;

/**
 *
 * @author JuliermeH
 */
public class JDBCController {
    
    private Pessoa pessoa = new Pessoa();

    private Facade service = new PessoasEmJDBC();

    public String salvar() {
        this.service.nova(pessoa);
        this.pessoa = new Pessoa();
        return "list.xhtml?faces-redirect=true";
    }
    public List<Dependente> todosOsDependentes(){
        return this.service.todos();
    }

    public String atualizar() {
        this.service.atualizar(pessoa);
        this.pessoa = new Pessoa();
        return null;
    }

    /* public String excluir(Pessoa pessoa) {
        this.service.excluir(pessoa);
        return null;
    } */

    public String editar(Pessoa pessoa) {
        this.pessoa = pessoa;
        return null;
    }

    public List<Pessoa> todasAsPessoas() {
        return this.service.todas();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
