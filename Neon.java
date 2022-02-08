public class Neon implements JurosStrategy {
    @Override
    public double getTaxaJuros(PedidoEmprestimo pedido) throws Exception {

        Cliente cliente = pedido.getCliente();
        double multiplicadorTaxa = 0.0005 * pedido.getValor();
        double multiplicadorParcela = 1;
        double taxa = 1.5;

        if (pedido.getValor() > 5000)
        {
            taxa =  5.5;
        }
        else if (pedido.getValor() > 20000)
        {
            taxa =  5.0;
        }

        if (pedido.getNumeroParcelas() > 12)
        {
            multiplicadorTaxa = 3.5;
        }
        else if (pedido.getNumeroParcelas() > 24)
        {
            multiplicadorTaxa = 7.5;
        }

        if (cliente.isEhDevedor())
        {
            taxa = taxa + (multiplicadorTaxa * multiplicadorParcela);
        }

        return taxa;
    }
}
