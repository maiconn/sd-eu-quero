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
import br.org.furb.model.Desejo;

public class DesejoDaoImpl implements DAO<Desejo> {


    private static final String TABELA = "desejo";

    @Override
    public boolean salvar(Desejo desejo) throws Exception {
        DB conexao = null;
        try {
            conexao = ConnectionMongoDB.getConnection();
            DBCollection collection = conexao.getCollection(TABELA);

            collection.insert(desejo.getBasicDBObject());

            return true;
        } catch (Exception ex) {
            throw ex;
        } finally {
            ConnectionMongoDB.closeConnection(conexao);
        }
    }

    @Override
    public boolean excluir(Desejo desejo) throws Exception {
        DB conexao = null;
        try {
            conexao = ConnectionMongoDB.getConnection();
            DBCollection collection = conexao.getCollection(TABELA);

            collection.remove(new BasicDBObject("idDesejo", desejo.getIdDesejo()));

            return true;
        } catch (Exception ex) {
            throw ex;
        } finally {
            ConnectionMongoDB.closeConnection(conexao);
        }
    }

    @Override
    public List<Desejo> listar() throws Exception {
        DB conexao = null;
        try {
            conexao = ConnectionMongoDB.getConnection();
            DBCollection collection = conexao.getCollection(TABELA);

            List<Desejo> list = new ArrayList<Desejo>();

            DBCursor cursor = collection.find();
            while (cursor.hasNext()) {
                Desejo d = new Desejo();
                d.convertDBObjectToObject(cursor.next());
                list.add(d);
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
    public List<Desejo> listar(Desejo desejoInicial, Desejo desejoFinal) throws Exception {
        if (desejoInicial != null) {
            DB conexao = null;
            try {
                conexao = ConnectionMongoDB.getConnection();
                DBCollection collection = conexao.getCollection(TABELA);

                BasicDBObject filtro = new BasicDBObject();
                if (desejoInicial.getIdDesejo() < 0) {
                    filtro.put("idDesejo", desejoInicial.getIdDesejo());
                }

                if (desejoInicial.getDescricao() != null) {
                    filtro.put("descricao", java.util.regex.Pattern.compile(desejoInicial.getDescricao()));
                }

                if (desejoInicial.getCaminhoImagem() != null) {
                    filtro.put("caminhoImagem", java.util.regex.Pattern.compile(desejoInicial.getCaminhoImagem()));
                }

                if (desejoInicial.getDataCriacao() != null) {
                    filtro.put("dataCriacao", (desejoInicial.getDataCriacao()));
                }

                if (desejoInicial.getDataTermino() != null) {
                    filtro.put("dataTermino", (desejoInicial.getDataTermino()));
                }

                if (desejoInicial.getStatus() != null) {
                    filtro.put("status", (desejoInicial.getStatus().ordinal()));
                }
                
                if (desejoInicial.getCategoria() != null) {
                    filtro.put("categoria", java.util.regex.Pattern.compile(desejoInicial.getCategoria()));
                }

                DBCursor cursor = collection.find(filtro);

                List<Desejo> list = new ArrayList<Desejo>();
                while (cursor.hasNext()) {
                    Desejo d = new Desejo();
                    d.convertDBObjectToObject(cursor.next());
                    list.add(d);
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
    public boolean editar(Desejo desejo) throws Exception {
        if (desejo != null) {
            DB conexao = null;
            try {
                conexao = ConnectionMongoDB.getConnection();
                DBCollection collection = conexao.getCollection(TABELA);

                collection.update(new BasicDBObject().append("idDesejo", desejo.getIdDesejo()), desejo.getBasicDBObject());

                return true;
            } catch (Exception ex) {
                throw ex;
            } finally {
                ConnectionMongoDB.closeConnection(conexao);
            }
        } else {
            throw new SQLException("Desejo inválido");
        }
    }

    @Override
    public Desejo buscar(Desejo desejo) throws Exception {
        DB conexao = null;
        try {
            conexao = ConnectionMongoDB.getConnection();
            DBCollection collection = conexao.getCollection(TABELA);

            DBCursor cursor = collection.find(new BasicDBObject("idDesejo", desejo.getIdDesejo()));
            if (cursor.hasNext()) {
                Desejo d = new Desejo();
                d.convertDBObjectToObject(cursor.next());
                return d;
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

            return ConnectionMongoDB.nextId(collection, "idDesejo");
        } catch (Exception ex) {
            throw ex;
        } finally {
            ConnectionMongoDB.closeConnection(conexao);
        }
    }

}
