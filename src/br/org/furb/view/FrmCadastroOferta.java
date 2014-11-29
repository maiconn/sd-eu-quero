package br.org.furb.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import br.org.furb.controller.OfertaController;
import br.org.furb.model.Oferta;
import br.org.furb.model.Sessao;
import br.org.furb.model.StatusOferta;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class FrmCadastroOferta extends JDialog {

	private JPanel contentPane;
	private JTextField edDataTermino;
	private JTextField edLocal;
	private JTextField edValor;
	private JTextField edDescricao;
	private JTextField edQtdeMinParticipantes;
	private JTextField edIdDesejo;
	private OfertaController ofertaController;
	private JTextField edIdOferta;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/
	
	private void carregarOferta() {
		if (Integer.parseInt(edIdOferta.getText()) == 0) {
			limparCampos();
		} else {
			Oferta oferta = new Oferta();
			oferta.setId(Integer.parseInt(edIdOferta.getText()));
			try {
				oferta = ofertaController.buscar(oferta);
				if (oferta != null) {
					limparCampos();
					edIdOferta.setText(String.valueOf(oferta.getId()));
					edDataTermino.setText(new SimpleDateFormat("dd/MM/yyyy").format(oferta.getDataTermino()));
					edDescricao.setText(new SimpleDateFormat("dd/MM/yyyy").format(oferta.getDataCriacao()));
					edIdDesejo.setText(String.valueOf(oferta.getIdDesejo()));
					edLocal.setText(oferta.getLocal());
					edQtdeMinParticipantes.setText(String.valueOf(oferta.getQtdMinimaParticipantes()));
					edValor.setText(String.valueOf(oferta.getValorOferta()));
				}
			} catch (Exception e) {

			}
		}
	}

	private void limparCampos() {
		edIdOferta.setText("0");
		edDataTermino.setText("");
		edDescricao.setText("");
		edIdDesejo.setText("");
		edLocal.setText("");
		edQtdeMinParticipantes.setText("");
		edValor.setText("");
	}
	
	/**
	 * Create the frame.
	 */
	public FrmCadastroOferta() {
		setResizable(false);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 577, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ofertaController = new OfertaController();
		
		JButton button = new JButton("Salvar");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Oferta oferta = new Oferta();
				oferta.setCaminhoImagem("Caminho nenhum");
				oferta.setDataCriacao(new Date());
				oferta.setDataTermino(new Date(edDataTermino.getText()));
				oferta.setDescricao(edDescricao.getText());
				oferta.setIdDesejo(Integer.parseInt(edIdDesejo.getText()));
				oferta.setIdUsuario(Sessao.getInstance().getUsuario().getId());
				oferta.setLocal(edLocal.getText());
				oferta.setQtdMinimaParticipantes(Integer.parseInt(edQtdeMinParticipantes.getText()));
				oferta.setStatus(StatusOferta.ABERTA);
				oferta.setValorOferta(Double.parseDouble(edValor.getText()));
				try {
					if (ofertaController.buscar(oferta) == null) {
						ofertaController.criarOferta(oferta);
						limparCampos();
						JOptionPane.showMessageDialog(null, "Oferta criada com sucesso");
					} else {
						ofertaController.editar(oferta);
						limparCampos();
						JOptionPane.showMessageDialog(null, "Oferta editada com sucesso");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		button.setBounds(131, 221, 89, 23);
		contentPane.add(button);
		
		edDataTermino = new JTextField();
		edDataTermino.setColumns(10);
		edDataTermino.setBounds(134, 142, 200, 20);
		contentPane.add(edDataTermino);
		
		edLocal = new JTextField();
		edLocal.setColumns(10);
		edLocal.setBounds(134, 116, 200, 20);
		contentPane.add(edLocal);
		
		edValor = new JTextField();
		edValor.setColumns(10);
		edValor.setBounds(134, 90, 200, 20);
		contentPane.add(edValor);
		
		edDescricao = new JTextField();
		edDescricao.setColumns(10);
		edDescricao.setBounds(134, 64, 200, 20);
		contentPane.add(edDescricao);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescrio.setBounds(35, 67, 91, 14);
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
		label_3.setBounds(21, 145, 105, 14);
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
		edQtdeMinParticipantes.setBounds(134, 168, 200, 20);
		contentPane.add(edQtdeMinParticipantes);
		
		JLabel lblIdDoDesejo = new JLabel("ID do Desejo");
		lblIdDoDesejo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdDoDesejo.setBounds(0, 196, 126, 14);
		contentPane.add(lblIdDoDesejo);
		
		edIdDesejo = new JTextField();
		edIdDesejo.setColumns(10);
		edIdDesejo.setBounds(134, 194, 200, 20);
		contentPane.add(edIdDesejo);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(35, 41, 91, 14);
		contentPane.add(lblId);
		
		edIdOferta = new JTextField();
		edIdOferta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					carregarOferta();
				}
			}
		});
		edIdOferta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				carregarOferta();
			}
		});
		edIdOferta.setColumns(10);
		edIdOferta.setBounds(134, 38, 200, 20);
		contentPane.add(edIdOferta);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Integer.parseInt(edIdOferta.getText()) != 0) {
					if (JOptionPane.showConfirmDialog(null, "Deseja excluir essa oferta?") == JOptionPane.YES_OPTION) {
						Oferta oferta = new Oferta();
						oferta.setId(Integer.parseInt(edIdOferta.getText()));
						try {
							ofertaController.excluir(oferta);
							limparCampos();
							JOptionPane.showMessageDialog(null, "Oferta excluída com sucesso.");
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Erro ao excluir a oferta.\n" + e1.getMessage());
						}
					}
				}
			}
		});
		btnExcluir.setBounds(245, 221, 89, 23);
		contentPane.add(btnExcluir);
	}
}
