package Controller;

import java.io.*;
import java.net.*;

public class Server {
  public static void main(String[] args) {
    int port = 12345;

    try (ServerSocket serverSocket = new ServerSocket(port)) {
      System.out.println("Servidor escutando na porta: " + port);

      // Espera por uma conexão de um cliente
      Socket clientSocket = serverSocket.accept();
      System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

      // Criando streams para leitura e escrita
      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

      // Lê a mensagem do cliente
      String messageFromClient = in.readLine();
      System.out.println("Mensagem recebida do cliente: " + messageFromClient);

      String[] coordenadas = messageFromClient.split(", ");
      String result = (coordenadas.length != 2) ? "Coordenadas inválidas, impossível converter"
          : "Resultado: " + new ConversorCoordenadas().getCoordenadaPolar(Double.parseDouble(coordenadas[0]),
              Double.parseDouble(coordenadas[1]));

      // Envia resposta de confirmação ao cliente
      out.println(result);

      // Fecha a conexão com o cliente
      clientSocket.close();
      System.out.println("Conexão com o cliente fechada.");
    } catch (IOException e) {
      System.out.println("Erro no servidor: " + e.getMessage());
      e.printStackTrace();
    }
  }
}