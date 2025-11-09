package co.com.AutoSiga.models;

public class DatosEstudiante {

    private String nombre;
    private String apellido;
    private String curso;
    private String acudiente;

    public DatosEstudiante(String nombre, String apellido, String curso, String acudiente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.acudiente = acudiente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCurso() {
        return curso;
    }

    public String getAcudiente() {
        return acudiente;
    }


    }

