package edu.escuelaing.eci.arsw.gooffer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;

import java.util.ArrayList;
import java.util.Date;


@Entity
@Table(name="compra")
public class Compra {
	
	@Id
    private int id;
	@Column(name = "idServicio")
    private int idservicio;
	@Column(name = "idusuario")
    private int idusuario;
	@Column(name = "calificacion")
    private int calificacion;
	@Column(name = "creationdate")
    private Date creationdate;
    
    
/*
    public Compra(int id, int idServicio, int idComprador, int calificacion, Date fecha ) {
        this.id = id;
        this.idservicio = idServicio;
        this.idusuario = idComprador;
        this.calificacion = calificacion;
        this.creationdate = fecha;
    }
    */
	
    public Compra() {
    	
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdServicio() {
        return idservicio;
    }

    public void setIdServicio(int idServicio) {
        this.idservicio = idServicio;
    }

    public int getIdComprador() {
        return idusuario;
    }

    public void setIdComprador(int idComprador) {
        this.idusuario = idComprador;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFecha() {
        return creationdate;
    }

    public void setFecha(Date fecha) {
        this.creationdate = fecha;
    }


}
