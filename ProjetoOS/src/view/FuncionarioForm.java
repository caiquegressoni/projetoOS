package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import controll.ProcessaFuncionario;
import model.Funcionario;

public class FuncionarioForm extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTable table;
	private DefaultTableModel tbModel;
	private JScrollPane scroll;
	private JButton btAdd, btDel, btCancelar, btSalvar;
	private int Id;
	private JLabel lbId, lbNome, lbendereco, lbespecialidade, lbcompetencias, lbperiodo, lbvalorHora;
	private JTextField tfId, tfNome, tfendereco, tfespecialidade, tfcompetencias, tfperiodo, tfvalorHora;
	private Funcionario funcionario;

	FuncionarioForm() {
		setTitle("Cadastro de Funcionarios");
		setBounds(250, 150, 700, 420);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);
		Id = ProcessaFuncionario.getAutoId();
		// Configuração do JLabel

		lbId = new JLabel("Id");
		lbNome = new JLabel("Nome");
		lbendereco = new JLabel("Endereço");
		lbespecialidade = new JLabel("Especialidade");
		lbcompetencias = new JLabel("Competencias");
		lbperiodo = new JLabel("Periodo");
		lbvalorHora = new JLabel("Valor por hora");

		panel.add(lbId);
		panel.add(lbNome);
		panel.add(lbendereco);
		panel.add(lbespecialidade);
		panel.add(lbcompetencias);
		panel.add(lbperiodo);
		panel.add(lbvalorHora);

		lbId.setBounds(10, 20, 15, 15);
		lbNome.setBounds(40, 20, 50, 15);
		lbendereco.setBounds(110, 20, 60, 15);
		lbespecialidade.setBounds(250, 20, 80, 15);
		lbcompetencias.setBounds(370, 20, 100, 15);
		lbperiodo.setBounds(530, 20, 60, 15);
		lbvalorHora.setBounds(580, 20, 100, 15);

		// Configuração do TextField

		tfId = new JTextField();
		tfId.setText(String.format("%d", Id));
		tfId.setEnabled(false);
		tfNome = new JTextField();
		tfendereco = new JTextField();
		tfespecialidade = new JTextField();
		tfcompetencias = new JTextField();
		tfperiodo = new JTextField();
		tfvalorHora = new JTextField();

		panel.add(tfId);
		panel.add(tfNome);
		panel.add(tfendereco);
		panel.add(tfespecialidade);
		panel.add(tfcompetencias);
		panel.add(tfperiodo);
		panel.add(tfvalorHora);

		tfId.setBounds(5, 34, 20, 20);
		tfNome.setBounds(25, 34, 75, 20);
		tfendereco.setBounds(100, 34, 120, 20);
		tfespecialidade.setBounds(240, 34, 130, 20);
		tfcompetencias.setBounds(380, 34, 140, 20);
		tfperiodo.setBounds(530, 34, 50, 20);
		tfvalorHora.setBounds(580, 34, 90, 20);

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
		tbModel.addColumn("Nome");
		tbModel.addColumn("Endereço");
		tbModel.addColumn("Especialidade");
		tbModel.addColumn("Competencias");
		tbModel.addColumn("Periodo");
		tbModel.addColumn("Valor por Hora");

		for (Funcionario f : ProcessaFuncionario.getFuncionarios()) {
			tbModel.addRow(f.getStringVetor());
		}
		table = new JTable(tbModel);
		scroll = new JScrollPane(table);
		scroll.setBounds(10, 60, 670, 280);
		panel.add(scroll);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btAdd) {
			if (!tfNome.getText().isEmpty() && !tfendereco.getText().isEmpty() && !tfespecialidade.getText().isEmpty()
					&& !tfcompetencias.getText().isEmpty() && !tfperiodo.getText().isEmpty()
					&& !tfvalorHora.getText().isEmpty()) {

				funcionario = new Funcionario();

				funcionario.setId(Id);
				funcionario.setNome(tfNome.getText());
				funcionario.setEndereco(tfendereco.getText());
				funcionario.setEspecialidade(tfespecialidade.getText());
				funcionario.setCompetencias(tfcompetencias.getText());
				funcionario.setPeriodo(tfperiodo.getText());
				funcionario.setValorHora(Double.parseDouble(tfvalorHora.getText()));
				tbModel.addRow(funcionario.getStringVetor());

				Id++;
				tfId.setText(String.format("%d", Id));
				tfNome.setText("");
				tfendereco.setText("");
				tfespecialidade.setText("");
				tfcompetencias.setText("");
				tfperiodo.setText("");
				tfvalorHora.setText("");
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
			ArrayList<Funcionario> funcionarios = new ArrayList<>();

			for (int i = 0; i < tbModel.getRowCount(); i++) {
				funcionario = new Funcionario();

				funcionario.setId(Integer.parseInt((String) tbModel.getValueAt(i, 0)));
				funcionario.setNome((String) tbModel.getValueAt(i, 1));
				funcionario.setEndereco((String) tbModel.getValueAt(i, 2));
				funcionario.setEspecialidade(((String) tbModel.getValueAt(i, 3)));
				funcionario.setCompetencias(((String) tbModel.getValueAt(i, 4)));
				funcionario.setPeriodo((String) tbModel.getValueAt(i, 5));
				funcionario.setValorHora(Double.parseDouble((String) (tbModel.getValueAt(i, 6))));

				funcionarios.add(funcionario);
			}

			ProcessaFuncionario.setFuncionarios(funcionarios);
			dispose();
		}

	}
}
