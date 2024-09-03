import java.util.ArrayList;

class SistemaVacinacao {
    private ArrayList<Vacinacao> vacinacoes = new ArrayList<>();
    private ArrayList<Vacina> vacinas = new ArrayList<>();
    private ArrayList<Profissional> profissionais = new ArrayList<>();
    private ArrayList<Paciente> pacientes = new ArrayList<>();

    public void adicionarVacina(Vacina vacina) {
        vacinas.add(vacina);
    }

    public void adicionarProfissional(Profissional profissional) {
        profissionais.add(profissional);
    }

    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public Profissional buscarProfissionalPorSenha(String senha) {
        for (Profissional profissional : profissionais) {
            if (profissional.verificarSenha(senha)) {
                return profissional;
            }
        }
        return null;
    }

    public Paciente buscarPacientePorCpf(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        return null;
    }

    public void cadastrarVacinacao(Paciente paciente, Vacina vacina, String data) {
        vacina.reduzirQuantidade(1);
        vacinacoes.add(new Vacinacao(paciente, vacina, data));
    }

    public void listarVacinacoes() {
        for (Vacinacao vacinacao : vacinacoes) {
            System.out.println(vacinacao);
        }
    }

    public void conferirEstoque() {
        for (Vacina vacina : vacinas) {
            System.out.println(vacina);
        }
    }

    public void listarVacinacoesPorPaciente(Paciente paciente) {
        for (Vacinacao vacinacao : vacinacoes) {
            if (vacinacao.getPaciente().getCpf().equals(paciente.getCpf())) {
                System.out.println(vacinacao);
            }
        }
    }

    public ArrayList<Vacina> getVacinas() {
        return vacinas;
    }

    public ArrayList<Profissional> getProfissionais() {
        return profissionais;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
}
