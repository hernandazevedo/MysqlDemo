/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqldemo.controller;

import mysqldemo.exception.DatabaseException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mysqldemo.dao.GenericDao;
import mysqldemo.dao.AgendaDaoImpl;
import mysqldemo.dto.AgendaDto;
import mysqldemo.entity.AgendaEntity;
import mysqldemo.mapper.AgendaMapper;

/**
 *
 * @author 2018200724
 */
public class CadastroController {

    private final GenericDao<AgendaEntity> livroDao;

    public CadastroController() {
        //FIXME inject the daos
        livroDao = new AgendaDaoImpl();
    }
    
    public Boolean insert(AgendaDto livro) {
        try {
            return livroDao.insert(new AgendaMapper().convertToEntity(livro)) > 0;
        } catch (DatabaseException e) {
            Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public Boolean update(AgendaDto livro) {
        try {
            return livroDao.update(new AgendaMapper().convertToEntity(livro)) > 0;
        } catch (DatabaseException e) {
            Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public Boolean delete(AgendaDto livro) {
        try {
            return livroDao.delete(new AgendaMapper().convertToEntity(livro)) > 0;
        } catch (DatabaseException e) {
            Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public List<AgendaDto> listAll() {       
        try {
            List<AgendaEntity> entityList = livroDao.list();   
            
            if(entityList != null && !entityList.isEmpty())
                return new AgendaMapper().convertToDtoList(entityList);
        } catch (DatabaseException e) {
            Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, e);
        }
        return Collections.emptyList();
    }
}
