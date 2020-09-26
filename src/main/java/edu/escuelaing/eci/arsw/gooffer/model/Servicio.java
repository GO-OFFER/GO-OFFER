package edu.escuelaing.eci.arsw.gooffer.model;

import java.util.Date;

public class Servicio {
    private int id;
    private int idVendedor;
    private String nombre;
    private String descripcion;
    private Palabra categoria;
    private Date creacion;

    public Servicio(int id, int idVendedor, String nombre, String descripcion, Palabra categoria, Date creacion) {
        this.id = id;
        this.idVendedor = idVendedor;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.creacion = creacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
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

    public Palabra getCategoria() {
        return categoria;
    }

    public void setCategoria(Palabra categoria) {
        this.categoria = categoria;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }
}
