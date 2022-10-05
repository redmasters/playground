package io.red.playground.patterns.strategy.pagamento.ecommerce.formasPagamento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PayPalPagamento implements PagamentoStrategy {
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader LEITOR = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String senha;
    private boolean logado;

    public PayPalPagamento() {
    }

    public PayPalPagamento(boolean logado) {
        this.logado = logado;
    }

    static {
        DATA_BASE.put("amanda123", "amanda@oi.com");
        DATA_BASE.put("qwerty", "john@oi.com");
        DATA_BASE.put("red", "red@oi.com");
    }


    @Override
    public void detalhesDoPagamento() {
        try {
            while (!logado) {
                System.out.println("Entre com e-mail: ");
                email = LEITOR.readLine();
                System.out.println("Entre com a senha: ");
                senha = LEITOR.readLine();
                if (verificar()) {
                    System.out.println("Sucesso!");
                } else {
                    System.out.println("E-mail ou senha incorretos!");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean pay(int valorDoPagamento) {
        if (logado) {
            System.out.println("Pagando " + valorDoPagamento + "usando PayPal,");
            return true;
        }
        return false;
    }

    private boolean verificar() {
        setLogado(email.equals(DATA_BASE.get(senha)));
        DATA_BASE.get(senha);
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }
}
