import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class JurosTest {
    @Test
    void calculaJurosBancoPan() throws Exception {
        Cliente ahri = new Cliente("Ahri Carvalho","Ionia", "999-999-999-99", false);
        PedidoEmprestimo solicitacao = new PedidoEmprestimo(2500, ahri, 6);
        CalculadoraJuros juros =  new CalculadoraJuros(new BancoPan());
        double taxa =  juros.retornaTaxa(solicitacao);
        assertEquals(5000,  taxa * solicitacao.getValor());
    }

    @Test
    void deveRetornarClienteInaptoBancoPan() throws Exception {

        try {
            Cliente sett = new Cliente("Sett Jesus", "Piltover", "111-222-333-44", true);
            PedidoEmprestimo solicitacao = new PedidoEmprestimo(25000, sett, 36);
            CalculadoraJuros juros = new CalculadoraJuros(new BancoPan());
            double taxa = juros.retornaTaxa(solicitacao);
            fail();
        }
        catch(Exception exception)
        {
            assertEquals("Cliente inapto a realizar emprestimo", exception.getMessage());
        }
    }

    @Test
    void calculaJurosNubankDevedor() throws Exception {
        Cliente sona = new Cliente("Sona Maria","Demacia", "999-888-777-66", true);
        PedidoEmprestimo solicitacao = new PedidoEmprestimo(2500, sona, 6);
        CalculadoraJuros juros =  new CalculadoraJuros(new Nubank());
        double taxa =  juros.retornaTaxa(solicitacao);
        assertEquals(21250.0,  taxa * solicitacao.getValor(), 0.01f);
    }

    @Test
    void calculaJurosNubankNaoDevedor() throws Exception {
        Cliente sona = new Cliente("Sona Maria","Demacia", "999-888-777-66", false);
        PedidoEmprestimo solicitacao = new PedidoEmprestimo(2500, sona, 6);
        CalculadoraJuros juros =  new CalculadoraJuros(new Nubank());
        double taxa =  juros.retornaTaxa(solicitacao);
        assertEquals(16562.5,  taxa * solicitacao.getValor(), 0.01f);
    }


    @Test
    void calculaJurosNeonDevedor() throws Exception {
        Cliente gnar = new Cliente("Gnar da Silva","Targon", "888-222-23-32", true);
        PedidoEmprestimo solicitacao = new PedidoEmprestimo(1750, gnar, 13);
        CalculadoraJuros juros =  new CalculadoraJuros(new Neon());
        double taxa =  juros.retornaTaxa(solicitacao);
        assertEquals(8750.0,  taxa * solicitacao.getValor(), 0.01f);
    }

    @Test
    void calculaJurosNeonNaoDevedor() throws Exception {
        Cliente gnar = new Cliente("Gnar da Silva","Targon", "888-222-23-32", false);
        PedidoEmprestimo solicitacao = new PedidoEmprestimo(1750, gnar, 13);
        CalculadoraJuros juros =  new CalculadoraJuros(new Neon());
        double taxa =  juros.retornaTaxa(solicitacao);
        assertEquals(2625.0,  taxa * solicitacao.getValor(), 0.01f);
    }

    @Test
    void calculaJurosInterDevedor() throws Exception {
        Cliente gnar = new Cliente("Gnar da Silva","Targon", "888-222-23-32", true);
        PedidoEmprestimo solicitacao = new PedidoEmprestimo(6000, gnar, 13);
        CalculadoraJuros juros =  new CalculadoraJuros(new Inter());
        double taxa =  juros.retornaTaxa(solicitacao);
        assertEquals(51000.0,  taxa * solicitacao.getValor(), 0.01f);
    }

    @Test
    void calculaJurosInterNaoDevedor() throws Exception {
        Cliente gnar = new Cliente("Gnar da Silva","Targon", "888-222-23-32", false);
        PedidoEmprestimo solicitacao = new PedidoEmprestimo(6000, gnar, 13);
        CalculadoraJuros juros =  new CalculadoraJuros(new Inter());
        double taxa =  juros.retornaTaxa(solicitacao);
        assertEquals(33000.0,  taxa * solicitacao.getValor(), 0.01f);
    }

}