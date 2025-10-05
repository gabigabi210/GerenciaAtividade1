import logicaFrete.FreteExpresso;
import logicaFrete.FreteNormal;
import logicaFrete.FreteSuperExpresso;
import logicaImposto.ImportacaoAcimaDe50;
import logicaImposto.ImportacaoAte50;

import java.util.Scanner;
import java.util.function.ObjIntConsumer;

public class Executavel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pedido pedido = new Pedido();
        Explicacao explicacao = new Explicacao();

        System.out.println("Bem vindo a calculadora de imposto," +
                " frete e pontos de fidelidade do nossa loja");

        System.out.println();
        System.out.println("Escolha seu frete");
        System.out.println();
        System.out.println("1 - Frete normal\n" +
                "2 - Frete Expresso\n" +
                "3 - Frete SuperExpresso\n");
        System.out.print("Qual sua escolha? ");
        int escolha  = sc.nextInt();
        switch(escolha){
            case 1:
                System.out.println("Frete normal");
                pedido.setFrete(new FreteNormal());
                System.out.println(pedido.getFrete().calcularTempoEntrega(new FreteNormal()));
                break;
            case 2:
                System.out.println("Frete Expresso");
                pedido.setFrete(new FreteExpresso());
                System.out.println(pedido.getFrete().calcularTempoEntrega(new FreteExpresso()));
                break;
            case 3:
                System.out.println("Frete SuperExpresso");
                pedido.setFrete(new FreteSuperExpresso());
                System.out.println(pedido.getFrete().calcularTempoEntrega(new FreteSuperExpresso()));
                break;
        default:
            System.out.println("Frete Inválido");
            break;
        }
        System.out.println("Qual o valor do seu pedido, em dólares?");
        pedido.setValor(sc.nextDouble());

        if(pedido.getValor() <= 50){
            pedido.setImposto(new ImportacaoAte50());
            System.out.println(pedido.getImposto().calcularImposto(pedido.getValor()) + pedido.getFrete().calcularFrete(pedido.getValor()));
        }
        else{
            pedido.setImposto(new ImportacaoAcimaDe50());
            System.out.println(pedido.getImposto().calcularImposto(pedido.getValor())+ pedido.getFrete().calcularFrete(pedido.getValor()));
        }
        pedido.addPontosFidelidade((int) pedido.getValor());
        System.out.print("Quantidade de pontos adquiridos na compra: " + pedido.getPontosFidelidade() ) ;

        System.out.print("Deseja ver os detalhes do preço total do pedido? ");
        System.out.println("1 - Sim\n" +
                "2 - Não\n");
        System.out.print("Qual sua escolha? ");
        int escolhaExplicacao = sc.nextInt();

        if(escolhaExplicacao == 1){
            System.out.println(explicacao.informacoesValorTotal(pedido.getFrete().calcularFrete(pedido.getValor()), pedido.getImposto().calcularImposto(pedido.getValor()), pedido.calculaValorTotal(pedido)));
        } else {
            System.out.println('a');
        }

    }
}