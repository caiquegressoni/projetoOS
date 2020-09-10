package model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Funcionario;

public class FuncionarioDAO {

	private Funcionario funcionario;
	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = ".\\bd\\funcionarios.csv";
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

	public ArrayList<Funcionario> open() {

		ArrayList<Funcionario> funcionarios = new ArrayList<>();

		try {

			br = new BufferedReader(new FileReader(arquivo));

			String linha = br.readLine();

			while (linha != null) {

				campos = linha.split(";");

				funcionario = new Funcionario();
				
				funcionario.setId(Integer.parseInt(campos[0]));
				funcionario.setNome(campos[1]);
				funcionario.setEndereco(campos[2]);
				funcionario.setEspecialidade(campos[3]);
				funcionario.setCompetencias(campos[4]);
				funcionario.setPeriodo(campos[5]);
				funcionario.setValorHora(Double.parseDouble(campos[6]));
			
				funcionarios.add(funcionario);
				linha = br.readLine();
			}
			br.close();

		} catch (FileNotFoundException e) {

			System.out.println("N�o foi possivel encontrar o arquivo" + e);

		} catch (IOException e) {

			System.out.println(e);

		}
		return funcionarios;
	}
}
