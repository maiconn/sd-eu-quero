package br.org.furb.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
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
	private JTextField edIdDesejo;

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
	}*/
	
	private void carregarDesejo() {
		if (Integer.parseInt(edIdDesejo.getText()) == 0) {
			limparCampos();
		} else {
			Desejo desejo = new Desejo();
			desejo.setIdDesejo(Integer.parseInt(edIdDesejo.getText()));
			try {
				desejo = desejoController.buscar(desejo);
				if (desejo != null) {
					limparCampos();
					edIdDesejo.setText(String.valueOf(desejo.getIdDesejo()));
					edCategoria.setText(desejo.getCategoria());
					edDataTermino.setText(new SimpleDateFormat("dd/MM/yyyy").format(desejo.getDataTermino()));
					edDescricao.setText(desejo.getDescricao());
					edTitulo.setText(desejo.getTitulo());
				}
			} catch (Exception e) {

			}
		}
	}
	
	private void limparCampos() {
		edIdDesejo.setText("0");
		edCategoria.setText("");
		edDataTermino.setText("");
		edDescricao.setText("");
		edTitulo.setText("");
	}

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
		lblTtulo.setBounds(65, 67, 61, 14);
		contentPane.add(lblTtulo);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescrio.setBounds(35, 93, 91, 14);
		contentPane.add(lblDescrio);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setBounds(35, 119, 91, 14);
		contentPane.add(lblCategoria);
		
		JLabel lblDataDeTrmino = new JLabel("Data de término");
		lblDataDeTrmino.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataDeTrmino.setBounds(24, 145, 102, 14);
		contentPane.add(lblDataDeTrmino);
		
		edTitulo = new JTextField();
		edTitulo.setBounds(134, 64, 200, 20);
		contentPane.add(edTitulo);
		edTitulo.setColumns(10);
		
		edDescricao = new JTextField();
		edDescricao.setBounds(134, 90, 200, 20);
		contentPane.add(edDescricao);
		edDescricao.setColumns(10);
		
		edCategoria = new JTextField();
		edCategoria.setBounds(134, 116, 200, 20);
		contentPane.add(edCategoria);
		edCategoria.setColumns(10);
		
		edDataTermino = new JTextField();
		edDataTermino.setBounds(134, 142, 200, 20);
		contentPane.add(edDataTermino);
		edDataTermino.setColumns(10);
		
		desejoController = new DesejoController();
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				Desejo desejo = new Desejo();
				desejo.setIdDesejo(Integer.parseInt(edIdDesejo.getText()));
				desejo.setCaminhoImagem("Caminho nenhum");
				desejo.setCategoria(edCategoria.getText());
				desejo.setDataCriacao(new Date());
				desejo.setDataTermino(new Date(edDataTermino.getText()));
				desejo.setDescricao(edDescricao.getText());
				desejo.setStatus(StatusDesejo.ABERTO);
				desejo.setTitulo(edTitulo.getText());
				desejo.setIdUsuario(Sessao.getInstance().getUsuario().getId());
				try {
					if (desejoController.buscar(desejo) == null) {
						desejoController.criarDesejo(desejo);
						limparCampos();
						JOptionPane.showMessageDialog(null, "Desejo criado com sucesso");
					} else {
						desejoController.editar(desejo);
						limparCampos();
						JOptionPane.showMessageDialog(null, "Desejo editado com sucesso");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnSalvar.setBounds(131, 173, 89, 23);
		contentPane.add(btnSalvar);
		
		edIdDesejo = new JTextField();
		edIdDesejo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					carregarDesejo();
				}
			}
		});
		edIdDesejo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				carregarDesejo();
			}
		});
		edIdDesejo.setText("0");
		edIdDesejo.setColumns(10);
		edIdDesejo.setBounds(134, 38, 200, 20);
		contentPane.add(edIdDesejo);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(65, 41, 61, 14);
		contentPane.add(lblId);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Integer.parseInt(edIdDesejo.getText()) != 0) {
					if (JOptionPane.showConfirmDialog(null, "Deseja excluir esse desejo e suas respectivas ofertas?") == JOptionPane.YES_OPTION) {
						Desejo desejo = new Desejo();
						desejo.setIdDesejo(Integer.parseInt(edIdDesejo.getText()));
						try {
							desejoController.excluir(desejo);
							limparCampos();
							JOptionPane.showMessageDialog(null, "Desejo excluído com sucesso.");
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Erro ao excluir o desejo.\n" + e1.getMessage());
						}
					}
				}
			}
		});
		btnExcluir.setBounds(245, 173, 89, 23);
		contentPane.add(btnExcluir);
	}
}
