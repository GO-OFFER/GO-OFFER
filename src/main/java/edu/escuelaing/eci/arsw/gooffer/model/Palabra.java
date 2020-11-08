package edu.escuelaing.eci.arsw.gooffer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="palabra")
public class Palabra {
	/* falta Palabra por conexion */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	@Column(name = "idservicio")
    private int idservicio;
	@Column(name = "palabra")
    private String palabra;

    public Palabra(int id,int idservicio, String palabra) {
        this.id = id;
        this.idservicio = idservicio;
        this.palabra = palabra;
    }
    public Palabra() {
    	
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }

    public String getPalabraa() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
}