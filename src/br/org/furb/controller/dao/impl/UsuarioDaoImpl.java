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
import br.org.furb.model.Usuario;

public class UsuarioDaoImpl implements DAO<Usuario> {

    private static final String TABELA = "usuario";

    @Override
    public boolean salvar(Usuario usuario) throws Exception {
        DB conexao = null;
        try {
            conexao = ConnectionMongoDB.getConnection();
            DBCollection collection = conexao.getCollection(TABELA);
            usuario.setId(incrementar());
            collection.insert(usuario.getBasicDBObject());

            return true;
        } catch (Exception ex) {
            throw ex;
        } finally {
            ConnectionMongoDB.closeConnection(conexao);
        }
    }

    @Override
    public boolean excluir(Usuario usuario) throws Exception {
        DB conexao = null;
        try {
            conexao = ConnectionMongoDB.getConnection();
            DBCollection collection = conexao.getCollection(TABELA);

            collection.remove(new BasicDBObject("id", usuario.getId()));

            return true;
        } catch (Exception ex) {
            throw ex;
        } finally {
            ConnectionMongoDB.closeConnection(conexao);
        }
    }

    @Override
    public List<Usuario> listar() throws Exception {
        DB conexao = null;
        try {
            conexao = ConnectionMongoDB.getConnection();
            DBCollection collection = conexao.getCollection(TABELA);

            List<Usuario> list = new ArrayList<Usuario>();

            DBCursor cursor = collection.find();
            while (cursor.hasNext()) {
                Usuario u = new Usuario();
                u.convertDBObjectToObject(cursor.next());
                list.add(u);
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
    public List<Usuario> listar(Usuario usuarioInicial, Usuario usuarioFinal) throws Exception {
        if (usuarioInicial != null) {
            DB conexao = null;
            try {
                conexao = ConnectionMongoDB.getConnection();
                DBCollection collection = conexao.getCollection(TABELA);

                BasicDBObject filtro = new BasicDBObject();
                if (usuarioInicial.getId() < 0) {
                    filtro.put("id", usuarioInicial.getId());
                }

                if (usuarioInicial.getNome() != null) {
                    filtro.put("nome", java.util.regex.Pattern.compile(usuarioInicial.getNome()));
                }

                if (usuarioInicial.getEmail() != null) {
                    filtro.put("email", java.util.regex.Pattern.compile(usuarioInicial.getEmail()));
                }
                
                if (usuarioInicial.getSenha() != null) {
                    filtro.put("senha", java.util.regex.Pattern.compile(usuarioInicial.getSenha()));
                }

                if (usuarioInicial.getTelefone() != null) {
                    filtro.put("telefone", (usuarioInicial.getTelefone()));
                }

                if (usuarioInicial.getCep() != 0) {
                    filtro.put("cep", (usuarioInicial.getCep()));
                }

                DBCursor cursor = collection.find(filtro);

                List<Usuario> list = new ArrayList<Usuario>();
                while (cursor.hasNext()) {
                    Usuario u = new Usuario();
                    u.convertDBObjectToObject(cursor.next());
                    list.add(u);
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
    public boolean editar(Usuario usuario) throws Exception {
        if (usuario != null) {
            DB conexao = null;
            try {
                conexao = ConnectionMongoDB.getConnection();
                DBCollection collection = conexao.getCollection(TABELA);

                collection.update(new BasicDBObject().append("id", usuario.getId()), usuario.getBasicDBObject());

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
    public Usuario buscar(Usuario usuario) throws Exception {
        DB conexao = null;
        try {
            conexao = ConnectionMongoDB.getConnection();
            DBCollection collection = conexao.getCollection(TABELA);

            DBCursor cursor = collection.find(new BasicDBObject("id", usuario.getId()));
            if (cursor.hasNext()) {
                Usuario u = new Usuario();
                u.convertDBObjectToObject(cursor.next());
                return u;
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
