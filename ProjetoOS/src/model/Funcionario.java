package model;

import java.util.ArrayList;

public class Funcionario {

	private int id;
	private String nome, nascimento, endereco, especialidate, periodo;
	private ArrayList<String> competencias;
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

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEspecialidate() {
		return especialidate;
	}

	public void setEspecialidate(String especialidate) {
		this.especialidate = especialidate;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public ArrayList<String> getCompetencias() {
		return competencias;
	}

	public void setCompetencias(ArrayList<String> competencias) {
		this.competencias = competencias;
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
		return "Funcionario [id=" + id + ", nome=" + nome + ", nascimento=" + nascimento + ", endereco=" + endereco
				+ ", especialidate=" + especialidate + ", periodo=" + periodo + ", competencias=" + competencias
				+ ", valorHora=" + valorHora + "]";
	}

	public String toCSV() {
		return id + ";" + nome + ";" + nascimento + ";" + endereco + ";" + especialidate + ";" + periodo + ";"
				+ competencias + ";" + valorHora + ";";
	}
}