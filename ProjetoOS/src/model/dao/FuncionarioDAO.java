package model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Funcionario;

public class FuncionarioDAO {

	private Funcionario funcionario;
	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = ".\\bd\\ordensdeservico.csv";
	private String campos[];

	public boolean save(ArrayList<Funcionario> funcionarios) {
		boolean retorno = false;
		try {
			bw = new BufferedWriter(new FileWriter(arquivo, false));
			for (Funcionario f : funcionarios) {
				bw.write(f.toCSV());
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Erro ao salvar" + e);
		}

		return retorno;
	}
	

		
	}
