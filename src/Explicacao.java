public class Explicacao {
    public String informacoesValorTotal(double valor,double frete, double imposto, double totalComPagamento,
                                        double totalSemPagamento, String tipoPagamento) {
        double diferenca = totalSemPagamento - totalComPagamento;
        String efeitoPagamento;

        // Define se foi desconto ou acréscimo
        if (diferenca > 0) {
            efeitoPagamento = String.format("Desconto aplicado: -$%.2f", diferenca);
        } else if (diferenca < 0) {
            efeitoPagamento = String.format("Acréscimo aplicado: +$%.2f", Math.abs(diferenca));
        } else {
            efeitoPagamento = "Sem desconto ou acréscimo.";
        }

        String relatorio = """
=================================
|     Relatório do valor pago   |
=================================
| Valor:        $%.2f
| Frete:        $%.2f
| Impostos:     $%.2f
| Total bruto:  $%.2f
| Tipo de pagamento:   %s
| %s
---------------------------------
| Total final:  $%.2f
=================================
""";

        return String.format(relatorio,valor, frete, imposto, totalSemPagamento, tipoPagamento, efeitoPagamento, totalComPagamento);
    }
}
