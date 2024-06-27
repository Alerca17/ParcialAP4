package Punto4;

import java.util.ArrayList;

public class Datos {

    private String codigo, numeros, letras;

    public Datos(String codigo, String numeros, String letras) {

        this.codigo = codigo;
        this.numeros = numeros;
        this.letras = letras;
    }

    public Datos() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumeros() {
        return numeros;
    }

    public void setNumeros(String numeros) {
        this.numeros = numeros;
    }

    public String getLetras() {
        return letras;
    }

    public void setLetras(String letras) {
        this.letras = letras;
    }
}
