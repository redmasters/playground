package io.red.playground.patterns.strategy.pagamento.ecommerce;

import io.red.playground.patterns.strategy.pagamento.ecommerce.formasPagamento.CartaoCreditoPagamento;
import io.red.playground.patterns.strategy.pagamento.ecommerce.formasPagamento.PagamentoStrategy;
import io.red.playground.patterns.strategy.pagamento.ecommerce.formasPagamento.PayPalPagamento;
import io.red.playground.patterns.strategy.pagamento.ecommerce.pedido.Pedido;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MainPagamento {
    private static Map<Integer, Integer> precoDosProdutos = new HashMap<>();
    private static BufferedReader LEITOR = new BufferedReader(new InputStreamReader(System.in));
    private static Pedido pedido = new Pedido();
    private static PagamentoStrategy strategy;

    static {
        precoDosProdutos.put(1, 2299);
        precoDosProdutos.put(2, 1234);
        precoDosProdutos.put(3, 234);
        precoDosProdutos.put(4, 1399);
    }

    public static void main(String[] args) throws IOException {
        while (!pedido.isClosed()) {
            int custo;

            String escolherContinuar;
            do {
                System.out.println("Por favor selecione um produto: " + "\n" +
                        "1 - Placa Mae" + "\n" +
                        "2 - CPU " + "\n");
                int escolha = Integer.parseInt(LEITOR.readLine());
                custo = precoDosProdutos.get(escolha);
                System.out.println("Quantidade : ");
                int contar = Integer.parseInt(LEITOR.readLine());
                pedido = new Pedido(custo * contar);
                System.out.println("Deseja continuar selecionando produtos? S/N ");
                escolherContinuar = LEITOR.readLine();
            } while (escolherContinuar.equalsIgnoreCase("S"));

            if (strategy == null) {
                System.out.println("Selecione o metodo de pagamento: " + "\n" +
                        "1 - PayPal" + "\n" +
                        "2 - Cartao de Credito");
                String metodoDePagamento = LEITOR.readLine();

                if (metodoDePagamento.equals("1")) {
                    strategy = new PayPalPagamento();
                } else {
                    strategy = new CartaoCreditoPagamento();
                }
            }

            pedido.processarOrdem(strategy);
            System.out.println("Pagar " + pedido.getCustoTotal() + "unidades ou Continuar? P/C: ");
            String prosseguir = LEITOR.readLine();
            if (prosseguir.equalsIgnoreCase("P")) {
                if (strategy.pay(pedido.getCustoTotal())) {
                    System.out.println("Pagamento efetuado com sucesso1!");
                } else {

                    System.out.println("FALHA. Verifique");

                }
            }
            pedido.setClosed();

        }
    }
}
