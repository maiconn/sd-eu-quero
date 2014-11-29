package br.org.furb.view;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import br.org.furb.controller.NotificacaoController;
import br.org.furb.model.Notificacao;
import br.org.furb.model.Sessao;
import br.org.furb.model.Usuario;

@SuppressWarnings("serial")
public class DlgNotificacoes extends JDialog {
	final DefaultListModel model = new DefaultListModel();

	/**
	 * Create the dialog.
	 */
	public DlgNotificacoes() {
		setModal(true);
		setTitle("Notificações");
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 316, 335);
		getContentPane().setLayout(null);
		JList list = new JList(model);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 310, 307);
		getContentPane().add(scrollPane);
		buscarNotificacoes();
	}

	public void buscarNotificacoes() {
		model.clear();
		
		NotificacaoController notificacaoController = new NotificacaoController();
		Usuario usuarioLogado = Sessao.getInstance().getUsuario();
		
		String strTemp;
		try {
			strTemp = notificacaoController.getNotificacoes(usuarioLogado.getId());
			for( String str: strTemp.split(";")){
				model.addElement(str);
			}
		} catch (Exception e1) {			
			JOptionPane.showMessageDialog(null, e1.getMessage(),
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
				
	}
}
