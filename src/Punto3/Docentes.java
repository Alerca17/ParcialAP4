package Punto3;

public class Docentes {

    private String cedula, tipo, fecha;

    public Docentes() {
    }

    public Docentes(String cedula, String tipo, String fecha) {

        this.cedula = cedula;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
