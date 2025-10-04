package logicaImposto;

public class ImportacaoAte50 implements Imposto{
    @Override
    public double calcularImposto(double valor) {
        return valor + (0.2 * valor) + (0.18 * valor);
    }
}
