package logicaImposto;

public class ImportacaoAcimaDe50 implements Imposto{
    @Override
    public double calcularImposto(double valor) {
// Se o valor da compra* for acima de 50 dólares: o Imposto de Importação será de 60% esse valor.
        return valor + (0.5 * valor);
    }
}
