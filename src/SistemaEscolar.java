import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Disciplina
{
    String nome;

    public Disciplina(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return nome;
    }
}

class Turma
{
    String nome;
    Disciplina disciplina;
    Professor responsavel;

    public Turma(String nome, Disciplina disciplina, Professor responsavel)
    {
        this.nome = nome;
        this.disciplina = disciplina;
        this.responsavel = responsavel;
    }

    public String getNome()
    {
        return nome;
    }

    public Disciplina getDisciplina()
    {
        return disciplina;
    }

    public Professor getResponsavel()
    {
        return responsavel;
    }
}

abstract class Pessoa
{
    String nome;
    String dataNascimento;
    String endereco;
    String telefone;
    String CPF;

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getDataNascimento()
    {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento)
    {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    public String getCPF()
    {
        return CPF;
    }

    public void setCPF(String CPF)
    {
        this.CPF = CPF;
    }

    abstract void exibirDados();
}

class Aluno extends Pessoa
{
    int matricula;
    ArrayList<Turma> turmasMatriculadas = new ArrayList<>();

    public void setMatricula(int matricula)
    {
        this.matricula = matricula;
    }

    public int getMatricula()
    {
        return matricula;
    }

    public void matricular(Turma turma)
    {
        turmasMatriculadas.add(turma);
    }

    @Override
    void exibirDados()
    {
        System.out.println("\nDados do Aluno:");
        System.out.println("Nome do Aluno: " + this.nome);
        System.out.println("Data de Nascimento: " + this.dataNascimento);
        System.out.println("Endereço: " + this.endereco);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("CPF: " + this.CPF);
        System.out.println("Matrícula: " + this.matricula);
        System.out.println("Turmas Matriculadas: ");
        for (Turma turma : turmasMatriculadas) {
            System.out.println("- " + turma.getNome() + " (Disciplina: " + turma.getDisciplina().getNome() + ")");
        }
    }
}

class Professor extends Pessoa
{
    ArrayList<Turma> turmasResponsavel = new ArrayList<>();

    public void responsavelPor(Turma turma) {
        turmasResponsavel.add(turma);
    }

    @Override
    void exibirDados()
    {
        System.out.println("\nDados do Professor:");
        System.out.println("Nome do Professor: " + this.nome);
        System.out.println("Data de Nascimento: " + this.dataNascimento);
        System.out.println("Endereço: " + this.endereco);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("CPF: " + this.CPF);
        System.out.println("Turmas Responsável: ");
        for (Turma turma : turmasResponsavel) {
            System.out.println("- " + turma.getNome() + " (Disciplina: " + turma.getDisciplina().getNome() + ")");
        }
    }
}

public class SistemaEscolar
{
    static ArrayList<Pessoa> cadastroDePessoas = new ArrayList<>();
    static ArrayList<Disciplina> cadastroDeDisciplinas = new ArrayList<>();
    static ArrayList<Turma> cadastroDeTurmas = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner ler = new Scanner(System.in);
        System.out.println("----- Sistema Escolar -----");
        System.out.println("----------------------------------------------------------");
        System.out.println("------- [1] - Gerenciar Professores ----------------------");
        System.out.println("------- [2] - Gerenciar Disciplinas ----------------------");
        System.out.println("------- [3] - Gerenciar Turmas ---------------------------");
        System.out.println("------- [4] - Gerenciar Alunos ---------------------------");
        System.out.println("------- [5] - Gerenciar Matrícula de Alunos ---------------");
        System.out.println("------- [6] - Emitir Declaração de Matrícula -------------");
        System.out.println("------- [7] - Emitir Declaração de Vínculo ---------------");
        System.out.println("------- [8] - Sair --------------------------------------");
        System.out.println("----------------------------------------------------------");

        int select;

        try {
            System.out.print(" ---- Selecione uma Opcao: ");
            select = ler.nextInt();
        } catch (InputMismatchException e)
        {
            System.out.println("Opção inválida. Por favor, insira um número.");
            ler.nextLine(); // Clear the input buffer
            menu();
            return;
        }

