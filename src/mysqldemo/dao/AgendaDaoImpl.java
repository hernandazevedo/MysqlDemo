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
import mysqldemo.entity.AgendaEntity;

/**
 *
 * @author 2018200724
 */
public class AgendaDaoImpl extends AbstractDao implements GenericDao<AgendaEntity> {
    public static final String INSERT_QUERY = "INSERT INTO agenda ( nome, telefone, email, endereco) values (?,?,?,?)";
    public static final String UPDATE_QUERY = "UPDATE agenda set nome = ?, telefone = ?, email = ?, endereco = ? where idagenda = ?";
    public static final String DELETE_QUERY = "DELETE from agenda where idagenda = ?";
    public static final String SELECT_QUERY = "SELECT * FROM agenda";
    
    @Override
    public int insert(AgendaEntity agenda) throws DatabaseException {
        Connection conn = null;       
        try{
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_QUERY);            
           
            ps.setString(1, agenda.getNome());
            ps.setString(2, agenda.getTelefone());
            ps.setString(3, agenda.getEmail());
            ps.setString(4, agenda.getEndereco());
            
            return ps.executeUpdate();
        } catch(Exception e) {
            Logger.getLogger(AgendaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            throw new DatabaseException(e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }

    @Override
    public int delete(AgendaEntity agenda) throws DatabaseException {
        Connection conn = null;       
        try{
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(DELETE_QUERY);                       
            ps.setLong(1, agenda.getIdAgenda());
            return ps.executeUpdate();
        } catch(Exception e) {
            Logger.getLogger(AgendaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            throw new DatabaseException(e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }

    @Override
    public List<AgendaEntity> list() throws DatabaseException {
        Connection conn = null; 
        List<AgendaEntity> livroEntityList = new ArrayList<>();
        try{
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_QUERY);                       
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                AgendaEntity agenda = new AgendaEntity();
                agenda.setIdAgenda(rs.getLong("idagenda"));
                agenda.setNome(rs.getString("nome"));
                agenda.setNome(rs.getString("telefone"));
                agenda.setNome(rs.getString("email"));
                agenda.setNome(rs.getString("endereco"));
                
                livroEntityList.add(agenda);
            }
            return livroEntityList;
        } catch(Exception e) {
            Logger.getLogger(AgendaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            throw new DatabaseException(e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }

    @Override
    public int update(AgendaEntity agenda) throws DatabaseException {
        Connection conn = null;       
        try{
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_QUERY);            
           
            ps.setString(1, agenda.getNome());
            ps.setString(2, agenda.getTelefone());
            ps.setString(3, agenda.getEmail());
            ps.setString(4, agenda.getEndereco());
            ps.setLong(5, agenda.getIdAgenda());
            return ps.executeUpdate();
        } catch(Exception e) {
            Logger.getLogger(AgendaDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            throw new DatabaseException(e.getMessage());
        } finally {
            closeConnection(conn);
        }
    }
    
}
