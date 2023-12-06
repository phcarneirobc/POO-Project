import java.util.ArrayList;

public class Aluno extends Pessoa
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
