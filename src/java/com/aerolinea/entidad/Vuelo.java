package com.aerolinea.entidad;
// Generated Sep 3, 2017 11:36:18 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Vuelo generated by hbm2java
 */
@Entity
@Table(name="vuelo"
    ,catalog="aerolinea"
)
public class Vuelo  implements java.io.Serializable {


     private Integer idvuelo;
     private Aeropuerto aeropuertoByIdorigen;
     private Aeropuerto aeropuertoByIddestino;
     private Avion avion;
     private Date fecha;
     private String estado;
     private BigDecimal precio;
     private Set<Reservacion> reservacions = new HashSet<Reservacion>(0);

    public Vuelo() {
    }

	
    public Vuelo(Aeropuerto aeropuertoByIdorigen, Aeropuerto aeropuertoByIddestino, Avion avion, Date fecha) {
        this.aeropuertoByIdorigen = aeropuertoByIdorigen;
        this.aeropuertoByIddestino = aeropuertoByIddestino;
        this.avion = avion;
        this.fecha = fecha;
    }
    public Vuelo(Aeropuerto aeropuertoByIdorigen, Aeropuerto aeropuertoByIddestino, Avion avion, Date fecha, String estado, BigDecimal precio, Set<Reservacion> reservacions) {
       this.aeropuertoByIdorigen = aeropuertoByIdorigen;
       this.aeropuertoByIddestino = aeropuertoByIddestino;
       this.avion = avion;
       this.fecha = fecha;
       this.estado = estado;
       this.precio = precio;
       this.reservacions = reservacions;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idvuelo", unique=true, nullable=false)
    public Integer getIdvuelo() {
        return this.idvuelo;
    }
    
    public void setIdvuelo(Integer idvuelo) {
        this.idvuelo = idvuelo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idorigen", nullable=false)
    public Aeropuerto getAeropuertoByIdorigen() {
        return this.aeropuertoByIdorigen;
    }
    
    public void setAeropuertoByIdorigen(Aeropuerto aeropuertoByIdorigen) {
        this.aeropuertoByIdorigen = aeropuertoByIdorigen;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="iddestino", nullable=false)
    public Aeropuerto getAeropuertoByIddestino() {
        return this.aeropuertoByIddestino;
    }
    
    public void setAeropuertoByIddestino(Aeropuerto aeropuertoByIddestino) {
        this.aeropuertoByIddestino = aeropuertoByIddestino;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idavion", nullable=false)
    public Avion getAvion() {
        return this.avion;
    }
    
    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha", nullable=false, length=19)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="estado", length=13)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    @Column(name="precio", precision=10)
    public BigDecimal getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="vuelo")
    public Set<Reservacion> getReservacions() {
        return this.reservacions;
    }
    
    public void setReservacions(Set<Reservacion> reservacions) {
        this.reservacions = reservacions;
    }




}


