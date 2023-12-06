import java.util.ArrayList;

public class Professor extends Pessoa
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