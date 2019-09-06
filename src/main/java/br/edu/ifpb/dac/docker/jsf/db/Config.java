package br.edu.ifpb.dac.docker.jsf.db;

/**
 *
 * @author JuliermeH
 */
public class Config {
    
    /*
    *    Qual a necessidade disso?
    *    Para fazer estabelecer a conexão do banco com a aplicação, dobe
    *    O banco estará disponível via docker
    *    Se liga!
    */
    
    private final String url = "jdbc:postgresql://host-banco:5432/docker-jsf";
    private final String user = "postgres";
    private final String password = "root";

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
    
}
