package Punto4;

import java.util.ArrayList;
import java.util.Iterator;

import Principal.GestionValidaciones;
import Punto5.Tarjeta;

import javax.swing.*;

public class GestionDatos {

    GestionValidaciones validacion = new GestionValidaciones();
    String codigo, numeros, letras;
    int opc = 0;
    boolean swt = true;

    public void ingresarDatos(ArrayList<Datos> datos) {

        do {

            Datos dato = new Datos();

            do {

                letras = JOptionPane.showInputDialog(null, "Ingrese Un Dato Donde La Primera Sea Una Letra Mayúscula, Seguida De 3 Números o Cifras o Dígitos, Seguido De Un Espacio, Nuevamente 3 Números, El Signo \"-\" y Finalice Con 6 Números", "Ingresar Letras", JOptionPane.QUESTION_MESSAGE);

                if (validacion.validarLetras(letras)) {

                    dato.setLetras(letras);
                    swt = true;

                } else {

                    JOptionPane.showMessageDialog(null, "ERROR INGRESA UNA CADENA PERMITIDA!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    swt = false;

                }

            } while (!swt);


            do {

                numeros = JOptionPane.showInputDialog(null, "Un Dato Que Inicie Con 4 Números Donde El Primero Es El 1, Seguido De 6 Letras En Mayúscula y Finaliza Con 2 Número Entre El 3 y El 9", "Ingresar Numeros", JOptionPane.QUESTION_MESSAGE);

                if (validacion.validarNumeros(numeros)) {

                    dato.setNumeros(numeros);
                    swt = true;

                } else {

                    JOptionPane.showMessageDialog(null, "ERROR INGRESA UNA CADENA PERMITIDA!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    swt = false;

                }

            } while (!swt);


            do {

                codigo = JOptionPane.showInputDialog(null, "Un Código Que Inicie Con La Letra \"E\" En Mayúscula, Seguida Del Signo \"-\", Seguido De Las Letras En Mayúscula \"ISSN\", Siguiendo Un Espacio y 4 Números, El Signo \"-\" y Finalizando Con 4 Números", "Ingresar Codigos", JOptionPane.QUESTION_MESSAGE);

                if (validacion.validarCodigos(codigo)) {

                    dato.setCodigo(codigo);
                    swt = true;

                } else {

                    JOptionPane.showMessageDialog(null, "ERROR INGRESA UNA CADENA PERMITIDA!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    swt = false;

                }

            } while (!swt);

            datos.add(dato);

            opc = (JOptionPane.showConfirmDialog(null, "¿Que Quieres Agregar Otro Codigo?", "Menu Codigo", JOptionPane.YES_NO_OPTION));

        } while (opc != JOptionPane.NO_OPTION);
    }

    public void mostrarDatos(ArrayList<Datos> datos) {

        Iterator<Datos> itrDatos = datos.iterator();
        StringBuilder dato = new StringBuilder();

        while (itrDatos.hasNext()) {

            Datos d = itrDatos.next();

            dato.append("Codigo #1: ").append(d.getLetras()).append("\n").append("Codigo #2: ").append(d.getNumeros()).append("\n").append("Codigo #3: ").append(d.getCodigo()).append("\n - - - - - - - - - - - - - - - - - - - - - - - - - \n");
        }

        if (dato.isEmpty()) {

            JOptionPane.showMessageDialog(null, "No Hay Codigos", "Lista Vacía", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null, dato.toString(), "Lista De Codigos", JOptionPane.INFORMATION_MESSAGE);
    }

    public void filtrar(ArrayList<Datos> datos) {

        mostrarDatos(validacion.filtrarCodigos(datos));

    }
}
