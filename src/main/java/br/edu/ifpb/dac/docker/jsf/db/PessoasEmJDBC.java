package br.edu.ifpb.dac.docker.jsf.db;

import br.edu.ifpb.dac.docker.jsf.domain.Dependente;
import br.edu.ifpb.dac.docker.jsf.domain.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JuliermeH
 */
public class PessoasEmJDBC implements Facade {
    
    private Connection con = (Connection) new ConnectionDB();
    private PreparedStatement stat;
    private String sql = "";

    @Override
    public void novo(Dependente d) {
        sql = "INSERT INTO Dependente(uuid,nome,dataDeNascimento) VALUES (" +
                d.getUuid() + "," +
                d.getNome() + "," +
                d.getDataDeNascimento() + ");";
        try {
            con.createStatement().execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PessoasEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void nova(Pessoa p) {
        sql = "INSERT INTO Pessoa(id,nome,dependente) VALUES (" +
                p.getId() + "," +
                p.getNome() + "," +
                p.getDependente().getUuid() + ");";
        try {
            con.createStatement().execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PessoasEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void atualizar(Dependente d) {
        /* sql = "INSERT INTO Dependente(uuid,nome,dataDeNascimento) VALUES (" +
                d.getUuid() + "," +
                d.getNome() + "," +
                d.getDataDeNascimento() + ");"; */
        try {
            con.createStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PessoasEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void atualizar(Pessoa p) {
        /* sql = "INSERT INTO Pessoa(id,nome,dependente) VALUES (" +
                p.getId() + "," +
                p.getNome() + "," +
                p.getDependente().getUuid() + ");"; */
        try {
            con.createStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PessoasEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public ArrayList todos() {
        sql = "SELECT * FROM Dependente";
        ResultSet rs;
        ArrayList lista = new ArrayList<>();
        try {
            rs = con.createStatement().executeQuery(sql);
            for(int i=0; rs.getFetchSize() >= i; i++){
                lista.add(rs.getObject(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoasEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    @Override
    public ArrayList todas() {
        sql = "SELECT * FROM Pessoa";
        ResultSet rs;
        ArrayList lista = new ArrayList<>();
        try {
            rs = con.createStatement().executeQuery(sql);
            for(int i=0; rs.getFetchSize() >= i; i++){
                lista.add(rs.getObject(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoasEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    @Override
    public Pessoa pesquisarPorCPF(String cpf) {
        sql = "SELECT p FROM Pessoa WHERE cpf = " + cpf;
        Pessoa p = null;
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            p = (Pessoa) rs.getObject(1);
        } catch (SQLException ex) {
            Logger.getLogger(PessoasEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public void excluir(Pessoa p) {
        sql = "DELETE FROM Pessoa p WHERE p.id =" + p.getId();
        try {
            con.createStatement().execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PessoasEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
