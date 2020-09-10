package model;

public class Funcionario {

	private int id;
	private String nome, endereco, especialidade, competencias, periodo;
	private double valorHora;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCompetencias() {
		return competencias;
	}

	public void setCompetencias(String competencias) {
		this.competencias = competencias;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", especialidate="
				+ especialidade + ", competencias=" + competencias + ", periodo=" + periodo + ", valorHora=" + valorHora
				+ "]";
	}

	public String toCSV() {
		return id + ";" + nome + ";" + endereco + ";" + especialidade + ";" + competencias + ";" + periodo + ";"
				+ valorHora + "\r\n";
	}

	public String[] getStringVetor() {
		return new String[] {""+ id + "", nome, endereco, especialidade, competencias, periodo, valorHora + "" };
	}
}
