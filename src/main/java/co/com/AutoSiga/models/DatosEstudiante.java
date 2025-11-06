package co.com.AutoSiga.models;

public class DatosEstudiante {
    private String Acudiente;

    private String Curso;

    private String Nombre;
    private String Apellido;

    public String getAcudiente() {
        return Acudiente;
    }

    public String getCurso() {
        return Curso;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setAcudiente(String Acudiente) {
        this.Acudiente = Acudiente;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public DatosEstudiante(String Acudiente, String Curso, String Nombre, String Apellido) {

    }

    public DatosEstudiante() {
    }
}

