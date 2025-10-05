import LogicaPagamento.TipoPagamento;
import logicaFrete.Frete;
import logicaImposto.Imposto;

public class Pedido {
    private Frete frete;
    private Imposto imposto;
    private TipoPagamento tipoPagamento;
    private int pontosFidelidade;
    private double valor;

    public Pedido(Frete frete, Imposto imposto, double valor) {
        this.frete = frete;
        this.imposto = imposto;
        this.valor = valor;
    }

    public Pedido() {
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Frete getFrete() {
        return frete;
    }

    public void setFrete(Frete frete) {
        this.frete = frete;
    }

    public Imposto getImposto() {
        return imposto;
    }

    public void setImposto(Imposto imposto) {
        this.imposto = imposto;
    }

    public int getPontosFidelidade() {
        return pontosFidelidade;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public void setPontosFidelidade(int pontosFidelidade) {
        this.pontosFidelidade = pontosFidelidade;
    }

    public void addPontosFidelidade(int valor) {
        this.pontosFidelidade += (int) valor / 10 ;
    }

    public void removePontosFidelidade(int pontosFidelidade) {
        this.pontosFidelidade -= pontosFidelidade;
    }

    public double calculaValorTotal(Pedido pedido) {
        return pedido.getImposto().calcularImposto(pedido.getValor())+ pedido.getFrete().calcularFrete(pedido.getValor()) + pedido.getTipoPagamento().realizarPagamento(pedido.getValor());
    }

}
