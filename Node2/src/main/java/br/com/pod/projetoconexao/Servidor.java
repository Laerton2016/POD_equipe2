/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pod.projetoconexao;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author laerton
 */
public class Servidor {
    private ServerSocket _serverSocket;
    private InetSocketAddress _porta;
    private Socket _socket;
    private InputStream _input;
    private Mensagem mensagem;
    private Salesman _salesman;
    private Person _person;
    
    public Servidor(int porta) throws IOException{
        _salesman = new Salesman();
        _person = new Person();
        _serverSocket = new ServerSocket();
        this._porta = new InetSocketAddress(porta);
        _serverSocket.bind(_porta);
        _socket = _serverSocket.accept();
        System.out.println("Server : cliente conectado...");
        
     }
     
    public void close() throws IOException{
        _socket.close();
    }
     
    
     
     
     public void retornaMensagem(String mensagem) throws IOException
     {
       _socket.getOutputStream().write(mensagem.getBytes());   
     }
     
     public String exibeMensagemtexto() throws IOException{
        _input = _socket.getInputStream();
        byte[] b = new byte[1024];
        _input.read(b);
        return new String(b).trim();
     }
     
    public Salesman getSalesman() throws IOException{
        return _salesman;
    }
    
    
    
    private void montaMensagem(Socket socket) throws IOException {
       Scanner s = new Scanner(socket.getInputStream()).useDelimiter("\\|");
       List<String> dados = new ArrayList<String>();

        while (s.hasNext()) {
            dados.add(s.next());
        }
        if (dados.size() > 0)
        {
            if (dados.size() == 2){
            _salesman.setPersonid(Integer.parseInt(dados.get(0)));
            _salesman.setPhone(dados.get(1));
            
        }else
        {
            _person.setId(Integer.parseInt(dados.get(0)));
            _person.setNome(dados.get(1));
            _person.setPhone(dados.get(2));
            _salesman.setPersonid(Integer.parseInt(dados.get(0)));
            _salesman.setPhone(dados.get(2));
        }
        }
        
        
        
    }

    void processaMensagem() throws ClassNotFoundException, SQLException, IOException {
        montaMensagem(_socket);
        if (_salesman.getPersonid() !=0){
            DAOSalesman dao = new DAOSalesman();
            dao.Add(_salesman);
        }
        
    }

    void encaminhaMensagem(Cliente client) throws IOException {
        if (_person.getId()!=0){
            client.enviaMensagem(_person.getId() +
                "|" + _person.getNome()+"|" + _person.getPhone());
        }
        
    }
}
