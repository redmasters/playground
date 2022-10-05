package io.red.playground.patterns.strategy.pagamento.ecommerce.formasPagamento;

public interface PagamentoStrategy {
    boolean pay(int valorDoPagamento);
    void detalhesDoPagamento();
}
