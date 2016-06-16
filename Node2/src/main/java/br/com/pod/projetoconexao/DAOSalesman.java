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
public class DAOSalesman implements IDAO<Salesman>{
    private Connection conex;
    
    public DAOSalesman() throws ClassNotFoundException, SQLException{
        conex = new Regras().getConnection();
    }
    
    @Override
    public void Add(Salesman tipo) {
        
     try {
            Statement s = (Statement) conex.createStatement();
            s.execute("insert into Salesman (personid, phone) values ("+ tipo.getPersonid() + ",'" + tipo.getPhone() + "');");
            
            s.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOSalesman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
