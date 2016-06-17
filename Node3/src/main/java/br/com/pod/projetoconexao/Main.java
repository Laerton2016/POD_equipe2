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
        Servidor server = new Servidor(1098);
        //processa a mensagem e registra os dados no banco
        server.processaMensagem();
        Cliente client = new Cliente("localhost", 1097);
        //Verifica se a mensagem tem dados para encaminhar para node 2 e encaminha
        server.encaminhaMensagem(client);
    }
    
}
