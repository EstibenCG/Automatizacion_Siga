package co.com.AutoSiga.models;

public class DatosDocente {
    private String nombre;
    private String apellido;

    public String getnombre() {
        return nombre;
    }

    public String getapellido() {
        return apellido;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public void setapellido(String apellido) {
        this.apellido = apellido;
    }

    public DatosDocente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public DatosDocente() {

    }
}
