import logicaFrete.Frete;
import logicaImposto.Imposto;

public class Pedido {
    private Frete frete;
    private Imposto imposto;

    public Pedido(Frete frete, Imposto imposto) {
        this.frete = frete;
        this.imposto = imposto;
    }

    public Pedido() {
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
}
