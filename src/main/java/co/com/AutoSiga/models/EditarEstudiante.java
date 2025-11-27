package co.com.AutoSiga.models;

public class EditarEstudiante {

    private String correo;
    private String contraseña;
    private String rol;


    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getRol() {
        return rol;
    }

    // Setters
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


    public EditarEstudiante(String correo, String contraseña, String rol) {
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public EditarEstudiante() {}
}
