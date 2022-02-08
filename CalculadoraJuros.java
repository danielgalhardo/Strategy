public class CalculadoraJuros {

    private JurosStrategy calculadoraJuros;

    public CalculadoraJuros(JurosStrategy calculadora)
    {
        this.calculadoraJuros = calculadora;
    }

    public double retornaTaxa(PedidoEmprestimo pedido) throws Exception {
        return this.calculadoraJuros.getTaxaJuros(pedido);
    }

}
