
public class Disciplina {
	String nome;
	String codigo; // Adicionando código
	int cargaHoraria; // Adicionando carga horária

	public Disciplina(String nome, String codigo, int cargaHoraria) {
	        this.nome = nome;
	        this.codigo = codigo;
	        this.cargaHoraria = cargaHoraria;
	    }
	public String getNome()
	    {
	        return nome;
	    }

	public String getCodigo()
	    {
	        return codigo;
	    }

	public int getCargaHoraria()
	    {
	        return cargaHoraria;
	    }
	
}