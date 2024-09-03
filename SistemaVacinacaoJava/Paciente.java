class Paciente extends Pessoa {
    private String carteirinha;

    public Paciente(String nome, String cpf, int idade, String carteirinha) {
        super(nome, cpf, idade);
        this.carteirinha = carteirinha;
    }

    public String getCarteirinha() {
        return carteirinha;
    }

    public void setCarteirinha(String carteirinha) {
        this.carteirinha = carteirinha;
    }

    @Override
    public String obterDetalhes() {
        return "";
    }

    @Override
    public String toString() {
        return "Paciente{" + "nome='" + getNome() + '\'' + ", cpf='" + getCpf() + '\'' + ", idade=" + getIdade() + ", carteirinha='" + carteirinha + '\'' + '}';
    }
}
