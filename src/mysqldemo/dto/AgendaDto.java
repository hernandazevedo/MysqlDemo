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
public class AgendaDto implements Serializable{
    private Long idAgenda;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;

    public Long getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Long idAgenda) {
        this.idAgenda = idAgenda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    

    @Override
    public String toString() {
        return "AgendaDto{" + "idAgenda=" + idAgenda + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco + '}';
    }

}
