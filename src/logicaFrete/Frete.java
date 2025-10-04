package logicaFrete;

import java.time.Duration;

public interface Frete {
    public double calcularFrete(double valor);
    public String calcularTempoEntrega(Frete frete);

}

