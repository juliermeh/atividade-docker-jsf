package br.edu.ifpb.dac.docker.jsf.db;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.inject.Singleton;

/**
 *
 * @author JuliermeH
 */
@Singleton
public class ConnectionDB {
    
    private java.sql.Connection con;
    private Config config;

    public ConnectionDB() {
        try{
            con = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword());
        }catch(SQLException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }
    
}
