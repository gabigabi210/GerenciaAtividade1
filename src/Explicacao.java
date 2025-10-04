public class Explicacao {
    Pedido pedido;
    public String informacoesValorTotal() {
        String relatorio = """
=================================
|   Relatório do valor pago    |
=================================
| Frete: %s                  |
| Impostos: %s                  |
| Total: %s              |
=================================
""";
        return String.format(relatorio, pedido.getFrete(), pedido.getImposto(),
                pedido.getFrete().calcularFrete(pedido.getValor()) + pedido.getImposto().calcularImposto(pedido.getValor()));
    }
}
