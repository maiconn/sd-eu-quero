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
import br.org.furb.model.Oferta;

public class OfertaDaoImpl implements DAO<Oferta> {


    private static final String TABELA = "oferta";

    @Override
    public boolean salvar(Oferta oferta) throws Exception {
        DB conexao = null;
        try {
            conexao = ConnectionMongoDB.getConnection();
            DBCollection collection = conexao.getCollection(TABELA);

            collection.insert(oferta.getBasicDBObject());

            return true;
        } catch (Exception ex) {
            throw ex;
        } finally {
            ConnectionMongoDB.closeConnection(conexao);
        }
    }

    @Override
    public boolean excluir(Oferta oferta) throws Exception {
        DB conexao = null;
        try {
            conexao = ConnectionMongoDB.getConnection();
            DBCollection collection = conexao.getCollection(TABELA);

            collection.remove(new BasicDBObject("id", oferta.getId()));

            return true;
        } catch (Exception ex) {
            throw ex;
        } finally {
            ConnectionMongoDB.closeConnection(conexao);
        }
    }

    @Override
    public List<Oferta> listar() throws Exception {
        DB conexao = null;
        try {
            conexao = ConnectionMongoDB.getConnection();
            DBCollection collection = conexao.getCollection(TABELA);

            List<Oferta> list = new ArrayList<Oferta>();

            DBCursor cursor = collection.find();
            while (cursor.hasNext()) {
                Oferta o = new Oferta();
                o.convertDBObjectToObject(cursor.next());
                list.add(o);
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
    public List<Oferta> listar(Oferta ofertaInicial, Oferta ofertaFinal) throws Exception {
        if (ofertaInicial != null) {
            DB conexao = null;
            try {
                conexao = ConnectionMongoDB.getConnection();
                DBCollection collection = conexao.getCollection(TABELA);

                BasicDBObject filtro = new BasicDBObject();
                if (ofertaInicial.getId() < 0) {
                    filtro.put("id", ofertaInicial.getId());
                }

                if (ofertaInicial.getDescricao() != null) {
                    filtro.put("descricao", java.util.regex.Pattern.compile(ofertaInicial.getDescricao()));
                }

                if (ofertaInicial.getCaminhoImagem() != null) {
                    filtro.put("caminhoImagem", java.util.regex.Pattern.compile(ofertaInicial.getCaminhoImagem()));
                }
                
                if (ofertaInicial.getValorOferta() != 0) {
                    filtro.put("valorOferta", (ofertaInicial.getValorOferta()));
                }

                if (ofertaInicial.getDataCriacao() != null) {
                    filtro.put("dataCriacao", (ofertaInicial.getDataCriacao()));
                }

                if (ofertaInicial.getDataTermino() != null) {
                    filtro.put("dataTermino", (ofertaInicial.getDataTermino()));
                }

                if (ofertaInicial.getStatus() != null) {
                    filtro.put("status", (ofertaInicial.getStatus().ordinal()));
                }
                
                if (ofertaInicial.getLocal() != null) {
                    filtro.put("local", java.util.regex.Pattern.compile(ofertaInicial.getLocal()));
                }
                
                if (ofertaInicial.getQtdMinimaParticipantes() != 0) {
                    filtro.put("qtdMinimaParticipantes", (ofertaInicial.getQtdMinimaParticipantes()));
                }

                DBCursor cursor = collection.find(filtro);

                List<Oferta> list = new ArrayList<Oferta>();
                while (cursor.hasNext()) {
                    Oferta o = new Oferta();
                    o.convertDBObjectToObject(cursor.next());
                    list.add(o);
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
    public boolean editar(Oferta oferta) throws Exception {
        if (oferta != null) {
            DB conexao = null;
            try {
                conexao = ConnectionMongoDB.getConnection();
                DBCollection collection = conexao.getCollection(TABELA);

                collection.update(new BasicDBObject().append("id", oferta.getId()), oferta.getBasicDBObject());

                return true;
            } catch (Exception ex) {
                throw ex;
            } finally {
                ConnectionMongoDB.closeConnection(conexao);
            }
        } else {
            throw new SQLException("Oferta inválida");
        }
    }

    @Override
    public Oferta buscar(Oferta oferta) throws Exception {
        DB conexao = null;
        try {
            conexao = ConnectionMongoDB.getConnection();
            DBCollection collection = conexao.getCollection(TABELA);

            DBCursor cursor = collection.find(new BasicDBObject("id", oferta.getId()));
            if (cursor.hasNext()) {
                Oferta o = new Oferta();
                o.convertDBObjectToObject(cursor.next());
                return o;
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
