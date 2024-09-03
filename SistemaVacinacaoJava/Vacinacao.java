class Vacinacao {
    private Paciente paciente;
    private Vacina vacina;
    private String dataVacinacao;

    public Vacinacao(Paciente paciente, Vacina vacina, String dataVacinacao) {
        this.paciente = paciente;
        this.vacina = vacina;
        this.dataVacinacao = dataVacinacao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public String getDataVacinacao() {
        return dataVacinacao;
    }

    public void setDataVacinacao(String dataVacinacao) {
        this.dataVacinacao = dataVacinacao;
    }

    @Override
    public String toString() {
        return "Vacinacao{" + "paciente=" + paciente + ", vacina=" + vacina + ", dataVacinacao='" + dataVacinacao + '\'' + '}';
    }
}
