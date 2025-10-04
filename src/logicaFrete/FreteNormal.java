package logicaFrete;

public class FreteNormal implements Frete {
    public double calcularFrete(double valor) {
        return valor * 0.10;
    }

    public String calcularTempoEntrega(Frete frete){
        return "26 dias";
    }

}

