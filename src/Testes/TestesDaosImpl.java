package Testes;

import java.util.Date;

import br.org.furb.controller.dao.DAO;
import br.org.furb.controller.dao.impl.DesejoDaoImpl;
import br.org.furb.controller.dao.impl.OfertaDaoImpl;
import br.org.furb.controller.dao.impl.UsuarioDaoImpl;
import br.org.furb.model.Desejo;
import br.org.furb.model.Oferta;
import br.org.furb.model.StatusDesejo;
import br.org.furb.model.StatusOferta;
import br.org.furb.model.Usuario;

public class TestesDaosImpl {

	public static void main(String[] args) throws Exception {
		Usuario usuario = new Usuario();
		DAO<Usuario> usuarioDaoImpl = new UsuarioDaoImpl();
		
		/*usuario.setId(usuarioDaoImpl.incrementar());
		usuario.setNome("André Vinícius Bampi");
		usuario.setSenha("123456");
		usuario.setCep(89110000);
		usuario.setEmail("andre_bampi@hotmail.com");
		usuario.setTelefone("(47)9650-6634");
		usuarioDaoImpl.salvar(usuario); */
		
		//usuario.setId(5);
		//usuarioDaoImpl.excluir(usuario);
		
		/*usuario.setId(3);
		usuario.setNome("Teobaldo Rêgo");
		usuario.setSenha("654321");
		usuario.setCep(54546564);
		usuario.setEmail("teobaldo_rego@hotmail.com");
		usuario.setTelefone("245345454");
		usuarioDaoImpl.editar(usuario);*/
		
		/*usuario.setId(3);
		usuario = usuarioDaoImpl.buscar(usuario);
		System.out.println(usuario.getId() + ", " + usuario.getNome());*/
		
		
		
		Oferta oferta = new Oferta();
		DAO<Oferta> ofertaDaoImpl = new OfertaDaoImpl();
		
		/*oferta.setId(ofertaDaoImpl.incrementar());
		oferta.setDescricao("Goiaba");
		oferta.setDataCriacao(new Date("10/12/2014"));
		oferta.setDataTermino(new Date("10/12/2014"));
		oferta.setLocal("Perto do ponto de ônibus na quebrada onde o mano mora");
		oferta.setQtdMinimaParticipantes(8001);
		oferta.setStatus(StatusOferta.ABERTA);
		oferta.setCaminhoImagem("/home/VendedorDeGoiaba/goiaba.png");
		oferta.setValorOferta(45.99);
		ofertaDaoImpl.salvar(oferta);*/
		
		//oferta.setId(4);
		//ofertaDaoImpl.excluir(oferta);
		
		/*oferta.setId(3);
		oferta.setDescricao("Passagem de ônibus pra outra quebrada");
		oferta.setDataCriacao(new Date("31/11/2014"));
		oferta.setDataTermino(new Date("02/01/2015"));
		oferta.setLocal("No ponto de ônibus na quebrada onde o mano mora");
		oferta.setQtdMinimaParticipantes(88);
		oferta.setStatus(StatusOferta.EM_VOTACAO);
		oferta.setCaminhoImagem("/home/VendedorDeGoiaba/passagem_busao.png");
		oferta.setValorOferta(1.50);
		ofertaDaoImpl.editar(oferta);*/
		
		
		
		Desejo desejo = new Desejo();
		DAO<Desejo> desejoDaoImpl = new DesejoDaoImpl();
		
		/*desejo.setIdDesejo(desejoDaoImpl.incrementar());
		desejo.setTitulo("Ônibus ou Goiaba");
		desejo.setDescricao("Será que eu pego o ônibus ou eu compro a goiaba?");
		desejo.setCaminhoImagem("/home/ManoDaQuebrada/duvida.gif");
		desejo.setCategoria("Zoeira");
		desejo.setDataCriacao(new Date("31/11/2014"));
		desejo.setDataTermino(new Date("02/01/2015"));
		desejo.setStatus(StatusDesejo.EM_VOTACAO);
		desejoDaoImpl.salvar(desejo);*/
		
		//desejo.setIdDesejo(4);
		//desejoDaoImpl.excluir(desejo);
		
		/*desejo.setIdDesejo(2);
		desejo.setTitulo("Show do Edy Lemond");
		desejo.setDescricao("Eu amputei meu cérebro e me deu vontade de ver um show do Edy Lemond.");
		desejo.setCaminhoImagem("/home/teobaldo/tuts_tuts_quero_ver.gif");
		desejo.setCategoria("Música Clássica");
		desejo.setDataCriacao(new Date("09/01/2014"));
		desejo.setDataTermino(new Date("10/01/2014"));
		desejo.setStatus(StatusDesejo.ABERTO);
		desejoDaoImpl.editar(desejo);*/
	}

}
