public class Turma{
    String nome;
    String horario; // Adicionando horário
    String codigo; // Adicionando código
    int quantidadeMaxAlunos; // Adicionando quantidade máxima de alunos
    Disciplina disciplina;
    Professor responsavel;

    public Turma(String nome, String horario, String codigo, int quantidadeMaxAlunos, Disciplina disciplina, Professor responsavel) {
        this.nome = nome;
        this.horario = horario;
        this.codigo = codigo;
        this.quantidadeMaxAlunos = quantidadeMaxAlunos;
        this.disciplina = disciplina;
        this.responsavel = responsavel;
    }

    public String getNome()
    {
        return nome;
    }

    public String getHorario()
    {
        return horario;
    }

    public String getCodigo()
    {
        return codigo;
    }

    public int getQuantidadeMaxAlunos()
    {
        return quantidadeMaxAlunos;
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