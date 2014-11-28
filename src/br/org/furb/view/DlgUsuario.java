package br.org.furb.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.org.furb.controller.UsuarioController;
import br.org.furb.model.Sessao;
import br.org.furb.model.Usuario;

@SuppressWarnings("serial")
public class DlgUsuario extends JDialog {
	private JTextField email;
	private JPasswordField senha;

	/**
	 * Create the dialog.
	 */
	public DlgUsuario() {
		setModal(true);
		setTitle("Usuário");
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 189, 160);
		getContentPane().setLayout(null);
		{
			JLabel lblLogin = new JLabel("E-mail:");
			lblLogin.setBounds(10, 14, 46, 14);
			getContentPane().add(lblLogin);
		}

		email = new JTextField();
		email.setBounds(49, 11, 121, 20);
		getContentPane().add(email);
		email.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 36, 46, 14);
		getContentPane().add(lblSenha);

		senha = new JPasswordField();
		senha.setBounds(49, 33, 121, 20);
		getContentPane().add(senha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					autenticar();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),
							"Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEntrar.setBounds(49, 61, 121, 23);
		getContentPane().add(btnEntrar);

		JButton btnCriarUsurio = new JButton("Criar Usuário");
		btnCriarUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DlgCriarUsuario().setVisible(true);
			}
		});
		btnCriarUsurio.setBounds(49, 108, 121, 23);
		getContentPane().add(btnCriarUsurio);
	}

	public void autenticar() throws Exception {
		String emailStr = email.getText().trim().toString();
		String senhaStr = new String(senha.getPassword());
		if (emailStr.isEmpty()) {
			throw new Exception("Favor digitar um e-mail.");
		}
		if (senhaStr.isEmpty()) {
			throw new Exception("Favor digitar uma senha.");
		}

		Usuario autenticou = new UsuarioController().autenticar(emailStr,
				senhaStr);
		if (autenticou != null) {
			Sessao.getInstance().setUsuario(autenticou);
			this.dispose();
		} else {
			throw new Exception("Usuário ou senha incorretos.");
		}
	}
}
