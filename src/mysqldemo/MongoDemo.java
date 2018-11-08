/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqldemo;

/**
 * http://www.mkyong.com/mongodb/java-mongodb-hello-world-example/
 * http://downloads.mongodb.org/win32/mongodb-win32-i386-2.2.3.zip
 * http://central.maven.org/maven2/org/mongodb/mongo-java-driver/2.10.1/mongo-java-driver-2.10.1.jar
 * mongod --port 27017 --dbpath "C:\MongoDB\data\db"
 * @author 2018200724
 */
import java.util.List;
import mysqldemo.controller.CadastroController;
import mysqldemo.dto.AgendaDto;

public class MongoDemo {
  public static void main(String[] args) {

    try {
            CadastroController controller = new CadastroController(CadastroController.DBEnum.MONGO);
            AgendaDto agenda = new AgendaDto();
            agenda.setNome("Hernand Azevedo");
            agenda.setTelefone("5521973448438");
            agenda.setEmail("hernand.azevedo@gmail.com");
            agenda.setEndereco("R. de Seila numero 10, casa 2");
            
            if ( controller.insert(agenda) ) {
                 System.out.println("Agenda inserido com sucesso: "+agenda);
            } else {
                 System.out.println("Erro ao inserir Agenda: "+agenda);
            }
            
            agenda.setIdAgenda(1L);
            if ( controller.update(agenda) ) {
                 System.out.println("Agenda atualizado com sucesso: "+agenda);
            } else {
                 System.out.println("Erro ao atualizado Agenda: "+agenda);
            }
            
            List<AgendaDto> savedList = controller.listAll();
            
            for(AgendaDto l : savedList) {
                agenda = l;
                System.out.println("Agenda que esta no banco: "+l.getNome());
            }
            
            if ( controller.delete(agenda) ) {
                 System.out.println("Agenda deletado com sucesso: "+agenda);
            } else {
                 System.out.println("Erro ao deletar livro: "+agenda);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
  }
}