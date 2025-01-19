package Controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Interface.IConversorCoordenadas;

public class ConversorCoordenadas extends UnicastRemoteObject implements IConversorCoordenadas {
  public ConversorCoordenadas() throws RemoteException {
    super();
  }

  private double getDistancia(double x, double y) {
    return Math.sqrt((Math.pow(x, 2)) + (Math.pow(y, 2)));
  }

  private double getAngulo(double x, double y) {
    return Math.atan2(y, x);
  }

  public String getCoordenadaPolar(double x, double y) throws RemoteException {
    return "r: " + getDistancia(x, y) + ", theta: " + getAngulo(x, y);
  }
}
