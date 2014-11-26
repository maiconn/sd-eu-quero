package br.org.furb.controller.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import br.org.furb.controller.dao.DAO;
import br.org.furb.controller.dao.util.ConnectionMongoDB;
import br.org.furb.model.Notificacao;

public class NotificacaoDaoImpl implements DAO<Notificacao> {
	
    private static final String TABELA = "notificacao";

    @Override
    public boolean salvar(Notificacao notificacao) throws Exception {
        DB conexao = null;
        try {
            conexao = ConnectionMongoDB.getConnection();
            DBCollection collection = conexao.getCollection(TABELA);

            collection.insert(notificacao.getBasicDBObject());

            return true;
        } catch (Exception ex) {
            throw ex;
        } finally {
            ConnectionMongoDB.closeConnection(conexao);
        }
    }

    @Override
    public boolean excluir(Notificacao notificacao) throws Exception {
        DB conexao = null;
        try {
            conexao = ConnectionMongoDB.getConnection();
            DBCollection collection = conexao.getCollection(TABELA);

            collection.remove(new BasicDBObject("id", notificacao.getId()));

            return true;
        } catch (Exception ex) {
            throw ex;
        } finally {
            ConnectionMongoDB.closeConnection(conexao);
        }
    }

    @Override
    public List<Notificacao> listar() throws Exception {
        DB conexao = null;
        try {
            conexao = ConnectionMongoDB.getConnection();
            DBCollection collection = conexao.getCollection(TABELA);

            List<Notificacao> list = new ArrayList<Notificacao>();

            DBCursor cursor = collection.find();
            while (cursor.hasNext()) {
                Notificacao n = new Notificacao();
                n.convertDBObjectToObject(cursor.next());
                list.add(n);
            }
            cursor.close();
            return list;
        } catch (Exception ex) {
            throw ex;
        } finally {
            ConnectionMongoDB.closeConnection(conexao);
        }
    }

    @Override
    public List<Notificacao> listar(Notificacao notificacaoInicial, Notificacao notificacaoFinal) throws Exception {
        if (notificacaoInicial != null) {
            DB conexao = null;
            try {
                conexao = ConnectionMongoDB.getConnection();
                DBCollection collection = conexao.getCollection(TABELA);

                BasicDBObject filtro = new BasicDBObject();
                if (notificacaoInicial.getId() < 0) {
                    filtro.put("id", notificacaoInicial.getId());
                }

                if (notificacaoInicial.getDescricao() != null) {
                    filtro.put("descricao", java.util.regex.Pattern.compile(notificacaoInicial.getDescricao()));
                }

                if (notificacaoInicial.getTipoNotificacao() != null) {
                    filtro.put("tipoNotificacao", (notificacaoInicial.getTipoNotificacao()));
                }

                if (notificacaoInicial.getStatus() != null) {
                    filtro.put("status", (notificacaoInicial.getStatus()));
                }

                DBCursor cursor = collection.find(filtro);

                List<Notificacao> list = new ArrayList<Notificacao>();
                while (cursor.hasNext()) {
                    Notificacao n = new Notificacao();
                    n.convertDBObjectToObject(cursor.next());
                    list.add(n);
                }
                cursor.close();
                return list;
            } catch (Exception ex) {
                throw ex;
            } finally {
                ConnectionMongoDB.closeConnection(conexao);
            }
        } else {
            return this.listar();
        }
    }

    @Override
    public boolean editar(Notificacao notificacao) throws Exception {
        if (notificacao != null) {
            DB conexao = null;
            try {
                conexao = ConnectionMongoDB.getConnection();
                DBCollection collection = conexao.getCollection(TABELA);

                collection.update(new BasicDBObject().append("id", notificacao.getId()), notificacao.getBasicDBObject());

                return true;
            } catch (Exception ex) {
                throw ex;
            } finally {
                ConnectionMongoDB.closeConnection(conexao);
            }
        } else {
            throw new SQLException("Notificação Inválida");
        }
    }

    @Override
    public Notificacao buscar(Notificacao notificacao) throws Exception {
        DB conexao = null;
        try {
            conexao = ConnectionMongoDB.getConnection();
            DBCollection collection = conexao.getCollection(TABELA);

            DBCursor cursor = collection.find(new BasicDBObject("id", notificacao.getId()));
            if (cursor.hasNext()) {
                Notificacao n = new Notificacao();
                n.convertDBObjectToObject(cursor.next());
                return n;
            }
            return null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            ConnectionMongoDB.closeConnection(conexao);
        }
    }

    @Override
    public int incrementar() throws Exception {
        DB conexao = null;
        try {
            conexao = ConnectionMongoDB.getConnection();
            DBCollection collection = conexao.getCollection(TABELA);

            return ConnectionMongoDB.nextId(collection, "id");
        } catch (Exception ex) {
            throw ex;
        } finally {
            ConnectionMongoDB.closeConnection(conexao);
        }
    }
}
