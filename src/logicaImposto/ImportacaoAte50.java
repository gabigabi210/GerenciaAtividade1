package logicaImposto;

public class ImportacaoAte50 implements Imposto{
    @Override
    public double calcularImposto(double valor) {
// Se o valor da compra for de até 50 dólares (ou o equivalente): o imposto de importação será de 20% sobre esse valor
        return valor + (0.2 * valor);
    }
}
