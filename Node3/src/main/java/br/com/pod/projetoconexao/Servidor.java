/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pod.projetoconexao;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;
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
    private Person person;
    private Order order;

    public Servidor(int porta) throws IOException {
        person = new Person();
        order = new Order();

        _serverSocket = new ServerSocket();
        this._porta = new InetSocketAddress(porta);
        _serverSocket.bind(_porta);
        _socket = _serverSocket.accept();
        System.out.println("Server : cliente conectado...");

    }

    public void leMensagem() throws IOException {
        montaMensagem(_socket);
    }

    public Order getOrder() {
        return order;
    }

    public void close() throws IOException {
        _socket.close();
    }

    public void retornaMensagem(String mensagem) throws IOException {
        _socket.getOutputStream().write(mensagem.getBytes());
    }

    public String exibeMensagemtexto() throws IOException {
        _input = _socket.getInputStream();
        byte[] b = new byte[1024];
        _input.read(b);
        return new String(b).trim();
    }

    public Person getPerson() throws IOException {

        return person;
    }

    private void montaMensagem(Socket socket) throws IOException {
        
        Scanner s = new Scanner(socket.getInputStream()).useDelimiter("\\|");

        while (s.hasNext()) {
            order.setId(s.next());
            order.setProductid(s.nextInt());
            order.setQuantity(s.nextInt());
            order.setSalesmanis(s.nextInt());

            person.setId(s.nextInt());
            person.setNome(s.next());
            person.setPhone(s.next());
        }

    }
}
