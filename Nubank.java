public class Nubank implements JurosStrategy {
    @Override
    public double getTaxaJuros(PedidoEmprestimo pedido) throws Exception {

        Cliente cliente = pedido.getCliente();
        double multiplicadorTaxa = 0.0006 * pedido.getValor();
        double multiplicadorParcela = 1.5;
        double taxa = 0.75;

        if (pedido.getValor() > 5000)
        {
            taxa =  4.5;
        }
        else if (pedido.getValor() > 20000)
        {
            taxa =  7.0;
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
            taxa = taxa + (multiplicadorTaxa * multiplicadorParcela) + 5.5;
        }
        else {
            taxa = (taxa * multiplicadorParcela) + 5.5;
        }

        return taxa;
    }
}