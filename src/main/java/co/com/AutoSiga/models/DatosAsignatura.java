package co.com.AutoSiga.models;

public class DatosAsignatura {

    private String nombre;

    public String getNombre(){return nombre;}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public DatosAsignatura(String nombre){
        this.nombre= nombre;
    }

    public DatosAsignatura(){}
}
