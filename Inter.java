public class Inter implements JurosStrategy {
    @Override
    public double getTaxaJuros(PedidoEmprestimo pedido) throws Exception {

        Cliente cliente = pedido.getCliente();
        double multiplicadorTaxa = 0.0005 * pedido.getValor();
        double taxa = 1;

        if (pedido.getValor() > 5000) {
            taxa =  5.5;
        } else if (pedido.getValor() > 20000) {
            taxa =  5.0;
        }

        if (cliente.isEhDevedor())
        {
            taxa = taxa + multiplicadorTaxa;
        }

        return taxa;
    }
}