public class Explicacao {
    Pedido pedido;
    public String informacoesValorTotal(double frete, double imposto, double desconto, double total) {
        String relatorio = """
=================================
|   Relatório do valor pago    |
=================================
| Frete: %.2f                  |
| Impostos: %.2f               |
| Descontos: %.2f              |
| Total: %.2f                  |
=================================
""";
        return String.format(relatorio, frete, imposto, desconto, total);
    }
}
