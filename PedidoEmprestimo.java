public class PedidoEmprestimo {

    private int valor;
    private Cliente cliente;



    private int numeroParcelas;

    public PedidoEmprestimo(int valorPedido, Cliente cliente, int numeroParcelas)
    {
        this.valor = valorPedido;
        this.cliente = cliente;
        this.numeroParcelas = numeroParcelas;
    }

    public int getValor() {
        return valor;
    }

    public Cliente getCliente(){
        return cliente;
    }


    public int getNumeroParcelas() {
        return numeroParcelas;
    }


}
