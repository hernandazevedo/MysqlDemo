/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqldemo.mapper;

import mysqldemo.dto.AgendaDto;
import mysqldemo.entity.AgendaEntity;

/**
 *
 * @author 2018200724
 */
public class AgendaMapper extends GenericMapper<AgendaEntity,AgendaDto>{

    @Override
    public  AgendaEntity convertToEntity(AgendaDto e) {
        AgendaEntity l = new AgendaEntity();
        l.setIdAgenda(e.getIdAgenda());
        l.setNome(e.getNome());
        l.setTelefone(e.getTelefone());
        l.setEmail(e.getEmail());
        l.setEndereco(e.getEndereco());
        return l;
    }

    @Override
    public AgendaDto convertToDto(AgendaEntity e) {
        AgendaDto l = new AgendaDto();
        l.setIdAgenda(e.getIdAgenda());
        l.setNome(e.getNome());
        l.setTelefone(e.getTelefone());
        l.setEmail(e.getEmail());
        l.setEndereco(e.getEndereco());
        return l;
    }
    
}
