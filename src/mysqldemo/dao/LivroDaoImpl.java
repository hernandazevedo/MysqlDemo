/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqldemo.dao;

import mysqldemo.exception.DatabaseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mysqldemo.entity.LivroEntity;

/**
 *
 * @author 2018200724
 */
public class LivroDaoImpl extends AbstractDao implements GenericDao<LivroEntity> {
    public static final String INSERT_QUERY = "INSERT INTO livro ( titulo, preco, estoque, idgenero, ideditora) values (?,?,?,?,?)";
    public static final String UPDATE_QUERY = "UPDATE livro set titulo = ?, preco = ?, estoque = ?, idgenero = ? , ideditora = ? where idlivro = ?";
    public static final String DELETE_QUERY = "DELETE from livro where idlivro = ?";
    public static final String SELECT_QUERY = "SELECT * FROM livro";
    
    @Override
    public int insert(LivroEntity livro) throws DatabaseException {
        Connection conn = null;       
        try{
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_QUERY);            
           
            ps.setString(1, livro.getTitulo());
            ps.setDouble(2, livro.getPreco());
            ps.setLong(3, livro.getEstoque());
            ps.setLong(4, livro.getIdGenero());
            ps.setLong(5, livro.getIdEditora());           
            return ps.executeUpdate();
        } catch(Exception e) {
            Logger.getLogger(LivroDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            throw new DatabaseException(e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }

    @Override
    public int delete(LivroEntity livro) throws DatabaseException {
        Connection conn = null;       
        try{
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(DELETE_QUERY);                       
            ps.setLong(1, livro.getIdLivro());
            return ps.executeUpdate();
        } catch(Exception e) {
            Logger.getLogger(LivroDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            throw new DatabaseException(e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }

    @Override
    public List<LivroEntity> list() throws DatabaseException {
        Connection conn = null; 
        List<LivroEntity> livroEntityList = new ArrayList<>();
        try{
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_QUERY);                       
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                LivroEntity livro = new LivroEntity();
                livro.setIdLivro(rs.getLong("idlivro"));
                livro.setEstoque(rs.getLong("estoque"));
                livro.setIdEditora(rs.getLong("ideditora"));
                livro.setIdGenero(rs.getLong("idgenero"));
                livro.setPreco(rs.getDouble("preco"));
                livro.setTitulo(rs.getString("titulo"));
                
                livroEntityList.add(livro);
            }
            return livroEntityList;
        } catch(Exception e) {
            Logger.getLogger(LivroDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            throw new DatabaseException(e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }

    @Override
    public int update(LivroEntity livro) throws DatabaseException {
        Connection conn = null;       
        try{
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_QUERY);            
           
            ps.setString(1, livro.getTitulo());
            ps.setDouble(2, livro.getPreco());
            ps.setLong(3, livro.getEstoque());
            ps.setLong(4, livro.getIdGenero());
            ps.setLong(5, livro.getIdEditora());
            ps.setLong(6, livro.getIdLivro());
            return ps.executeUpdate();
        } catch(Exception e) {
            Logger.getLogger(LivroDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            throw new DatabaseException(e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }
    
}
