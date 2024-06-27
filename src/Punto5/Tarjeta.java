package Punto5;

public class Tarjeta {

    private String tipoTarjeta, nTarjeta, fecha,nombre,apellido,cvv;

    public Tarjeta(String tipoTarjeta, String nTarjeta, String fecha, String nombre, String apellido, String cvv) {

        this.tipoTarjeta = tipoTarjeta;
        this.nTarjeta = nTarjeta;
        this.fecha = fecha;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cvv = cvv;
    }

    public Tarjeta() {
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getnTarjeta() {
        return nTarjeta;
    }

    public void setnTarjeta(String nTarjeta) {
        this.nTarjeta = nTarjeta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
