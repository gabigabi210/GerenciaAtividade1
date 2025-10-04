package logicaFrete;

public class FreteNormal implements Frete {
    public double calcularFrete(double valor) {
        return valor * 0.10;
    }
}
