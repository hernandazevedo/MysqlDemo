/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqldemo.controller;

import mysqldemo.exception.DatabaseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mysqldemo.dao.GenericDao;
import mysqldemo.dao.LivroDaoImpl;
import mysqldemo.dto.LivroDto;
import mysqldemo.entity.LivroEntity;
import mysqldemo.mapper.LivroMapper;

/**
 *
 * @author 2018200724
 */
public class CadastroController {

    private final GenericDao<LivroEntity> livroDao;

    public CadastroController() {
        //FIXME inject the daos
        livroDao = new LivroDaoImpl();
    }
    
    public Boolean insertBook(LivroDto livro) {
        try {
            return livroDao.insert(new LivroMapper().convertToEntity(livro)) > 0;
        } catch (DatabaseException e) {
            Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public Boolean updateBook(LivroDto livro) {
        try {
            return livroDao.update(new LivroMapper().convertToEntity(livro)) > 0;
        } catch (DatabaseException e) {
            Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public Boolean deleteBook(LivroDto livro) {
        try {
            return livroDao.delete(new LivroMapper().convertToEntity(livro)) > 0;
        } catch (DatabaseException e) {
            Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public List<LivroDto> listBooks() {       
        try {
            List<LivroEntity> entityList = livroDao.list();   
            
            if(entityList != null && !entityList.isEmpty())
                return new LivroMapper().convertToDtoList(entityList);
        } catch (DatabaseException e) {
            Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, e);
        }
        return Collections.emptyList();
    }
}
