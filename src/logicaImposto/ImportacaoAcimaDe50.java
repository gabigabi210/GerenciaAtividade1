package logicaImposto;

public class ImportacaoAcimaDe50 implements Imposto{
    @Override
    public double calcularImposto(double valor) {
        return valor + (0.8 * valor) + (0.18 * valor);
    }
}
