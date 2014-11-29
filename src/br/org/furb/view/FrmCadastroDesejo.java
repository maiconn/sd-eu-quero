package br.org.furb.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.org.furb.controller.DesejoController;
import br.org.furb.model.Desejo;
import br.org.furb.model.Sessao;
import br.org.furb.model.StatusDesejo;

@SuppressWarnings("serial")
public class FrmCadastroDesejo extends JDialog {

	private JPanel contentPane;
	private JTextField edTitulo;
	private JTextField edDescricao;
	private JTextField edCategoria;
	private JTextField edDataTermino;
	private DesejoController desejoController;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	} */

	/**
	 * Create the frame.
	 */
	public FrmCadastroDesejo() {
		setResizable(false);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
		
		desejoController = new DesejoController();
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				Desejo desejo = new Desejo();
				desejo.setIdDesejo(0);	
				desejo.setCaminhoImagem("Caminho nenhum");
				desejo.setCategoria(edCategoria.getText());
				desejo.setDataCriacao(new Date());
				desejo.setDataTermino(new Date(edDataTermino.getText()));
				desejo.setDescricao(edDescricao.getText());
				desejo.setStatus(StatusDesejo.ABERTO);
				desejo.setTitulo(edTitulo.getText());
				desejo.setIdUsuario(Sessao.getInstance().getUsuario().getId());
				try {
					desejoController.criarDesejo(desejo);
					JOptionPane.showMessageDialog(null, "Desejo criado com sucesso");
					edCategoria.setText("");
					edDataTermino.setText("");
					edDescricao.setText("");
					edTitulo.setText("");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnSalvar.setBounds(131, 173, 89, 23);
		contentPane.add(btnSalvar);
	}
}
