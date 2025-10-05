package LogicaPagamento;

public class PagamentoAte12Vezes implements TipoPagamento{
    @Override
    public double realizarPagamento (double valor) {
        return valor;
    }

}
