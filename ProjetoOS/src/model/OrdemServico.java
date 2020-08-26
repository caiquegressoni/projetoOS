package model;

public class OrdemServico {

	private int id;
	private String dataAgendamento, dataExecucao, endereco;
	private int totalHora;
	private Funcionario funcionario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(String dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public String getDataExecucao() {
		return dataExecucao;
	}

	public void setDataExecucao(String dataExecucao) {
		this.dataExecucao = dataExecucao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getTotalHora() {
		return totalHora;
	}

	public void setTotalHora(int totalHora) {
		this.totalHora = totalHora;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
