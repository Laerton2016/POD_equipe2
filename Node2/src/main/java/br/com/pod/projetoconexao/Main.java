/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pod.projetoconexao;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author laerton
 */
public class Main {
    private static Regras regras;
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Servidor server = new Servidor(1099);
        regras = new Regras();
        
        Cliente client = new Cliente("x.x.x.x", 1097);
    }
    
}
