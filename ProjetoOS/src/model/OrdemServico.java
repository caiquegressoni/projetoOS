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
		OrdemServico other = (OrdemServico) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String toString() {
		return "OrdemServico [id=" + id + ", dataAgendamento=" + dataAgendamento + ", dataExecucao=" + dataExecucao
				+ ", endereco=" + endereco + ", totalHora=" + totalHora + ", funcionario=" + funcionario + "]";
	}
}
