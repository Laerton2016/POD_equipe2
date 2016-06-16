/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pod;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author laerton
 */
public class Main {
   
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        
        Person pessoa = new Person(1, "Joe", "35222786");
        //CadastraVendedor(pessoa);
        Order order = new Order("PD001", 1, 1, 1);
        CadastrarOrdem(order, pessoa);
    }
    
    private static void CadastraVendedor(Person pessoa) throws IOException{
        Cliente node1 = new Cliente("localhost", 1099);
        node1.enviaMensagem(pessoa.toString());
    }
    
    private static void CadastrarOrdem(Order ordem, Person pessoa) throws IOException{
        Cliente node1 = new Cliente("localhost", 1095);
        node1.enviaMensagem(ordem.toString() +"|"+ pessoa.toString());
    }
    
}
