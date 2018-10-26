/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqldemo;

import mysqldemo.controller.CadastroController;
import mysqldemo.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import mysqldemo.dto.LivroDto;

/**
 *
 * @author 2018200724
 */
public class MysqlDemo {
    
    public static final String TEACHER_NAME_TO_FIND = "Her";
    public static final String TEACHER_NAME_TO_INSERT = "Hernand";
    public static final String TEACHER_NAME_NEW_VALUE = "Jose";
    public static final String TEACHER_TITLE_TO_INSERT = "Mr";
    public static final String SQL_QUERY = "select * from professor where nome like ?";
    public static final String SQL_QUERY_FIND_ALL = "select * from professor";
    
    public static final String INSERT_QUERY = "insert into professor (nome, titulacao) values (?,?)";
    public static final String UPDATE_QUERY = "update professor set nome = ? where nome = ?";
    public static final String DELETE_QUERY = "delete from professor where nome = ?";
    
    public static void main(String[] args) {
        
        try {
            CadastroController controller = new CadastroController();
            LivroDto livro = new LivroDto();
            livro.setEstoque(1L);
            livro.setIdEditora(1L);
            livro.setIdGenero(1L);
            livro.setTitulo("Titulo do jose");
            livro.setPreco(20.0);
            if ( controller.insertBook(livro) ) {
                 System.out.println("Livro inserido com sucesso: "+livro.getTitulo());
            } else {
                 System.out.println("Erro ao inserir livro: "+livro.getTitulo());
            }
            
            livro.setIdLivro(1L);
            if ( controller.updateBook(livro) ) {
                 System.out.println("Livro atualizado com sucesso: "+livro.getTitulo());
            } else {
                 System.out.println("Erro ao atualizado livro: "+livro.getTitulo());
            }
            
            List<LivroDto> savedList = controller.listBooks();
            
            for(LivroDto l : savedList) {
                livro = l;
                System.out.println("Livro que esta no banco: "+l.getTitulo());
            }
            
            if ( controller.deleteBook(livro) ) {
                 System.out.println("Livro deletado com sucesso: "+livro.getTitulo());
            } else {
                 System.out.println("Erro ao deletar livro: "+livro.getTitulo());
            }
            
//            testInsertWithPreparedStatement(TEACHER_NAME_TO_INSERT, TEACHER_TITLE_TO_INSERT);          
//            //Selects the the teacher with the name passed as paramenter
//            testSelectWithPreparedStatement(TEACHER_NAME_TO_FIND);
//            
//            //Updates the name from oldName to newName
//            testUpdateWithPreparedStatement(TEACHER_NAME_TO_INSERT, TEACHER_NAME_NEW_VALUE);
//            
//            //Find All 
//            testSelectWithPreparedStatement(null);
//            
//            //Deletes with the name 
//            testDeleteWithPreparedStatement(TEACHER_NAME_NEW_VALUE);
//            
//            //Find All 
//            testSelectWithPreparedStatement(null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static void testSelectWithPreparedStatement(String nameToFind) throws SQLException {
        Connection conn = null;
        try{
            conn = ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps;
            if(nameToFind != null) {
                System.out.println("Buscando por nome: "+nameToFind);
                ps = conn.prepareStatement(SQL_QUERY);            
                ps.setString(1, nameToFind + "%");            
            } else {
                System.out.println("Buscando por todos os registros");
                ps = conn.prepareStatement(SQL_QUERY_FIND_ALL);
            }
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {    
                System.out.println("nome: "+rs.getString("nome"));
                System.out.println("nome: "+rs.getString("titulacao"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) conn.close();
        }
    }
    
     private static void testInsertWithPreparedStatement(String nameToInsert, String titleToInsert) throws SQLException {
        Connection conn = null;
        try{
            conn = ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_QUERY);            
            ps.setString(1, nameToInsert); 
            ps.setString(2, titleToInsert); 
            
            int affectedLines = ps.executeUpdate();
            if(affectedLines > 0) {
                System.out.println(nameToInsert + " Inserido com sucesso");
            } else {
                System.out.println("Erro ao inserir "+ nameToInsert);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) conn.close();
        }
    }
     
     private static void testUpdateWithPreparedStatement(String oldName,String newName) throws SQLException {
        Connection conn = null;
        try{
            conn = ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_QUERY);            
            ps.setString(1, newName); 
            ps.setString(2, oldName); 
            
            int affectedLines = ps.executeUpdate();
            if(affectedLines > 0) {
                System.out.println(oldName+ " Atualizado com sucesso para " + newName);
            } else {
                System.out.println("Erro ao Atualizar " + oldName);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) conn.close();
        }
    }
     
     private static void testDeleteWithPreparedStatement(String nameToDelete) throws SQLException {
        Connection conn = null;
        try{
            conn = ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(DELETE_QUERY);            
            ps.setString(1, nameToDelete); 
            
            int affectedLines = ps.executeUpdate();
            if(affectedLines > 0) {
                System.out.println(nameToDelete + " Deletado com sucesso");
            } else {
                System.out.println("Erro ao Deletar "+ nameToDelete);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) conn.close();
        }
    }
}
