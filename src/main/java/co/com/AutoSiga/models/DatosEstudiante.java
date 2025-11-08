package co.com.AutoSiga.models;

public class DatosEstudiante {
    private int acudiente;

    private int curso;

    private String nombre;
    private String apellido;

    public DatosEstudiante(int acudiente, int curso, String nombre, String apellido) {
        this.acudiente = acudiente;
        this.curso = curso;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(int acudiente) {
        this.acudiente = acudiente;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}

