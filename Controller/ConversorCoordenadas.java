package Controller;

public class ConversorCoordenadas {
  private double getDistancia(double x, double y) {
    return Math.sqrt((Math.pow(x, 2)) + (Math.pow(y, 2)));
  }

  private double getAngulo(double x, double y) {
    return Math.atan2(y, x);
  }

  public String getCoordenadaPolar(double x, double y) {
    return "r: " + getDistancia(x, y) + ", theta: " + getAngulo(x, y);
  }
}