        switch (select) {
            case 1:
                System.out.println("------- [1.1] - Cadastrar Professor ----------------------");
                System.out.println("------- [1.2] - Listar Professores Cadastrados ------------");
                int subSelect = ler.nextInt();
                switch (subSelect) {
                    case 1:
                        cadastrarPessoa(new Professor());
                        break;
                    case 2:
                        listarProfessores();
                        break;
                    default:
                        System.out.println("\nOpção Inválida!\n");
                        menu();
                        break;
                }
                break;
            case 2:
                cadastrarDisciplina();
                break;
            case 3:
                cadastrarTurma();
                break;
            case 4:
                System.out.println("------- [4.1] - Cadastrar Aluno ---------------------------");
                System.out.println("------- [4.2] - Listar Alunos Cadastrados ------------------");
                int subSelectAluno = ler.nextInt();
                switch (subSelectAluno) {
                    case 1:
                        cadastrarPessoa(new Aluno());
                        break;
                    case 2:
                        listarAlunos();
                        break;
                    default:
                        System.out.println("\nOpção Inválida!\n");
                        menu();
                        break;
                }
                break;
            case 5:
                gerenciarMatriculaAlunos();
                break;
            case 6:
                emitirDeclaracaoMatricula();
                break;
            case 7:
                emitirDeclaracaoVinculo();
                break;
            case 8:
                encerrarPrograma();
                break;
            default:
                System.out.println("\nOpção Inválida!\n");
                menu();
                break;
        }
    }

