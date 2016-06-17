
package br.com.pod.projetoconexao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author laerton
 */
public class Regras {
    
    private Connect conex;
    private static final String user = "postgres";
    private static final String senha = "postgres";
    private static final String url = "jdbc:postgresql://localhost:5432/db_node_3"; 
    
    public Regras() throws ClassNotFoundException, SQLException
    {
        conex = Connect.getInstance(url, user, senha);
    }
    
    public Connect getConex(){
        return conex;
    }
    public Connection getConnection(){
        return conex.getConnect();
    }
}
