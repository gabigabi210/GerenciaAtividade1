package logicaFrete;

public class FreteExpresso implements Frete{
    public double calcularFrete(double valor) {
        return valor * 0.25;
    }
}
