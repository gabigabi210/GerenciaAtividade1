public class Explicacao {
    Pedido pedido;
    public String informacoesValorTotal() {
        return "O que compoe o valor cobrado:"
                + "Valor do frete: " + pedido.getFrete()
                + "Valor do imposto: " + pedido.getImposto();
    }
}
