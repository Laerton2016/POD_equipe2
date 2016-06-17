/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pod.projetoconexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laerton
 */
public class DAOOrder implements IDAO<Order>{
    private Connection conex;
    
    public DAOOrder() throws ClassNotFoundException, SQLException{
        conex = new Regras().getConnection();
    }
    
    @Override
    public void Add(Order tipo) {
        
     try {
            Statement s = (Statement) conex.createStatement();
            s.execute("insert into order1 (id, salesmanid, productid, quantity) values ('"+
                    tipo.getId() + "'," + tipo.getSalesmanis() + "," + tipo.getProductid() +
                    "," + tipo.getQuantity() + ");");
            
            s.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
