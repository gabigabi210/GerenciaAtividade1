package logicaFrete;

public class FreteSuperExpresso implements Frete {
    public double calcularFrete(double valor) {
        return valor * 1.5;
    }

    public String calcularTempoEntrega(Frete frete){
        return "10 dias";
    }

}
