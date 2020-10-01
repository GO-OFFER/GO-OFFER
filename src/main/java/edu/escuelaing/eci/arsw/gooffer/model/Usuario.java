package edu.escuelaing.eci.arsw.gooffer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "tipo")
    private int tipo;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "numcompras")
    private int numcompras;
    
    public Usuario(){

    }
    /*public Usuario(Integer id, String nombre, String email, int tipo, String password,int numCompras) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.tipo = tipo;
        this.password = password;
        this.numcompras = numCompras;
    }
    */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pasword) {
        this.password = pasword;
    }

    public int getNumCompras() {
        return numcompras;
    }

    public void setNumCompras(int numCompras) {
        this.numcompras = numCompras;
    }
}
