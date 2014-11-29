package br.org.furb.view;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

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
	}

	public void buscarNotificacoes() throws Exception {
		model.clear();
		
		//TODO adicionar notificações aqui
		String strTemp = "";
		for( String str: strTemp.split(";")){
			model.addElement(str);
		}
	}
}
