
package Modelo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//prihibido mayusculas
@Entity
public class Proyectos implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    private int numlejago;
    private String nombre;
    private float monto;
    @Temporal(TemporalType.DATE)
    private Date fechapreoyecto;
    @OneToMany(mappedBy="proyecto")
    private List<Empleado>listaempleado;

    public void setId(int id) {
        this.id = id;
    }

    public void setNumlejago(int numlejago) {
        this.numlejago = numlejago;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public void setFechapreoyecto(Date fechapreoyecto) {
        this.fechapreoyecto = fechapreoyecto;
    }

    public void setListaempleado(List<Empleado> listaempleado) {
        this.listaempleado = listaempleado;
    }

    public int getId() {
        return id;
    }

    public int getNumlejago() {
        return numlejago;
    }

    public String getNombre() {
        return nombre;
    }

    public float getMonto() {
        return monto;
    }

    public Date getFechapreoyecto() {
        return fechapreoyecto;
    }

    public List<Empleado> getListaempleado() {
        return listaempleado;
    }

    public Proyectos() {
    }

    public Proyectos(int id, int numlejago, String nombre, float monto, Date fechapreoyecto, List<Empleado> listaempleado) {
        this.id = id;
        this.numlejago = numlejago;
        this.nombre = nombre;
        this.monto = monto;
        this.fechapreoyecto = fechapreoyecto;
        this.listaempleado = listaempleado;
    }

    

}




















