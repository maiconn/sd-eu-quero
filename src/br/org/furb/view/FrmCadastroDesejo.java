package br.org.furb.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class FrmCadastroDesejo extends JFrame {

	private JPanel contentPane;
	private JTextField edTitulo;
	private JTextField edDescricao;
	private JTextField edCategoria;
	private JTextField edDataTermino;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastroDesejo frame = new FrmCadastroDesejo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmCadastroDesejo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeDesejos = new JLabel("Cadastro de Desejos");
		lblCadastroDeDesejos.setBounds(0, 0, 520, 14);
		contentPane.add(lblCadastroDeDesejos);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo");
		lblTtulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTtulo.setBounds(80, 67, 46, 14);
		contentPane.add(lblTtulo);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescrio.setBounds(80, 93, 46, 14);
		contentPane.add(lblDescrio);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setBounds(58, 119, 68, 14);
		contentPane.add(lblCategoria);
		
		JLabel lblDataDeTrmino = new JLabel("Data de término");
		lblDataDeTrmino.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataDeTrmino.setBounds(35, 145, 91, 14);
		contentPane.add(lblDataDeTrmino);
		
		edTitulo = new JTextField();
		edTitulo.setBounds(134, 64, 86, 20);
		contentPane.add(edTitulo);
		edTitulo.setColumns(10);
		
		edDescricao = new JTextField();
		edDescricao.setBounds(134, 90, 86, 20);
		contentPane.add(edDescricao);
		edDescricao.setColumns(10);
		
		edCategoria = new JTextField();
		edCategoria.setBounds(134, 116, 86, 20);
		contentPane.add(edCategoria);
		edCategoria.setColumns(10);
		
		edDataTermino = new JTextField();
		edDataTermino.setBounds(134, 142, 86, 20);
		contentPane.add(edDataTermino);
		edDataTermino.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(131, 173, 89, 23);
		contentPane.add(btnSalvar);
	}
}
