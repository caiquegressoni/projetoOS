package controll;

import java.util.ArrayList;

import model.Funcionario;
import model.dao.FuncionarioDAO;

public class ProcessaFuncionario {

	private static FuncionarioDAO fd = new FuncionarioDAO();
	
	private static ArrayList<Funcionario> funcionarios = fd.open();
	
	public static ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public static void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		ProcessaFuncionario.funcionarios = funcionarios;
		fd.save(funcionarios);
	}
	
//Cria o Id automatico
	
	public static int getAutoId() {
		if (ProcessaFuncionario.funcionarios.isEmpty())
			return 1;
		else
			return ProcessaFuncionario.funcionarios.get(ProcessaFuncionario.funcionarios.size() - 1).getId() + 1;
	}

}