class Profissional extends Pessoa {
    private String senha;

    public Profissional(String nome, String cpf, int idade, String senha) {
        super(nome, cpf, idade);
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean verificarSenha(String senha) {
        return this.senha.equals(senha);
    }

    @Override
    public String obterDetalhes() {
        return "";
    }
}
