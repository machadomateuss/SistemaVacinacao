import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaVacinacao sistema = new SistemaVacinacao();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("--------------------");
            System.out.println("Sistema de Vacinação");
            System.out.println("--------------------");
            System.out.println("Você é um profissional ou um paciente?");
            System.out.println("1. Profissional");
            System.out.println("2. Paciente");
            System.out.println("3. Registro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();


            switch (opcao) {
                case 1:
                    if (sistema.getProfissionais().isEmpty()) {
                        System.out.println("----------------------------------------------------------------------------");
                        System.out.println("Nenhum profissional cadastrado. Por favor cadastre um profissional primeiro.");
                        System.out.println("----------------------------------------------------------------------------");
                    } else {
                        System.out.print("Digite a senha: ");
                        String senha = scanner.nextLine();
                        Profissional profissional = sistema.buscarProfissionalPorSenha(senha);
                        if (profissional != null) {
                            menuProfissional(sistema, scanner, profissional);
                        } else {
                            System.out.println("----------------------------------------");
                            System.out.println("!!! Senha incorreta, tente novamente !!!");
                            System.out.println("----------------------------------------");
                        }
                    }
                    break;
                case 2:
                    if (sistema.getPacientes().isEmpty()) {
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println("Nenhum paciente cadastrado. Por favor cadastre um paciente primeiro.");
                        System.out.println("--------------------------------------------------------------------");
                    } else {
                        menuPaciente(sistema, scanner);
                    }
                    break;
                case 3:
                    menuRegistro(sistema, scanner);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("--------------------------------");
                    System.out.println("Opção inválida. Tente novamente.");
                    System.out.println("--------------------------------");
                    break;
            }
        }
        scanner.close();
    }

    private static void menuProfissional(SistemaVacinacao sistema, Scanner scanner, Profissional profissional) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("----------------------------------");
            System.out.println("Menu do Profissional - " + profissional.getNome());
            System.out.println("----------------------------------");
            System.out.println("1. Conferir Estoque de Vacinas");
            System.out.println("2. Adicionar Nova Vacina");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("-------------------");
                    System.out.println("Estoque de Vacinas:");
                    System.out.println("-------------------");
                    sistema.conferirEstoque();
                    break;
                case 2:
                    adicionarVacina(sistema, scanner);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("--------------------------------");
                    System.out.println("Opção inválida. Tente novamente.");
                    System.out.println("--------------------------------");
                    break;
            }
        }
    }

    private static void menuPaciente(SistemaVacinacao sistema, Scanner scanner) {
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();
        Paciente paciente = sistema.buscarPacientePorCpf(cpf);
        if (paciente == null) {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Carteirinha (RA): ");
            String carteirinha = scanner.nextLine();
            paciente = new Paciente(nome, cpf, idade, carteirinha);
            sistema.adicionarPaciente(paciente);
        }
        boolean continuar = true;
        while (continuar) {
            System.out.println("---------------------------");
            System.out.println("Menu Paciente - " + paciente.getNome());
            System.out.println("---------------------------");
            System.out.println("1. Ver Cadastro de Vacinações");
            System.out.println("2. Agendar Vacinação");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de Vacinações:");
                    sistema.listarVacinacoesPorPaciente(paciente);
                    break;
                case 2:
                    agendarVacinacao(sistema, scanner, paciente);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("-----------------------------");
                    System.out.println("Opção inválida. Tente novamente.");
                    System.out.println("-----------------------------");
                    break;
            }
        }
    }

    private static void menuRegistro(SistemaVacinacao sistema, Scanner scanner) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("----------------");
            System.out.println("Menu de Registro");
            System.out.println("----------------");
            System.out.println("1. Registrar Nova Vacina");
            System.out.println("2. Registrar Profissional");
            System.out.println("3. Registrar Paciente");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    adicionarVacina(sistema, scanner);
                    break;
                case 2:
                    cadastrarProfissional(sistema, scanner);
                    break;
                case 3:
                    cadastrarPaciente(sistema, scanner);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("--------------------------------");
                    System.out.println("Opção inválida. Tente novamente.");
                    System.out.println("--------------------------------");
                    break;
            }
        }
    }

    private static void cadastrarProfissional(SistemaVacinacao sistema, Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        Profissional profissional = new Profissional(nome, cpf, idade, senha);
        sistema.adicionarProfissional(profissional);
        System.out.println("------------------------------------");
        System.out.println("Profissional cadastrado com sucesso!");
        System.out.println("------------------------------------");
    }

    private static void cadastrarPaciente(SistemaVacinacao sistema, Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Carteirinha (RA): ");
        String carteirinha = scanner.nextLine();
        Paciente paciente = new Paciente(nome, cpf, idade, carteirinha);
        sistema.adicionarPaciente(paciente);
        System.out.println("--------------------------------");
        System.out.println("Paciente cadastrado com sucesso!");
        System.out.println("--------------------------------");
    }

    private static void adicionarVacina(SistemaVacinacao sistema, Scanner scanner) {
        System.out.print("Nome da Vacina: ");
        String nome = scanner.nextLine();
        System.out.print("Fabricante: ");
        String fabricante = scanner.nextLine();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        Vacina vacina = new Vacina(nome, fabricante, quantidade);
        sistema.adicionarVacina(vacina);
        System.out.println("------------------------------");
        System.out.println("Vacina adicionada com sucesso!");
        System.out.println("------------------------------");
    }

    private static void agendarVacinacao(SistemaVacinacao sistema, Scanner scanner, Paciente paciente) {
        System.out.println("Escolha a vacina para agendar:");
        ArrayList<Vacina> vacinas = sistema.getVacinas();
        for (int i = 0; i < vacinas.size(); i++) {
            System.out.println((i + 1) + ". " + vacinas.get(i).getNome());
        }
        System.out.print("Escolha uma opção: ");
        int opcaoVacina = scanner.nextInt();
        scanner.nextLine();
        if (opcaoVacina < 1 || opcaoVacina > vacinas.size()) {
            System.out.println("---------------");
            System.out.println("Opção inválida.");
            System.out.println("---------------");
            return;
        }
        Vacina vacina = vacinas.get(opcaoVacina - 1);
        if (vacina.getQuantidade() <= 0) {
            System.out.println("-----------------------");
            System.out.println("Vacina fora de estoque.");
            System.out.println("-----------------------");
            return;
        }
        System.out.print("Data do Agendamento (dd/mm/yyyy): ");
        String dataAgendamento = scanner.nextLine();
        sistema.cadastrarVacinacao(paciente, vacina, dataAgendamento);
        System.out.println("--------------------------------------------");
        System.out.println("Vacinação agendada e cadastrada com sucesso!");
        System.out.println("--------------------------------------------");
    }
}