    public static ArrayList<Aluno> cadastroDeAlunos() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        for (Pessoa pessoa : cadastroDePessoas) {
            if (pessoa instanceof Aluno) {
                alunos.add((Aluno) pessoa);
            }
        }
        return alunos;
    }

    public static ArrayList<Professor> cadastroDeProfessores() {
        ArrayList<Professor> professores = new ArrayList<>();
        for (Pessoa pessoa : cadastroDePessoas) {
            if (pessoa instanceof Professor) {
                professores.add((Professor) pessoa);
            }
        }
        return professores;
    }

    public static void listarProfessores() {
        System.out.println("\nLista de Professores Cadastrados:");
        ArrayList<Professor> professores = cadastroDeProfessores();
        for (int i = 0; i < professores.size(); i++) {
            System.out.println((i + 1) + ". " + professores.get(i).getNome());
        }
        System.out.println();
        menu(); // Volta para o menu principal
    }

    public static void listarAlunos() {
        System.out.println("\nLista de Alunos Cadastrados:");
        ArrayList<Aluno> alunos = cadastroDeAlunos();
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println((i + 1) + ". " + alunos.get(i).getNome());
        }
        System.out.println();
        menu(); // Volta para o menu principal
    }

    public static void cadastrarPessoa(Pessoa pessoa) {
        Scanner ler = new Scanner(System.in);

        System.out.println("\n\n --------------- CADASTRAR NOVO " + (pessoa instanceof Aluno ? "ALUNO" : "PROFESSOR") + " ------------------");

        System.out.print("Nome: ");
        pessoa.setNome(ler.nextLine().toUpperCase());

        System.out.print("Data de Nascimento: ");
        pessoa.setDataNascimento(ler.nextLine());

        System.out.print("Endereço: ");
        pessoa.setEndereco(ler.nextLine());

        System.out.print("Telefone: ");
        pessoa.setTelefone(ler.nextLine());

        System.out.print("CPF: ");
        pessoa.setCPF(ler.nextLine());

        if (pessoa instanceof Aluno) {
            Aluno aluno = (Aluno) pessoa;
            System.out.print("Matrícula: ");
            aluno.setMatricula(ler.nextInt());
        }

        cadastroDePessoas.add(pessoa);

        System.out.println((pessoa instanceof Aluno ? "Aluno" : "Professor") + " cadastrado com sucesso! Voltando ao menu inicial . . .\n");
        menu();
    }
    public static void cadastrarDisciplina() {
        Scanner ler = new Scanner(System.in);

        System.out.println("\n\n --------------- CADASTRAR NOVA DISCIPLINA ------------------");

        System.out.print("Nome da Disciplina: ");
        String nomeDisciplina = ler.nextLine();

        Disciplina disciplina = new Disciplina(nomeDisciplina);
        cadastroDeDisciplinas.add(disciplina);

        System.out.println("Disciplina cadastrada com sucesso! Voltando ao menu inicial . . .\n");
        menu();
    }

    public static void cadastrarTurma() {
        Scanner ler = new Scanner(System.in);

        System.out.println("\n\n --------------- CADASTRAR NOVA TURMA ------------------");

        System.out.print("Nome da Turma: ");
        String nomeTurma = ler.nextLine();

        System.out.println("Disciplinas disponíveis:");
        for (int i = 0; i < cadastroDeDisciplinas.size(); i++) {
            System.out.println((i + 1) + ". " + cadastroDeDisciplinas.get(i).getNome());
        }

        System.out.print("Selecione o número da disciplina para a turma: ");
        int indiceDisciplina = ler.nextInt();
        Disciplina disciplinaSelecionada = cadastroDeDisciplinas.get(indiceDisciplina - 1);

        System.out.println("Professores disponíveis:");
        for (int i = 0; i < cadastroDePessoas.size(); i++) {
            if (cadastroDePessoas.get(i) instanceof Professor) {
                System.out.println((i + 1) + ". " + cadastroDePessoas.get(i).getNome());
            }
        }

        System.out.print("Selecione o número do professor responsável pela turma: ");
        int indiceProfessor = ler.nextInt();
        Professor professorResponsavel = (Professor) cadastroDePessoas.get(indiceProfessor - 1);

        Turma turma = new Turma(nomeTurma, disciplinaSelecionada, professorResponsavel);
        cadastroDeTurmas.add(turma);

        professorResponsavel.responsavelPor(turma);

        System.out.println("Turma cadastrada com sucesso! Voltando ao menu inicial . . .\n");
        menu();
    }

    public static void gerenciarMatriculaAlunos() {
        Scanner ler = new Scanner(System.in);

        if (cadastroDeAlunos().size() == 999 || cadastroDeTurmas.size() == 999) {
            System.out.println("\n ****Nenhum aluno ou turma cadastrada!**** \nPor favor, selecione a Opcao [4] ou [3] para cadastrar novos alunos ou turmas.\n\n");
            menu();
        } else {
            System.out.println("\n..................... Gerenciar Matrícula de Alunos ....................\n");

            // Listar alunos
            System.out.println("Alunos disponíveis:");
            ArrayList<Aluno> alunosDisponiveis = cadastroDeAlunos();
            for (int i = 0; i < alunosDisponiveis.size(); i++) {
                System.out.println((i + 1) + ". " + alunosDisponiveis.get(i).getNome());
            }

            System.out.println("Turmas disponíveis:");
            for (int i = 0; i < cadastroDeTurmas.size(); i++) {
                System.out.println((i + 1) + ". " + cadastroDeTurmas.get(i).getNome() + " (Disciplina: " + cadastroDeTurmas.get(i).getDisciplina().getNome() + ")");
            }

            System.out.print("Selecione o número do aluno para matrícula ou alteração de dados: ");
            int indiceAluno = ler.nextInt();
            Aluno alunoSelecionado = alunosDisponiveis.get(indiceAluno - 1);

            // Opção para editar dados ou adicionar à nova turma
            System.out.println("Escolha uma opção:");
            System.out.println("1. Editar dados do aluno");
            System.out.println("2. Adicionar o aluno a uma nova turma");
            System.out.print("Selecione a opção: ");
            int opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    editarDadosAluno(alunoSelecionado);
                    break;
                case 2:
                    adicionarNovaTurma(alunoSelecionado);
                    break;
                default:
                    System.out.println("\nOpção Inválida!\n");
                    menu();
                    break;
            }
        }
    }

    private static void editarDadosAluno(Aluno aluno)
    {
        Scanner ler = new Scanner(System.in);

        // Mostrar os dados atuais do aluno
        System.out.println("\nDados atuais do Aluno:");
        aluno.exibirDados();

        // Permitir alteração dos dados
        System.out.println("\nDigite os novos dados do Aluno:");

        System.out.print("Nome: ");
        aluno.setNome(ler.nextLine().toUpperCase()); // Consumir a quebra de linha pendente
        aluno.setNome(ler.nextLine().toUpperCase());

        System.out.print("Data de Nascimento: ");
        aluno.setDataNascimento(ler.nextLine());

        System.out.print("Endereço: ");
        aluno.setEndereco(ler.nextLine());

        System.out.print("Telefone: ");
        aluno.setTelefone(ler.nextLine());

        System.out.print("CPF: ");
        aluno.setCPF(ler.nextLine());

        // Mostrar os dados atualizados do aluno
        System.out.println("\nDados atualizados do Aluno:");
        aluno.exibirDados();

        System.out.println("Dados do aluno atualizados com sucesso! Voltando ao menu inicial . . .\n");
        menu();
    }

    private static void adicionarNovaTurma(Aluno aluno)
    {
        Scanner ler = new Scanner(System.in);

        System.out.println("Turmas disponíveis para matrícula:");
        for (int i = 0; i < cadastroDeTurmas.size(); i++)
        {
            System.out.println((i + 1) + ". " + cadastroDeTurmas.get(i).getNome() + " (Disciplina: " + cadastroDeTurmas.get(i).getDisciplina().getNome() + ")");
        }

        System.out.print("Selecione o número da turma para matrícula: ");
        int indiceTurma = ler.nextInt();
        Turma turmaSelecionada = cadastroDeTurmas.get(indiceTurma - 1);

        aluno.matricular(turmaSelecionada);

        System.out.println("Matrícula realizada com sucesso! Voltando ao menu inicial . . .\n");
        menu();
    }

    public static void emitirDeclaracaoMatricula()
    {
        Scanner ler = new Scanner(System.in);

        if (cadastroDeAlunos().size() == 0)
        {
            System.out.println("\n ****Nenhum aluno cadastrado!**** \nPor favor, selecione a Opcao [4] para cadastrar novos alunos.\n\n");
            menu();
        } else
        {
            System.out.println("\n..................... Emitir Declaração de Matrícula ....................\n");

            System.out.println("Alunos ativos:");
            ArrayList<Aluno> alunosAtivos = cadastroDeAlunos();
            for (int i = 0; i < alunosAtivos.size(); i++) {
                System.out.println((i + 1) + ". " + alunosAtivos.get(i).getNome());
            }

            System.out.print("Selecione o número do aluno para a declaração de matrícula: ");
            int indiceAluno = ler.nextInt();
            Aluno alunoSelecionado = alunosAtivos.get(indiceAluno - 1);

            System.out.println("\nDeclaração de Matrícula para " + alunoSelecionado.getNome() + ":");
            alunoSelecionado.exibirDados();

            System.out.println("Declaração de Matrícula emitida com sucesso! Voltando ao menu inicial . . .\n");
            menu();
        }
    }

    public static void emitirDeclaracaoVinculo()
    {
        Scanner ler = new Scanner(System.in);

        if (cadastroDeProfessores().size() == 0)
        {
            System.out.println("\n ****Nenhum professor cadastrado!**** \nPor favor, selecione a Opcao [1] para cadastrar novos professores.\n\n");
            menu();
        } else
        {
            System.out.println("\n..................... Emitir Declaração de Vínculo ....................\n");

            System.out.println("Professores ativos:");
            ArrayList<Professor> professoresAtivos = cadastroDeProfessores();
            for (int i = 0; i < professoresAtivos.size(); i++) {
                System.out.println((i + 1) + ". " + professoresAtivos.get(i).getNome());
            }

            System.out.print("Selecione o número do professor para a declaração de vínculo: ");
            int indiceProfessor = ler.nextInt();
            Professor professorSelecionado = professoresAtivos.get(indiceProfessor - 1);

            System.out.println("\nDeclaração de Vínculo para " + professorSelecionado.getNome() + ":");
            professorSelecionado.exibirDados();

            System.out.println("Declaração de Vínculo emitida com sucesso! Voltando ao menu inicial . . .\n");
            menu();
        }
    }
    public static void encerrarPrograma()
    {
        System.exit(0);
    }
}