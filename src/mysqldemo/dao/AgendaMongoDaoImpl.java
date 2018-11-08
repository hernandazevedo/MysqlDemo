/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqldemo.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import mysqldemo.exception.DatabaseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mysqldemo.entity.AgendaEntity;

/**
 *
 * @author 2018200724
 */
public class AgendaMongoDaoImpl extends AbstractDao implements GenericDao<AgendaEntity> {
    public static final String COLLECTION_NAME = "agenda";
    public static final String SEQ_NAME = "agenda_seq";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "nome";
    public static final String PHONE_COLUMN = "telefone";
    public static final String EMAIL_COLUMN = "email";
    public static final String ADDRESS_COLUMN = "endereco";
    
    @Override
    public int insert(AgendaEntity agenda) throws DatabaseException {
        DB db = null;       
        try{
            db = getMongoConnection();
            /**** Get collection / table from 'testdb' ****/
            // if collection doesn't exists, MongoDB will create it for you
            DBCollection table = db.getCollection(COLLECTION_NAME);

            /**** Insert ****/
            // create a document to store key and value
            BasicDBObject document = new BasicDBObject();
            document.put(ID_COLUMN, getNextMongoSequence(SEQ_NAME));
            document.put(NAME_COLUMN, agenda.getNome());
            document.put(PHONE_COLUMN, agenda.getTelefone());
            document.put(EMAIL_COLUMN, agenda.getEmail());
            document.put(ADDRESS_COLUMN, agenda.getEndereco());
            table.insert(document);
            return 1;
        } catch(Exception e) {
            Logger.getLogger(AgendaMongoDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public int delete(AgendaEntity agenda) throws DatabaseException {
        DB db = null;       
        try{
            db = getMongoConnection();
            /**** Get collection / table from 'testdb' ****/
            // if collection doesn't exists, MongoDB will create it for you
            DBCollection table = db.getCollection(COLLECTION_NAME);

            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put(ID_COLUMN, agenda.getIdAgenda());

            table.remove(searchQuery);
            return 1;
        } catch(Exception e) {
            Logger.getLogger(AgendaMongoDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public List<AgendaEntity> list() throws DatabaseException {
        DB db = null;       
        List<AgendaEntity> livroEntityList = new ArrayList<>();
        try{
            db = getMongoConnection();
            /**** Get collection / table from 'testdb' ****/
            // if collection doesn't exists, MongoDB will create it for you
            DBCollection table = db.getCollection(COLLECTION_NAME);                 
            
            DBCursor cursor = table.find();

            while (cursor.hasNext()) {
                    System.out.println(cursor.next());
            }
                while(cursor.hasNext()) {
                    DBObject obj = cursor.next();
                    AgendaEntity agenda = new AgendaEntity();
                    agenda.setIdAgenda(Long.valueOf(obj.get(ID_COLUMN).toString()));
                    agenda.setNome(String.valueOf(obj.get(NAME_COLUMN).toString()));
                    agenda.setTelefone(String.valueOf(obj.get(PHONE_COLUMN).toString()));
                    agenda.setEndereco(String.valueOf(obj.get(ADDRESS_COLUMN).toString()));
                    agenda.setEmail(String.valueOf(obj.get(EMAIL_COLUMN).toString()));

                    livroEntityList.add(agenda);
                }
                return livroEntityList;
        } catch(Exception e) {
            Logger.getLogger(AgendaMongoDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public int update(AgendaEntity agenda) throws DatabaseException {
       DB db = null;       
        try{
            db = getMongoConnection();
            /**** Get collection / table from 'testdb' ****/
            // if collection doesn't exists, MongoDB will create it for you
            DBCollection table = db.getCollection(COLLECTION_NAME);        
           
            BasicDBObject query = new BasicDBObject();
            query.put(ID_COLUMN, agenda.getIdAgenda());

            BasicDBObject newDocument = new BasicDBObject();
            newDocument.put(ID_COLUMN, agenda.getIdAgenda());
            newDocument.put(NAME_COLUMN, agenda.getNome());
            newDocument.put(PHONE_COLUMN, agenda.getTelefone());
            newDocument.put(EMAIL_COLUMN, agenda.getEmail());
            newDocument.put(ADDRESS_COLUMN, agenda.getEndereco());

            BasicDBObject updateObj = new BasicDBObject();
            updateObj.put("$set", newDocument);

            table.update(query, updateObj);
            return 1;
        } catch(Exception e) {
            Logger.getLogger(AgendaMongoDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            throw new DatabaseException(e.getMessage());
        }
    }
    
}
