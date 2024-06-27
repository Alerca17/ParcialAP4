package Punto5;

import Principal.GestionValidaciones;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class GestionTarjeta {

    GestionValidaciones validacion = new GestionValidaciones();
    String tipoTarjeta, nTarjeta, fecha, nombre, apellido, cvv;
    int opc = 0;
    boolean swt = true;

    public void ingresarDatos(ArrayList<Tarjeta> tarjetas) {

        do {

            Tarjeta tarjeta = new Tarjeta();

            do {

                tipoTarjeta = JOptionPane.showInputDialog(null, "Ingrese El Tipo De Tarjeta", "Tipo Tarjeta", JOptionPane.QUESTION_MESSAGE);

                if (validacion.validarTipoTarjeta(tipoTarjeta)) {

                    tarjeta.setTipoTarjeta(tipoTarjeta);
                    swt = true;

                } else {

                    JOptionPane.showMessageDialog(null, "TIPO DE TARJETA INCORRECTO!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    swt = false;

                }


            } while (!swt);

            do {

                nTarjeta = JOptionPane.showInputDialog(null, "Ingrese El Numero De La Tarjeta", "Numero Tarjeta", JOptionPane.QUESTION_MESSAGE);

                if (validacion.validarNumeroTarjeta(nTarjeta)) {

                    tarjeta.setnTarjeta(nTarjeta);
                    swt = true;

                } else {

                    JOptionPane.showMessageDialog(null, "ERROR!!!, INGRESA UN FORMATO PERMITIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
                    swt = false;

                }

            } while (!swt);

            do {

                fecha = JOptionPane.showInputDialog(null, "Ingrese La Fecha De Vencimiento De La Tarjeta (MM-YY)", "Fecha Tarjeta", JOptionPane.QUESTION_MESSAGE);

                if (validacion.validarFecha(fecha)) {

                    tarjeta.setFecha(fecha);
                    swt = true;

                } else {

                    JOptionPane.showMessageDialog(null, "ERROR!!!, INGRESA UN FORMATO PERMITIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
                    swt = false;

                }

            } while (!swt);

            do {

                nombre = JOptionPane.showInputDialog(null, "Ingrese El Nombre Del Titular De La Tarjeta", "Nombre Titular", JOptionPane.QUESTION_MESSAGE);

                if (validacion.validarCadenas(nombre)) {

                    tarjeta.setNombre(nombre);
                    swt = true;

                } else {

                    JOptionPane.showMessageDialog(null, "ERROR!!!, INGRESA UN FORMATO PERMITIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
                    swt = false;

                }

            } while (!swt);

            do {

                apellido = JOptionPane.showInputDialog(null, "Ingrese El Apellido Del Titular De La Tarjeta", "Apellido Titular", JOptionPane.QUESTION_MESSAGE);

                if (validacion.validarCadenas(apellido)) {

                    tarjeta.setApellido(apellido);
                    swt = true;

                } else {

                    JOptionPane.showMessageDialog(null, "ERROR!!!, INGRESA UN FORMATO PERMITIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
                    swt = false;

                }

            } while (!swt);

            do {

                cvv = JOptionPane.showInputDialog(null, "Ingrese El Codigo De Seguridad De La Tarjeta", "Codigo De Seguridad", JOptionPane.QUESTION_MESSAGE);

                if (validacion.validarCVV(cvv)) {

                    tarjeta.setCvv(cvv);
                    swt = true;

                } else {

                    JOptionPane.showMessageDialog(null, "ERROR!!!, INGRESA UN FORMATO PERMITIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
                    swt = false;

                }

            } while (!swt);

            tarjetas.add(tarjeta);

            opc = (JOptionPane.showConfirmDialog(null, "¿Que Quieres Agregar Otra Tarjeta?", "Menu Tarjeta", JOptionPane.YES_NO_OPTION));

        } while (opc != JOptionPane.NO_OPTION);
    }

    public void mostrarTarjetas(ArrayList<Tarjeta> tarjeta) {

        Iterator<Tarjeta> itrTarjetas = tarjeta.iterator();
        StringBuilder tarjetas = new StringBuilder();


        while (itrTarjetas.hasNext()) {

            Tarjeta t = itrTarjetas.next();

            tarjetas.append("Tipo De Tarjeta: ").append(t.getTipoTarjeta()).append("\n")
                    .append("Numero: ").append(t.getnTarjeta()).append("\n")
                    .append("Nombre: ").append(t.getNombre()).append("\n")
                    .append("Apellido: ").append(t.getApellido()).append("\n")
                    .append("Fecha: ").append(t.getFecha()).append("\n")
                    .append("Codigo: ").append(t.getCvv()).append("\n")
                    .append("\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n");
        }

        if (tarjeta.isEmpty()) {

            JOptionPane.showMessageDialog(null, "No Hay Tarjetas", "Lista Vacía", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null, tarjetas.toString(), "Lista De Tarjetas", JOptionPane.INFORMATION_MESSAGE);
    }

    public void buscarTarjetas(ArrayList<Tarjeta> tarjetas) {

        tipoTarjeta = JOptionPane.showInputDialog(null, "Ingrese El Tipo De Tarjeta A Buscar", "Buscada Tarjeta", JOptionPane.QUESTION_MESSAGE);

        if (validacion.validarTipoTarjeta(tipoTarjeta)) {

            mostrarTarjetas(validacion.buscarTipoTarjeta(tipoTarjeta, tarjetas));

        } else {

            JOptionPane.showMessageDialog(null, "TIPO DE TARJETA INCORRECTO!!!", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void filtradoAno(ArrayList<Tarjeta> tarjetas) {

        fecha = JOptionPane.showInputDialog(null, "Ingrese El Año De Las Tarjetas A Filtrar", "Buscada Tarjeta Por Año", JOptionPane.QUESTION_MESSAGE);

        if (validacion.validarAno(fecha)) {

            mostrarTarjetas(validacion.buscarAno(fecha, tarjetas));

        } else {

            JOptionPane.showMessageDialog(null, "ERROR AÑO INCORRECTO", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }
}

