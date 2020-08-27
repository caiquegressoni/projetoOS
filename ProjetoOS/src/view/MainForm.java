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
	private JMenuBar barraMenu;
	private JMenu menuArquivos;
	private JMenuItem itemFuncionario, itemOrdemServico, itemRelatorio, itemSair;
	
	MainForm(){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Tudo Limpo");
		setBounds(370, 150, 550, 430);
		panel = new JPanel();
		setJMenuBar(barraMenu);
		setContentPane(panel);
		setLayout(null);
		
		barraMenu = new JMenuBar();
		menuArquivos = new JMenu();
		itemFuncionario = new JMenuItem();
	}

		
		
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	public static void main(String[] args) {
		
	MainForm mf = new MainForm();
	mf.setVisible(true);
	}

}
