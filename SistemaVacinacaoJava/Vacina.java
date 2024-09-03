class Vacina {
    private String nome;
    private String fabricante;
    private int quantidade;

    public Vacina(String nome, String fabricante, int quantidade) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void reduzirQuantidade(int quantidade) {
        this.quantidade -= quantidade;
    }

    @Override
    public String toString() {
        return "Vacina{" + "nome='" + nome + '\'' + ", fabricante='" + fabricante + '\'' + ", quantidade=" + quantidade + '}';
    }
}
