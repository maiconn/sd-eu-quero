package br.org.furb.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import br.org.furb.model.Sessao;
import br.org.furb.model.Usuario;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lblUsuariologado;
	private JButton btnNotificaes, btnMinhasOfertas, btnMeusDesejos, btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		setTitle("Sistema Eu Quero");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		panel.setBounds(0, 0, 559, 58);
		contentPane.add(panel);
		panel.setLayout(null);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnLogin.getText().equals("Login")) {
					new DlgUsuario().setVisible(true);
				} else {
					Sessao.getInstance().setUsuario(null);
				}
				verificaUsuario();
			}
		});
		btnLogin.setBounds(474, 7, 75, 23);
		panel.add(btnLogin);

		btnMeusDesejos = new JButton("Meus Desejos");
		btnMeusDesejos.setBounds(365, 7, 99, 23);
		panel.add(btnMeusDesejos);

		btnMinhasOfertas = new JButton("Minhas Ofertas");
		btnMinhasOfertas.setBounds(249, 7, 114, 23);
		panel.add(btnMinhasOfertas);

		lblUsuariologado = new JLabel("USUARIO_LOGADO");
		lblUsuariologado.setBounds(32, 33, 331, 14);
		panel.add(lblUsuariologado);

		JLabel lblOl = new JLabel("Olá");
		lblOl.setBounds(10, 33, 25, 14);
		panel.add(lblOl);

		btnNotificaes = new JButton("Notificações");
		btnNotificaes.setBounds(147, 7, 99, 23);
		panel.add(btnNotificaes);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Desejos Criados",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 58, 415, 311);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		String[] teste2 = { "Desejo1", "Desejo2", "Desejo3" };
		JList list2 = new JList(teste2);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list2);
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 395, 289);
		panel_1.add(scrollPane);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Anuncios",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(417, 58, 142, 311);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		String[] teste = { "Tenis Adidas R$50", "Notebook Apple R$10000",
				"TESSSSSSSSSSSSSSEEEEE" };
		JList list = new JList(teste);
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(10, 11, 122, 289);
		panel_2.add(scroll);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setViewportView(list);
		verificaUsuario();
	}

	public void verificaUsuario() {
		Usuario usuarioLogado = Sessao.getInstance().getUsuario();
		lblUsuariologado.setText(usuarioLogado == null ? "" : usuarioLogado
				.getNome());
		btnLogin.setText(usuarioLogado == null ? "Login" : "Logoff");
		btnMeusDesejos.setVisible(usuarioLogado != null);
		btnMinhasOfertas.setVisible(usuarioLogado != null);
		btnNotificaes.setVisible(usuarioLogado != null);

		// TODO VERIFICAR ANUNCIOS...
	}
}
