package co.com.AutoSiga.models;

public class DatosAcudiente {

    private String nombre;

    private String apellido;
    private String correo;



    public String getnNmbre(){return nombre;}
    public String getApellido(){return apellido;}
    public String getCorreo(){return correo;}


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public void datosAcudiente(String nombre, String apellido, String correo){
        this.nombre= nombre;
        this.apellido = apellido;
        this.correo = correo;
    }
}
