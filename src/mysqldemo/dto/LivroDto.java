/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqldemo.dto;
import java.io.Serializable;

/**
 *
 * @author 2018200724
 */
public class LivroDto implements Serializable{
    private Long idLivro;
    private String titulo;
    private Double preco;
    private Long estoque;
    private Long idGenero;
    private Long idEditora;

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getEstoque() {
        return estoque;
    }

    public void setEstoque(Long estoque) {
        this.estoque = estoque;
    }

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public Long getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(Long idEditora) {
        this.idEditora = idEditora;
    }
    
    //TODO Format this method according to its the purpose.
    @Override
    public String toString() {
        return "LivroDto{" + "idLivro=" + idLivro + ", titulo=" + titulo + ", preco=" + preco + ", estoque=" + estoque + ", idGenero=" + idGenero + ", idEditora=" + idEditora + '}';
    }
}
