public class BancoPan implements JurosStrategy {
    @Override
    public double getTaxaJuros(PedidoEmprestimo pedido) throws Exception {

        Cliente cliente = pedido.getCliente();

        if (cliente.isEhDevedor()) {
            throw new Exception("Cliente inapto a realizar emprestimo");
        }

        if (pedido.getValor() > 5000) {
            return 2.5;
        } else if (pedido.getValor() > 20000) {
            return 6.0;
        }
        return 2.0;
    }
}
