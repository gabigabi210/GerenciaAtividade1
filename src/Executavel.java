import logicaFrete.FreteExpresso;
import logicaFrete.FreteNormal;
import logicaFrete.FreteSuperExpresso;
import logicaImposto.ImportacaoAcimaDe50;
import logicaImposto.ImportacaoAte50;
import LogicaPagamento.PagamentoAte12Vezes;
import LogicaPagamento.PagamentoDescontoPix;
import LogicaPagamento.PagamentoMaisDe12Vezes;

import java.util.Scanner;

public class Executavel {

    // Cores ANSI para deixar o terminal mais bonito ✨
    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";
    private static final String GREEN = "\u001B[32m";
    private static final String CYAN = "\u001B[36m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String PURPLE = "\u001B[35m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pedido pedido = new Pedido();
        Explicacao explicacao = new Explicacao();

        // Cabeçalho bonito
        System.out.println(PURPLE + "=====================================================" + RESET);
        System.out.println(GREEN + "💰  CALCULADORA DE IMPOSTO, FRETE E PAGAMENTO 💳" + RESET);
        System.out.println(PURPLE + "=====================================================\n" + RESET);

        // Pedindo informações básicas
        System.out.print(CYAN + "👤 Digite seu nome: " + RESET);
        String nome = sc.nextLine();

        System.out.print(CYAN + "🌍 Digite seu país: " + RESET);
        String pais = sc.nextLine();

        System.out.println();
        System.out.println(GREEN + "Olá, " + nome + " de " + pais + "! 👋" + RESET);
        System.out.println("Seja bem-vindo(a) à nossa loja internacional! 🌎\n");

        // Escolha do frete 🚚
        System.out.println(BLUE + "Escolha o tipo de frete:" + RESET);
        System.out.println(YELLOW + "1️⃣  Frete Normal");
        System.out.println("2️⃣  Frete Expresso");
        System.out.println("3️⃣  Frete Super Expresso" + RESET);
        System.out.print(PURPLE + "\n➡️  Digite sua escolha: " + RESET);
        int escolhaFrete = sc.nextInt();

        switch (escolhaFrete) {
            case 1:
                pedido.setFrete(new FreteNormal());
                System.out.println(GREEN + "\n✅ Frete Normal selecionado." + RESET);
                System.out.println("⏱️ Tempo estimado de entrega: " +
                        CYAN + pedido.getFrete().calcularTempoEntrega(new FreteNormal()) + RESET);
                break;
            case 2:
                pedido.setFrete(new FreteExpresso());
                System.out.println(GREEN + "\n🚀 Frete Expresso selecionado." + RESET);
                System.out.println("⏱️ Tempo estimado de entrega: " +
                        CYAN + pedido.getFrete().calcularTempoEntrega(new FreteExpresso()) + RESET);
                break;
            case 3:
                pedido.setFrete(new FreteSuperExpresso());
                System.out.println(GREEN + "\n⚡ Frete Super Expresso selecionado." + RESET);
                System.out.println("⏱️ Tempo estimado de entrega: " +
                        CYAN + pedido.getFrete().calcularTempoEntrega(new FreteSuperExpresso()) + RESET);
                break;
            default:
                System.out.println(RED + "\n❌ Opção de frete inválida. Encerrando o programa." + RESET);
                return;
        }

        // Valor do pedido 💵
        System.out.print(YELLOW + "\n💵 Informe o valor do seu pedido (em dólares): " + RESET);
        pedido.setValor(sc.nextDouble());

        // Define o imposto conforme o valor
        if (pedido.getValor() <= 50) {
            pedido.setImposto(new ImportacaoAte50());
            System.out.println(BLUE + "\n🧾 Aplicando taxa de importação para pedidos até $50..." + RESET);
        } else {
            pedido.setImposto(new ImportacaoAcimaDe50());
            System.out.println(BLUE + "\n🧾 Aplicando taxa de importação para pedidos acima de $50..." + RESET);
        }

        // Escolha do pagamento 💳
        System.out.println("\n" + GREEN + "Escolha a forma de pagamento:" + RESET);
        System.out.println(YELLOW + "1️⃣  Pix (10% de desconto)");
        System.out.println("2️⃣  Cartão até 12x (sem juros)");
        System.out.println("3️⃣  Cartão acima de 12x (20% de acréscimo)" + RESET);
        System.out.print(PURPLE + "\n➡️  Digite sua escolha: " + RESET);
        int escolhaPagamento = sc.nextInt();

        switch (escolhaPagamento) {
            case 1:
                pedido.setTipoPagamento(new PagamentoDescontoPix());
                System.out.println(GREEN + "\n✅ Pagamento via Pix selecionado. (10% de desconto)" + RESET);
                break;
            case 2:
                pedido.setTipoPagamento(new PagamentoAte12Vezes());
                System.out.println(GREEN + "\n✅ Pagamento até 12x selecionado. (Sem juros)" + RESET);
                break;
            case 3:
                pedido.setTipoPagamento(new PagamentoMaisDe12Vezes());
                System.out.println(GREEN + "\n✅ Pagamento acima de 12x selecionado. (20% de acréscimo)" + RESET);
                break;
            default:
                System.out.println(RED + "\n❌ Opção de pagamento inválida. Encerrando o programa." + RESET);
                return;
        }

        // Calcula valores
        double valor= pedido.getValor();
        double frete = pedido.getFrete().calcularFrete(pedido.getValor());
        double imposto = pedido.getImposto().calcularImposto(pedido.getValor());
        double totalSemPagamento = pedido.calculaValorTotal(pedido);
        double totalComPagamento = pedido.getTipoPagamento().realizarPagamento(totalSemPagamento);

        // Pontos de fidelidade ⭐
        pedido.addPontosFidelidade((int) pedido.getValor());
        System.out.println(YELLOW + "\n⭐ Pontos adquiridos na compra: " + pedido.getPontosFidelidade() + " pontos" + RESET);

        // Pergunta se deseja ver o relatório
        System.out.println("\n📄 Deseja ver os detalhes do valor total?");
        System.out.println("1️⃣  Sim");
        System.out.println("2️⃣  Não");
        System.out.print(PURPLE + "\n➡️  Digite sua escolha: " + RESET);
        int escolhaExplicacao = sc.nextInt();

        if (escolhaExplicacao == 1) {
            String tipoPagamento;
            if (pedido.getTipoPagamento() instanceof PagamentoDescontoPix) {
                tipoPagamento = "Pix (10% de desconto)";
            } else if (pedido.getTipoPagamento() instanceof PagamentoAte12Vezes) {
                tipoPagamento = "Cartão até 12x (sem juros)";
            } else {
                tipoPagamento = "Cartão acima de 12x (20% de acréscimo)";
            }

            System.out.println(
                    explicacao.informacoesValorTotal(
                            valor,
                            frete,
                            imposto,
                            totalComPagamento,
                            totalSemPagamento,
                            tipoPagamento
                    )
            );
        }

        // Resumo final 💰
        System.out.println(PURPLE + "\n=====================================================" + RESET);
        System.out.printf(GREEN + "💰 Valor final a pagar: $%.2f\n" + RESET, totalComPagamento);
        System.out.println(YELLOW + "🎁 Pontos acumulados: " + pedido.getPontosFidelidade() + RESET);
        System.out.println(BLUE + "🧾 Cliente: " + nome + " (" + pais + ")" + RESET);
        System.out.println(GREEN + "Obrigado pela preferência, " + nome + "! 🛍️" + RESET);
        System.out.println(PURPLE + "=====================================================" + RESET);
    }
}
