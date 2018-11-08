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
import mysqldemo.dao.AgendaMongoDaoImpl;
import mysqldemo.dto.AgendaDto;
import mysqldemo.entity.AgendaEntity;
import mysqldemo.mapper.AgendaMapper;

/**
 *
 * @author 2018200724
 */
public class CadastroController {

    private final GenericDao<AgendaEntity> agendaDao;

    public enum DBEnum {
        MONGO,
        MYSQL
    }
    
    public CadastroController(DBEnum dbEnum) {
        //FIXME inject the daos
        agendaDao = dbEnum == DBEnum.MYSQL ? new AgendaDaoImpl() : new AgendaMongoDaoImpl();
    }
    
    public Boolean insert(AgendaDto livro) {
        try {
            return agendaDao.insert(new AgendaMapper().convertToEntity(livro)) > 0;
        } catch (DatabaseException e) {
            Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public Boolean update(AgendaDto livro) {
        try {
            return agendaDao.update(new AgendaMapper().convertToEntity(livro)) > 0;
        } catch (DatabaseException e) {
            Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public Boolean delete(AgendaDto livro) {
        try {
            return agendaDao.delete(new AgendaMapper().convertToEntity(livro)) > 0;
        } catch (DatabaseException e) {
            Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public List<AgendaDto> listAll() {       
        try {
            List<AgendaEntity> entityList = agendaDao.list();   
            
            if(entityList != null && !entityList.isEmpty())
                return new AgendaMapper().convertToDtoList(entityList);
        } catch (DatabaseException e) {
            Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, e);
        }
        return Collections.emptyList();
    }
}
