package br.edu.ifpb.dac.docker.jsf.db;

import java.beans.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.inject.Singleton;

/**
 *
 * @author JuliermeH
 */
@Singleton
public class Connection {
    
    private java.sql.Connection con;
    private Statement stmt;
    private Config config;

    public Connection() {
        try{
            con = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword());
            stmt = (Statement) con.createStatement();
         
        }catch(SQLException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }
    
}
