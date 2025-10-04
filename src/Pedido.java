import logicaFrete.Frete;
import logicaImposto.Imposto;

public class Pedido {
    private Frete frete;
    private Imposto imposto;
    private int pontosFidelidade;
    private double valor;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

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

    public void addPontosFidelidade(int pontosFidelidade) {
        this.pontosFidelidade += pontosFidelidade;
    }

    public void removePontosFidelidade(int pontosFidelidade) {
        this.pontosFidelidade -= pontosFidelidade;
    }

}
