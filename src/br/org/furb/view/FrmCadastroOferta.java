package br.org.furb.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FrmCadastroOferta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField edLocal;
	private JTextField edValor;
	private JTextField edDescricao;
	private JTextField edQtdeMinParticipantes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastroOferta frame = new FrmCadastroOferta();
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
	public FrmCadastroOferta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Salvar");
		button.setBounds(131, 194, 89, 23);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(134, 142, 86, 20);
		contentPane.add(textField);
		
		edLocal = new JTextField();
		edLocal.setColumns(10);
		edLocal.setBounds(134, 116, 86, 20);
		contentPane.add(edLocal);
		
		edValor = new JTextField();
		edValor.setColumns(10);
		edValor.setBounds(134, 90, 86, 20);
		contentPane.add(edValor);
		
		edDescricao = new JTextField();
		edDescricao.setColumns(10);
		edDescricao.setBounds(134, 64, 86, 20);
		contentPane.add(edDescricao);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescrio.setBounds(80, 67, 46, 14);
		contentPane.add(lblDescrio);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValor.setBounds(80, 93, 46, 14);
		contentPane.add(lblValor);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLocal.setBounds(58, 119, 68, 14);
		contentPane.add(lblLocal);
		
		JLabel label_3 = new JLabel("Data de término");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(35, 145, 91, 14);
		contentPane.add(label_3);
		
		JLabel lblCadastroDeOfertas = new JLabel("Cadastro de Ofertas");
		lblCadastroDeOfertas.setBounds(0, 0, 520, 14);
		contentPane.add(lblCadastroDeOfertas);
		
		JLabel lblQtdeMinParticipantes = new JLabel("Qtde Min. Participantes");
		lblQtdeMinParticipantes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQtdeMinParticipantes.setBounds(0, 171, 126, 14);
		contentPane.add(lblQtdeMinParticipantes);
		
		edQtdeMinParticipantes = new JTextField();
		edQtdeMinParticipantes.setColumns(10);
		edQtdeMinParticipantes.setBounds(134, 168, 86, 20);
		contentPane.add(edQtdeMinParticipantes);
	}
}
