package edu.escuelaing.eci.arsw.gooffer.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="servicio")
public class Servicio {
	
	@Id
    private int id;
    private int idusuario; //vendedor
    private String descripcion;
    private Date creationdate;
    private String nombre;

    public Servicio(int id, int idVendedor, String nombre, String descripcion, Palabra categoria, Date creacion) {
        this.id = id;
        this.idusuario = idVendedor;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creationdate = creacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVendedor() {
        return idusuario;
    }

    public void setIdVendedor(int idVendedor) {
        this.idusuario = idVendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Date getCreacion() {
        return creationdate;
    }

    public void setCreacion(Date creacion) {
        this.creationdate = creacion;
    }
}
