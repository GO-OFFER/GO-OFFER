package edu.escuelaing.eci.arsw.gooffer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;

import java.util.ArrayList;
import java.util.Date;


@Entity
@Table(name="favoritos")
public class Favorito {

	@Id
	@Column(name = "idservicio")
    private int idservicio;
	
	@Column(name = "idusuario")
    private int idusuario;
	
    
    
/*
    public Compra(int id, int idServicio, int idComprador, int calificacion, Date fecha ) {
        this.id = id;
        this.idservicio = idServicio;
        this.idusuario = idComprador;
        this.calificacion = calificacion;
        this.creationdate = fecha;
    }
    */
	
    public Favorito(int idSer, int idUse) {
    	this.idservicio=idSer;
    	this.idusuario=idUse;
    }
    
    public Favorito () {
    	
    }

   

    public int getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(int idServicio) {
        this.idservicio = idServicio;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idComprador) {
        this.idusuario = idComprador;
    }



}
