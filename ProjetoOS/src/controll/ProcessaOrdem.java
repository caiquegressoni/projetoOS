package controll;

import java.util.ArrayList;

import model.OrdemServico;
import model.dao.OrdemServicoDAO;

public class ProcessaOrdem {

	private static OrdemServicoDAO osd = new OrdemServicoDAO();
	
	private static ArrayList<OrdemServico> ordemservicos = osd.open();
	
	public static ArrayList<OrdemServico> getOrdemServicos() {
		return ordemservicos;
	}

	public static void setOrdemServicos(ArrayList<OrdemServico> ordemservicos) {
		ProcessaOrdem.ordemservicos = ordemservicos;
		osd.save(ordemservicos);
	}
	
//Cria o Id automatico
	
	public static int getAutoId() {
		if (ProcessaOrdem.ordemservicos.isEmpty())
			return 1;
		else
			return ProcessaOrdem.ordemservicos.get(ProcessaOrdem.ordemservicos.size() - 1).getId() + 1;
	}

}
