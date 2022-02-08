public class Cliente {

    private String nome;
    private String cidade;
    private String cpf;
    private boolean devedor;

    public Cliente(String nome, String cidade, String cpf, boolean ehDevedor) {
        this.nome = nome;
        this.cidade = cidade;
        this.cpf = cpf;
        this.devedor = ehDevedor;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isEhDevedor() {
        return devedor;
    }


}
