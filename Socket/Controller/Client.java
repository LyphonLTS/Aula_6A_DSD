package Controller;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class Client {
  public static void main(String[] args) {
    int port = 12345;
    String serverAdress = "localhost";

    try (Socket socket = new Socket(serverAdress, port)) {
      System.out.println("Conectado ao servidor: " + serverAdress + " na porta " + port);

      // Criando streams para leitura e escrita
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      // Envia uma mensagem ao servidor
      String message = JOptionPane.showInputDialog("Digite a ordenada x: ") + ", "
          + JOptionPane.showInputDialog("Digite a ordenada y: ");

      out.println(message);
      System.out.println("Mensagem enviada ao servidor: " + message);

      // Recebe a resposta do servidor
      String response = in.readLine();
      JOptionPane.showMessageDialog(null, response);
    } catch (IOException e) {
      System.out.println("Erro no cliente: " + e.getMessage());
      e.printStackTrace();
    }
  }
}