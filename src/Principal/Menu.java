package Principal;

import javax.swing.*;

import Punto1.GestionNumeros;
import Punto1.Numeros;
import Punto2.GestionArrays;
import Punto3.Docentes;
import Punto3.GestionDocentes;
import Punto4.Datos;
import Punto4.GestionDatos;
import Punto5.GestionTarjeta;
import Punto5.Tarjeta;

import java.util.ArrayList;

public class Menu {
    int opc = 0;
    ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
    ArrayList<Datos> datos = new ArrayList<Datos>();
    ArrayList<Docentes> docentes = new ArrayList<Docentes>();
    ArrayList<Numeros> numeros = new ArrayList<Numeros>();
    ArrayList<ArrayList> arrayList = new ArrayList<>();

    public void menuPrincipal() {

        do {

            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Elige Una Opcion:\n1).Numeros\n2).Arrays\n3).Docentes\n4).Codigos\n5).Tarjetas Bancarias\n6).Salir", "Menu Principal", JOptionPane.QUESTION_MESSAGE));

            switch (opc) {

                case 1:
                    menuNumeros();
                    break;

                case 2:
                    menuArrays();
                    break;

                case 3:
                    menuDocentes();
                    break;

                case 4:
                    menuCodigos();
                    break;

                case 5:
                    menuTarjetasBancarias();
                    break;

                case 6:
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion Incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (opc != 6);
    }


    public void menuArrays() {

        GestionArrays gestionArrays = new GestionArrays();
        opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese La Opcion: \n1).Ingresar Arrays \n2).Mostrar Arrays \n3).Mostrar Mayores\n4).Volver", "ArrayList", JOptionPane.INFORMATION_MESSAGE));

        switch (opc) {

            case 1:
                gestionArrays.llenarArray(arrayList);
                menuArrays();
                break;

            case 2:
                gestionArrays.mostrarArrayList(arrayList);
                menuArrays();
                break;

            case 3:
                gestionArrays.mostrarMayores(arrayList);
                menuArrays();
                break;

            case 4:
                menuPrincipal();
                break;

            default:
                JOptionPane.showMessageDialog(null, "ERROR, OPCION INCORRECTA!!", "error", JOptionPane.ERROR_MESSAGE);
                menuArrays();
                break;
        }
    }

    public void menuNumeros() {

        GestionNumeros gestionNumeros = new GestionNumeros();

        opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese La Opcion: \n1).Ingresar Numeros \n2).Mostrar Numeros\n3).Promedio De Nodos\n4).Volver", "Numeros", JOptionPane.INFORMATION_MESSAGE));

        do {

            switch (opc) {

                case 1:
                    gestionNumeros.ingresarNumero(numeros);
                    menuNumeros();
                    break;

                case 2:
                    gestionNumeros.mostrarNumeros(numeros);
                    menuNumeros();
                    break;

                case 3:
                    gestionNumeros.promedio(numeros);
                    menuNumeros();
                    break;

                case 4:
                    menuPrincipal();
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion Incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (opc != 4);
    }

    public void menuDocentes() {

        GestionDocentes gestionDocentes = new GestionDocentes();

        opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese La Opcion: \n1).Ingresar Docentes \n2).Mostrar Docentes\n3).Porcentajes De Docentes\n4).Filtrar Por Mes\n5).Volver", "Docentes", JOptionPane.INFORMATION_MESSAGE));

        do {
            switch (opc) {

                case 1:
                    gestionDocentes.ingresarDocentes(docentes);
                    menuDocentes();
                    break;

                case 2:
                    gestionDocentes.mostrarDocentes(docentes);
                    menuDocentes();
                    break;

                case 3:
                    gestionDocentes.porcentajeDocentes(docentes);
                    menuDocentes();
                    break;

                case 4:
                    gestionDocentes.filtradoMesCatedra(docentes);
                    menuDocentes();
                    break;

                case 5:
                    menuPrincipal();
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion Incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (opc != 5);
    }

    public void menuCodigos() {

        GestionDatos gestionDatos = new GestionDatos();

        do {

            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Elige Una Opcion:\n1).Ingresar Codigos \n2).Mostrar Codigos \n3).Filtrar Codigos Por Dos Numeros Iguales\n4).Volver", "Menu Datos", JOptionPane.QUESTION_MESSAGE));

            switch (opc) {

                case 1:
                    gestionDatos.ingresarDatos(datos);
                    menuCodigos();
                    break;

                case 2:
                    gestionDatos.mostrarDatos(datos);
                    menuCodigos();
                    break;

                case 3:
                    gestionDatos.filtrar(datos);
                    menuCodigos();
                    break;

                case 4:
                    menuPrincipal();
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion Incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (opc != 4);
    }

    public void menuTarjetasBancarias() {

        GestionTarjeta gestionTarjeta = new GestionTarjeta();

        do {

            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Elige Una Opcion:\n1).Ingresar Tarjetas \n2).Mostrar Tarjetas \n3).Buscar Tipo \n4).Filtrar Año \n5).Volver", "Menu Principal", JOptionPane.QUESTION_MESSAGE));

            switch (opc) {

                case 1:

                    gestionTarjeta.ingresarDatos(tarjetas);
                    menuTarjetasBancarias();
                    break;

                case 2:
                    gestionTarjeta.mostrarTarjetas(tarjetas);
                    menuTarjetasBancarias();
                    break;

                case 3:
                    gestionTarjeta.buscarTarjetas(tarjetas);
                    menuTarjetasBancarias();
                    break;

                case 4:
                    gestionTarjeta.filtradoAno(tarjetas);
                    menuTarjetasBancarias();
                    break;

                case 5:
                    menuPrincipal();
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion Incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (opc != 5);
    }
}
