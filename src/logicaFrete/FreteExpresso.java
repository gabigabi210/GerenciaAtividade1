package logicaFrete;

import java.time.Duration;

public class FreteExpresso implements Frete{
    public double calcularFrete(double valor) {
        return valor * 0.25;
    }

    public String calcularTempoEntrega(Frete frete){
        return "15 dias";
    }


}
