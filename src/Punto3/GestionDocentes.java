package Punto3;

import Principal.GestionValidaciones;
import Punto5.Tarjeta;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.util.Iterator;

public class GestionDocentes {

    String cedula, fecha, tipo, mes;
    GestionValidaciones validacion = new GestionValidaciones();
    String[] opciones = {"Planta", "Ocasional", "Catedra"};
    JComboBox<String> tiposDocente = new JComboBox<>(opciones);
    int respuesta;
    boolean swt = true;

    public void ingresarDocentes(ArrayList<Docentes> docentes) {

        do {

            Docentes docente = new Docentes();
            int contadorErrores = 0;

            do {

                cedula = JOptionPane.showInputDialog(null, "Ingrese la Cedula del Docente", "Cedula", JOptionPane.QUESTION_MESSAGE);

                if (validacion.validarCedula(cedula)) {

                    docente.setCedula(cedula);
                    swt = true;

                } else {

                    JOptionPane.showMessageDialog(null, "ERROR, CEDULA INCORRECTA!!", "Error", JOptionPane.ERROR_MESSAGE);
                    contadorErrores++;
                    swt = false;
                }
            } while (!swt);

            JOptionPane.showMessageDialog(null, "Cedula Ingresada Correctamente, Despues De " + contadorErrores + " Intentos", "Conteo De Errores", JOptionPane.INFORMATION_MESSAGE);

            do {

                int option = JOptionPane.showOptionDialog(null, tiposDocente, "Selecciona el tipo de docente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (option == JOptionPane.OK_OPTION) {

                    docente.setTipo((String) tiposDocente.getSelectedItem());
                    swt = true;

                } else {

                    JOptionPane.showMessageDialog(null, "ERROR AL ESCOGER EL TIPO DE DOCENTE!!", "Error", JOptionPane.ERROR_MESSAGE);
                    swt = false;
                }
            } while (!swt);

            do {

                fecha = JOptionPane.showInputDialog(null, "Ingrese la Fecha de Registro del Docente (DD-MM-YYYY)", "Cedula", JOptionPane.QUESTION_MESSAGE);

                if (validacion.validarFechaDocentes(fecha)) {
                    docente.setFecha(fecha);
                    swt = true;

                } else {

                    JOptionPane.showMessageDialog(null, "ERROR, FORMATO DE FECHA INCORRECTO!!", "error", JOptionPane.ERROR_MESSAGE);
                    swt = false;
                }
            } while (!swt);

            docentes.add(docente);

            respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro docente?", "Agregar docente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        } while (respuesta != JOptionPane.NO_OPTION);
    }

    public void mostrarDocentes(ArrayList<Docentes> docentes) {

        StringBuilder cadenaDocentes = new StringBuilder();
        Iterator<Docentes> itrDocentes = docentes.iterator();

        while (itrDocentes.hasNext()) {

            Docentes d = itrDocentes.next();

            cadenaDocentes.append("Cedula: ").append(d.getCedula()).append("\n")
                    .append("Tipo de Docente: ").append(d.getTipo()).append("\n")
                    .append("Fecha de Registro: ").append(d.getFecha()).append("\n - - - - - - - - - - \n");
        }

        if (docentes.isEmpty()) {

            JOptionPane.showMessageDialog(null, "No Hay Docentes", "Lista Vacía", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, cadenaDocentes, "Docentes", JOptionPane.INFORMATION_MESSAGE);
    }

    public void porcentajeDocentes(ArrayList<Docentes> docentes) {

        float porCatedra, porOcasional, porPlanta;
        int contCatedra = 0, contOcasional = 0, contPlanta = 0, totalDocentes;

        for (Docentes docente : docentes) {

            if (docente.getTipo().equalsIgnoreCase("Catedra")) {

                contCatedra = contCatedra + 1;
            }

            if (docente.getTipo().equalsIgnoreCase("Ocasional")) {

                contOcasional = contOcasional + 1;
            }

            if (docente.getTipo().equalsIgnoreCase("Planta")) {

                contPlanta = contPlanta + 1;
            }

        }
        totalDocentes = contPlanta + contCatedra + contOcasional;

        porCatedra = ((float) contCatedra / totalDocentes) * 100;
        porOcasional = ((float) contOcasional / totalDocentes) * 100;
        porPlanta = ((float) contPlanta / totalDocentes) * 100;

        JOptionPane.showMessageDialog(null, "Estos Son Los Porcentajes: \n\nCatedra " + String.format("%.1f", porCatedra) + "%\nOcasional " + String.format("%.1f", porOcasional) + "%\nPlanta " + String.format("%.1f", porPlanta) + "%", "Porcentajes", JOptionPane.INFORMATION_MESSAGE);

    }

    public void filtradoMesCatedra(ArrayList<Docentes> docentes) {

        do {

            int option = JOptionPane.showOptionDialog(null, tiposDocente, "Selecciona El Tipo De Docente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

            if (option == JOptionPane.OK_OPTION) {

                tipo = (String) tiposDocente.getSelectedItem();
                swt = true;

            } else {

                JOptionPane.showMessageDialog(null, "ERROR AL ESCOGER EL TIPO DE DOCENTE!!", "Error", JOptionPane.ERROR_MESSAGE);
                swt = false;
            }
        } while (!swt);

        do {

            mes = JOptionPane.showInputDialog(null, "Ingrese El Mes", "Mes", JOptionPane.QUESTION_MESSAGE);

            if (validacion.validarMes(mes)) {

                swt = true;

            } else {

                JOptionPane.showMessageDialog(null, "ERROR, MES INCORRECTO!!", "Error", JOptionPane.ERROR_MESSAGE);
                swt = false;
            }
        } while (!swt);

        mostrarDocentes(validacion.buscarMesDocentes(mes, tipo, docentes));

    }
}
