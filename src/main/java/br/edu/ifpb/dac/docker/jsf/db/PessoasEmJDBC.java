package br.edu.ifpb.dac.docker.jsf.db;

import br.edu.ifpb.dac.docker.jsf.domain.Dependente;
import br.edu.ifpb.dac.docker.jsf.domain.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JuliermeH
 */
public class PessoasEmJDBC implements Facade {
    
    private Statement stat = (Statement) new Connection();
    private String sql = "";

    @Override
    public void novo(Dependente d) {
        sql = "INSERT INTO Dependente(uuid,nome,dataDeNascimento) VALUES (" +
                d.getUuid() + "," +
                d.getNome() + "," +
                d.getDataDeNascimento() + ");";
        try {
            stat.execute(sql);
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
            stat.execute(sql);
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
            stat.executeUpdate(sql);
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
            stat.executeUpdate(sql);
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
            rs = stat.executeQuery(sql);
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
            rs = stat.executeQuery(sql);
            for(int i=0; rs.getFetchSize() >= i; i++){
                lista.add(rs.getObject(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoasEmJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
