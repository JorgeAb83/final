package Modelo;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Empleado implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    private String nombre;
    private String apellido;
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    private int dni;
    private float sueldo;
    @ManyToOne
    Proyectos proyecto;

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public void setProyecto(Proyectos proyecto) {
        this.proyecto = proyecto;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public int getDni() {
        return dni;
    }

    public float getSueldo() {
        return sueldo;
    }

    public Proyectos getProyecto() {
        return proyecto;
    }

    public Empleado() {
    }

    public Empleado(int id, String nombre, String apellido, Date fechanacimiento, int dni, float sueldo, Proyectos proyecto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechanacimiento = fechanacimiento;
        this.dni = dni;
        this.sueldo = sueldo;
        this.proyecto = proyecto;
    }

    
    
}
