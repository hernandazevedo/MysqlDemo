/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqldemo.mapper;

import mysqldemo.dto.LivroDto;
import mysqldemo.entity.LivroEntity;

/**
 *
 * @author 2018200724
 */
public class LivroMapper extends GenericMapper<LivroEntity,LivroDto>{

    @Override
    public  LivroEntity convertToEntity(LivroDto e) {
        LivroEntity l = new LivroEntity();
        l.setIdLivro(e.getIdLivro());
        l.setEstoque(e.getEstoque());
        l.setIdGenero(e.getIdGenero());
        l.setIdEditora(e.getIdEditora());
        l.setPreco(e.getPreco());
        l.setTitulo(e.getTitulo());
        return l;
    }

    @Override
    public LivroDto convertToDto(LivroEntity e) {
        LivroDto l = new LivroDto();
        l.setIdLivro(e.getIdLivro());
        l.setEstoque(e.getEstoque());
        l.setIdGenero(e.getIdGenero());
        l.setIdEditora(e.getIdEditora());
        l.setPreco(e.getPreco());
        l.setTitulo(e.getTitulo());
        return l;
    }
    
}
