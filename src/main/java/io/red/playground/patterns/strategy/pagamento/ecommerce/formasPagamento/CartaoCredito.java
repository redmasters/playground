package io.red.playground.patterns.strategy.pagamento.ecommerce.formasPagamento;

public class CartaoCredito {
    private int quantidade;
    private String numero;
    private String data;
    private String cvv;

    public CartaoCredito(String numero, String data, String cvv) {
        this.quantidade = 100_00;
        this.numero = numero;
        this.data = data;
        this.cvv = cvv;
    }

    public CartaoCredito(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
