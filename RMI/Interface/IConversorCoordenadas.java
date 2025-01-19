package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IConversorCoordenadas extends Remote {
  public String getCoordenadaPolar(double x, double y) throws RemoteException;
}
