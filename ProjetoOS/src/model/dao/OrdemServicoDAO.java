package model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.OrdemServico;

public class OrdemServicoDAO {
	

	private OrdemServico ordemservico;
	private BufferedReader br;
	private BufferedWriter bw;
	private String arquivo = ".\\bd\\ordemservico.csv";
	private String campos[];

	public boolean save(ArrayList<OrdemServico> ordemservicos) {

		boolean retorno = false;

		try {

			bw = new BufferedWriter(new FileWriter(arquivo, false));

			for (OrdemServico os: ordemservicos) {

				bw.write(os.toCSV());

			}

			bw.close();

		} catch (IOException e) {

			System.out.println("Erro ao salvar" + e);
		}

		return retorno;
	}

	public ArrayList<OrdemServico> open() {

		ArrayList<OrdemServico> ordemservicos = new ArrayList<>();

		try {

			br = new BufferedReader(new FileReader(arquivo));

			String linha = br.readLine();

			while (linha != null) {

				campos = linha.split(";");

				ordemservico = new OrdemServico();
				ordemservico.setId(Integer.parseInt(campos[0]));
				ordemservico.setDataAgendamento(campos[1]);
				ordemservico.setDataExecucao(campos[2]);
				ordemservico.setEndereco(campos[3]); 
				ordemservico.setTotalHora(Integer.parseInt(campos[4])); 
				ordemservicos.add(ordemservico);
				linha = br.readLine();
			}
			br.close();

		} catch (FileNotFoundException e) {

			System.out.println("Não foi possivel encontrar o arquivo" + e);

		} catch (IOException e) {

			System.out.println(e);

		}
		return ordemservicos;
	}
}
