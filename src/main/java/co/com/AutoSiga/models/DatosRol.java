package co.com.AutoSiga.models;

public class DatosRol {

    private String nombreDelRol;

    public String getNombreDelRol() { return nombreDelRol; }

    public void setNombreDelRol(String nombreDelRol) {
        this.nombreDelRol = nombreDelRol;
    }

    public DatosRol(String nombreDelRol) {
        this.nombreDelRol = nombreDelRol;
    }

    public DatosRol() {}
}