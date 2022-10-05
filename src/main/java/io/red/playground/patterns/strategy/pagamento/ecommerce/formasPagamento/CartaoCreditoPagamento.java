package io.red.playground.patterns.strategy.pagamento.ecommerce.formasPagamento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CartaoCreditoPagamento implements PagamentoStrategy {
    private final BufferedReader LEITOR = new BufferedReader(new InputStreamReader(System.in));
    private CartaoCredito cartaoCredito;


    @Override
    public void detalhesDoPagamento() {
        try {
            System.out.println("Numero do cartao: ");
            String numero = LEITOR.readLine();
            System.out.println("Data de expiracao");
            String data = LEITOR.readLine();
            System.out.println("CVV: ");
            String cvv = LEITOR.readLine();
            cartaoCredito = new CartaoCredito(numero, data, cvv);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public boolean pay(int valorDoPagamento) {
        if(cardIsPresent()){
            System.out.println("Pagando " + valorDoPagamento + "usando Cartao de Credito");
            new CartaoCredito(cartaoCredito.getQuantidade() - valorDoPagamento);
            return true;
        }
        return false;
    }

    private boolean cardIsPresent() {
        return cartaoCredito != null;
    }

}
