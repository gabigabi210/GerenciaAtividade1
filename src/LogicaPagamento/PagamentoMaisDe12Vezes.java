package LogicaPagamento;

public class PagamentoMaisDe12Vezes implements TipoPagamento{
    @Override
    public double realizarPagamento(double valor) {
        return valor * 1.2;
    }

}
