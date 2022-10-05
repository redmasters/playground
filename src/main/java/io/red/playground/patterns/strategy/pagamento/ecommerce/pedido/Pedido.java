package io.red.playground.patterns.strategy.pagamento.ecommerce.pedido;

import io.red.playground.patterns.strategy.pagamento.ecommerce.formasPagamento.PagamentoStrategy;

public class Pedido {
    private int custoTotal = 0;
    private boolean isClosed = false;

    public Pedido() {
    }

    public Pedido(int custoTotal, boolean isClosed) {
        this.custoTotal = custoTotal;
        this.isClosed = isClosed;
    }



    public Pedido(int custoTotal) {
        this.custoTotal = custoTotal;
    }

    public void processarOrdem(PagamentoStrategy strategy){
        strategy.detalhesDoPagamento();
    }

    public int getCustoTotal() {
        return custoTotal;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = true;
    }
}
