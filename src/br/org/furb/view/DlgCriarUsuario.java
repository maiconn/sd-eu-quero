package br.org.furb.view;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import br.org.furb.controller.UsuarioController;
import br.org.furb.model.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DlgCriarUsuario extends JDialog {
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JPasswordField txtSenha;
	private JTextField txtCep;
	private JTextField txtGostos;

	/**
	 * Create the dialog.
	 */
	public DlgCriarUsuario() {
		setResizable(false);
		setTitle("Cadastrar Usuário");
		setModal(true);
		setBounds(100, 100, 450, 238);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadastrarUsuario();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),
							"Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCadastrar.setBounds(114, 172, 128, 23);
		getContentPane().add(btnCadastrar);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 101, 14);
		getContentPane().add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(114, 8, 241, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 36, 101, 14);
		getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(114, 33, 241, 20);
		getContentPane().add(txtEmail);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 89, 101, 14);
		getContentPane().add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(114, 86, 241, 20);
		getContentPane().add(txtTelefone);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(10, 114, 101, 14);
		getContentPane().add(lblCep);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 64, 101, 14);
		getContentPane().add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(114, 61, 241, 20);
		getContentPane().add(txtSenha);

		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(114, 111, 241, 20);
		getContentPane().add(txtCep);
		
		txtGostos = new JTextField();
		txtGostos.setColumns(10);
		txtGostos.setBounds(114, 141, 241, 20);
		getContentPane().add(txtGostos);
		
		JLabel lblGostos = new JLabel("Gostos:");
		lblGostos.setBounds(10, 144, 101, 14);
		getContentPane().add(lblGostos);
	}

	public void cadastrarUsuario() throws Exception {
		Usuario usuario = new Usuario();
		if (!txtCep.getText().toString().trim().isEmpty())
			usuario.setCep(Integer.parseInt(txtCep.getText().toString().trim()));
		usuario.setEmail(txtEmail.getText().toString().trim());
		usuario.setNome(txtNome.getText().trim());
		usuario.setSenha(new String(txtSenha.getPassword()));
		usuario.setTelefone(txtTelefone.getText().toString().trim());
		usuario.setGostos(txtGostos.getText().toString().trim());
		
		if (new String(usuario.getCep() + "").isEmpty()) {
			throw new Exception("Favor digitar um cep.");
		}
		if (usuario.getEmail().isEmpty()) {
			throw new Exception("Favor digitar um e-mail.");
		}
		if (usuario.getNome().isEmpty()) {
			throw new Exception("Favor digitar um nome.");
		}
		if (usuario.getSenha().isEmpty()) {
			throw new Exception("Favor digitar uma senha.");
		}
		if (usuario.getTelefone().isEmpty()) {
			throw new Exception("Favor digitar uma telefone.");
		}

		new UsuarioController().cadastrarUsuario(usuario);
		JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso.",
				"Sucesso", JOptionPane.INFORMATION_MESSAGE);
		
		txtNome.setText("");
		txtEmail.setText("");
		txtSenha.setText("");
		txtTelefone.setText("");
		txtCep.setText("");
		txtGostos.setText("");
	}
}
