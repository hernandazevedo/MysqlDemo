/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqldemo.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2018200724
 */
abstract class GenericMapper<E, D> {
    protected abstract E convertToEntity(D e);
    protected abstract D convertToDto(E e);
    
    public List<D> convertToDtoList(List<E> list) {
        List<D> dtoList = new ArrayList<>();
        
        if( list != null && !list.isEmpty()) {
            list.forEach((o) -> {
                dtoList.add(convertToDto(o));
            });
        }
        return dtoList;
    }
    
    public List<E> convertToEntityList(List<D> list) {
        List<E> entityList = new ArrayList<>();
        
        if( list != null && !list.isEmpty()) {
            list.forEach((o) -> {
                entityList.add(convertToEntity(o));
            });
        }
        return entityList;
    }
}
