/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqldemo;

import mysqldemo.controller.CadastroController;
import java.util.List;
import mysqldemo.dto.AgendaDto;

/**
 *
 * @author 2018200724
 */
public class MysqlDemo {
    public static void main(String[] args) {
        
        try {
            CadastroController controller = new CadastroController(CadastroController.DBEnum.MYSQL);
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
                 System.out.println("Erro ao deletar Agenda: "+agenda);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
