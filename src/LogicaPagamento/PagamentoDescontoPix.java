package LogicaPagamento;

public class PagamentoDescontoPix implements TipoPagamento{
    @Override
    public double realizarPagamento(double valor) {
        return valor * 0.90;
    }

}
