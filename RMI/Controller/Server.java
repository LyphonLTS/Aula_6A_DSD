package Controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import Interface.IConversorCoordenadas;

public class Server {
  public static void main(String[] args) throws RemoteException, MalformedURLException {
    try {
      IConversorCoordenadas conversorCoordenadas = new ConversorCoordenadas();

      LocateRegistry.createRegistry(1234);

      Naming.rebind("rmi://localhost:1234/ConversorCoordenadas", conversorCoordenadas);

      System.out.println("Servidor RMI iniciado na porta 1234, aguardando mensagens: ");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
