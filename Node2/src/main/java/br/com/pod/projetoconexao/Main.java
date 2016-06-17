/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pod.projetoconexao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laerton
 */
public class Main {
    private static Regras regras;
    private static Cliente _client;
    private static Servidor _server;
    public Main(Cliente cliente){
        this._client = cliente;
    }
    public static void main(String[] args) 
            throws ClassNotFoundException, SQLException, IOException {
        _server = new Servidor(1097);
         //processa a mensagem e registra os dados no banco
        _server.processaMensagem();
        try {
            _client = new Cliente("localhost", 1099);
            _server.encaminhaMensagem(_client);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        
    }

    
    
}
