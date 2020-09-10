package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controll.ProcessaOrdem;
import model.OrdemServico;

public class OrdemForm extends JDialog implements ActionListener {


	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTable table;
	private DefaultTableModel tbModel;
	private JScrollPane scroll;
	private JButton btAdd, btDel, btCancelar, btSalvar;
	private int Id;
	private JLabel lbId, lbAgndamento, lbExecucao, lbEndereco, lbTotalHora;
	private JTextField tfId, tfAgendamento, tfExecucao, tfEndereco, tfTotalHora;
	private OrdemServico ordemservico;

	OrdemForm() {
		setTitle("Ordens de Servicos");
		setBounds(250, 150, 700, 420);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);
		Id = ProcessaOrdem.getAutoId();
		// Configuração do JLabel

		lbId = new JLabel("Id");
		lbAgndamento = new JLabel("Data de agendamento");
		lbExecucao= new JLabel("Data de execução");
		lbEndereco = new JLabel("Endereço");
		lbTotalHora = new JLabel("Total de horas");

		panel.add(lbId);
		panel.add(lbAgndamento);
		panel.add(lbExecucao);
		panel.add(lbEndereco);
		panel.add(lbTotalHora);

		lbId.setBounds(10, 20, 15, 15);
		lbAgndamento.setBounds(30, 20, 150, 15);
		lbExecucao.setBounds(160, 20, 150, 15);
		lbEndereco.setBounds(400, 20, 80, 15);
		lbTotalHora.setBounds(500, 20, 100, 15);
		// Configuração do TextField

		tfId = new JTextField();
		tfId.setText(String.format("%d", Id));
		tfId.setEnabled(false);
		tfAgendamento = new JTextField();
		tfExecucao = new JTextField();
		tfEndereco = new JTextField();
		tfTotalHora = new JTextField();
		
		panel.add(tfId);
		panel.add(tfAgendamento);
		panel.add(tfExecucao);
		panel.add(tfEndereco);
		panel.add(tfTotalHora);

		tfId.setBounds(5, 34, 20, 20);
		tfAgendamento.setBounds(25, 34, 75, 20);
		tfExecucao.setBounds(100, 34, 120, 20);
		tfEndereco.setBounds(400, 34, 130, 20);
		tfTotalHora.setBounds(500, 34, 50, 20);

		btAdd = new JButton("Add");
		panel.add(btAdd);
		btAdd.setBounds(10, 340, 70, 30);
		btAdd.addActionListener(this);

		btSalvar = new JButton("Salvar");
		panel.add(btSalvar);
		btSalvar.setBounds(590, 340, 80, 30);
		btSalvar.addActionListener(this);

		btCancelar = new JButton("Cancelar");
		panel.add(btCancelar);
		btCancelar.setBounds(80, 340, 90, 30);
		btCancelar.addActionListener(this);

		btDel = new JButton("Deletar");
		panel.add(btDel);
		btDel.setBounds(500, 340, 90, 30);
		btDel.addActionListener(this);

		tbModel = new DefaultTableModel();
		tbModel.addColumn("Id");
		tbModel.addColumn("Agendamento");
		tbModel.addColumn("Execucação");
		tbModel.addColumn("Endereço");
		tbModel.addColumn("Total de Horas");


		for (OrdemServico o: ProcessaOrdem.getOrdemServicos()) {
			tbModel.addRow(o.getStringVetor());
		}
		table = new JTable(tbModel);
		scroll = new JScrollPane(table);
		scroll.setBounds(10, 60, 670, 280);
		panel.add(scroll);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btAdd) {
			if (!tfAgendamento.getText().isEmpty() && !tfExecucao.getText().isEmpty() &&!tfTotalHora.getText().isEmpty()) {

				ordemservico = new OrdemServico();

				ordemservico.setId(Id);
				ordemservico.setDataAgendamento(tfAgendamento.getText());
				ordemservico.setDataExecucao(tfExecucao.getText());
				ordemservico.setEndereco(tfEndereco.getText());
				ordemservico.setTotalHora(Integer.parseInt(tfTotalHora.getText()));
				tbModel.addRow(ordemservico.getStringVetor());

				Id++;
				tfId.setText(String.format("%d", Id));
				tfAgendamento.setText("");
				tfExecucao.setText("");
				tfEndereco.setText("");
				tfTotalHora.setText("");
			}

		} else if (e.getSource() == btDel) {

			if (table.getSelectedRow() >= 0) {
				tbModel.removeRow(table.getSelectedRow());
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma linha");
			}
		} else if (e.getSource() == btCancelar) {
			dispose();
		} else {
			ArrayList<OrdemServico> ordemservicos = new ArrayList<>();

			for (int i = 0; i < tbModel.getRowCount(); i++) {
				ordemservico = new OrdemServico();

				ordemservico.setId(Integer.parseInt((String) tbModel.getValueAt(i, 0)));
				ordemservico.setDataAgendamento((String) tbModel.getValueAt(i, 1));
				ordemservico.setDataExecucao((String) tbModel.getValueAt(i, 2));
				ordemservico.setEndereco(((String) tbModel.getValueAt(i, 3)));
				ordemservico.setTotalHora(Integer.parseInt((String) tbModel.getValueAt(i, 4)));

				ordemservicos.add(ordemservico);
			}

			ProcessaOrdem.setOrdemServicos(ordemservicos);
			dispose();
		}

	}

}
