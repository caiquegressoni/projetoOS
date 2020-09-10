package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainForm extends JFrame implements ActionListener {

	public static final long serialVersionUID = 1L;

	private JPanel panel;
	private JMenuBar barraMenu = new JMenuBar();
	private JMenu menu;
	private JMenuItem itemFuncionario, itemOrdemServico, itemRelatorio, itemSair;

	MainForm() {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Tudo Limpo");
		setBounds(370, 150, 670, 430);
		panel = new JPanel();
		setJMenuBar(barraMenu);
		setContentPane(panel);
		setLayout(null);

		menu = new JMenu("Menu");
		itemFuncionario = new JMenuItem("Funcionarios");
		itemOrdemServico = new JMenuItem("Ordens de Servi�o");
		itemRelatorio = new JMenuItem("Relatorio");
		itemSair = new JMenuItem("Sair");

		barraMenu.add(menu);
		menu.add(itemFuncionario);
		menu.add(itemOrdemServico);
		menu.add(itemRelatorio);
		menu.add(itemSair);
		
		itemFuncionario.addActionListener(this);
		itemOrdemServico.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == itemFuncionario) {
			FuncionarioForm  ff = new FuncionarioForm();
			ff.setModal(true);
			ff.setVisible(true);
		}else if(e.getSource() == itemOrdemServico) {
			OrdemForm of = new OrdemForm();
			of.setVisible(true);
			of.setModal(true);
		}
	}

	public static void main(String[] args) {
		MainForm mf = new MainForm();
		mf.setVisible(true);
	}

}
