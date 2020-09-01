package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
	
	FuncionarioForm(){
		setTitle("Cadastro de Funcionarios");
		setBounds(250, 150, 700, 420);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);
		
		lbId = new JLabel("Id");
		lbNome = new JLabel("Nome");
		lbendereco = new JLabel("Endereço");
		lbespecialidade = new JLabel("Especialidade"); 
		lbcompetencias = new JLabel("Competencias"); 
		lbperiodo = new JLabel("Periodo"); 
		lbvalorHora = new JLabel("Valor por hora");
		
		tfId = new JTextField();
		tfId.setText(String.format("%d", Id));
		tfId.setEnabled(false);
		tfNome = new JTextField();
		tfendereco = new JTextField();
		tfespecialidade = new JTextField();
		tfcompetencias = new JTextField();
		tfperiodo = new JTextField();
		tfvalorHora = new JTextField();
		
		panel.add(lbId);
		panel.add(lbNome);
		panel.add(lbendereco);
		panel.add(lbespecialidade);
		panel.add(lbcompetencias);
		panel.add(lbperiodo);
		panel.add(lbvalorHora);
		
		panel.add(tfId);
		panel.add(tfNome);
		panel.add(tfendereco);
		panel.add(tfespecialidade);
		panel.add(tfcompetencias);
		panel.add(tfperiodo);
		panel.add(tfvalorHora);
		
		lbId.setBounds(10, 20, 15, 15);
		lbNome.setBounds(40, 20, 50, 15);
		lbendereco.setBounds(110, 20, 60, 15);
		lbespecialidade.setBounds(250, 20, 80, 15);
		lbcompetencias.setBounds(370, 20, 100, 15);
		lbperiodo.setBounds(510, 20, 60, 15);
		lbvalorHora.setBounds(570, 20, 100, 15);
		
		tfId.setBounds(5, 34, 20, 20);
		tfNome.setBounds(25, 34, 75, 20);
		tfendereco.setBounds(100, 34, 120, 20);
		tfespecialidade.setBounds(220, 34, 150, 20);
		tfcompetencias.setBounds(370, 34, 140, 20);
		tfperiodo.setBounds(510, 34, 60, 20);
		tfvalorHora.setBounds(570, 34, 100, 20);
		
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
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
