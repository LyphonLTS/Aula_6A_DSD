package Controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import Interface.IConversorCoordenadas;

public class Client {
  public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
    String message = JOptionPane.showInputDialog("Digite a ordenada x: ") + ", "
        + JOptionPane.showInputDialog("Digite a ordenada y: ");
    String[] coordenadas = message.split(", ");

    IConversorCoordenadas conversorCoordenadas = (IConversorCoordenadas) Naming
        .lookup("rmi://localhost:1234/ConversorCoordenadas");

    String response = (coordenadas.length != 2) ? "Coordenadas inválidas, impossível converter"
        : "Resultado: " + conversorCoordenadas.getCoordenadaPolar(Double.parseDouble(coordenadas[0]),
            Double.parseDouble(coordenadas[1]));

    JOptionPane.showMessageDialog(null, response);
  }
}
