package Punto1;

import Principal.GestionValidaciones;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class GestionNumeros {

    GestionValidaciones validacion = new GestionValidaciones();
    int num, ingresado = 1;
    String num_1, num_2, num_3;
    boolean swt = true;

    public void ingresarNumero(ArrayList<Numeros> numeros) {

        do {

            num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese El Numero De Nodos Para El ArrayList", "Ingresar Numero", JOptionPane.QUESTION_MESSAGE));

            if (validacion.validarNumeroPrimo(num) && validacion.validarDigito(String.valueOf(num))) {

                swt = true;

            } else {

                JOptionPane.showMessageDialog(null, "ERROR INGRESA UN NUMERO PRIMO!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                swt = false;
            }
        } while (!swt);

        JOptionPane.showMessageDialog(null, "El Numero Es Primo", "Validacion Correcta", JOptionPane.INFORMATION_MESSAGE);

        do {

            Numeros numero = new Numeros();

            JOptionPane.showMessageDialog(null, "Nodo #" + (ingresado), "Cantidad De Nodos", JOptionPane.INFORMATION_MESSAGE);

            do {

                num_1 = JOptionPane.showInputDialog(null, "Ingrese El Primer Numero", "Ingresar Numero", JOptionPane.QUESTION_MESSAGE);

                if (validacion.validarDigito(num_1)) {

                    if (validacion.validarDigitos(ingresado, String.valueOf(num_1))) {

                        numero.setNum_1(num_1);
                        swt = true;

                    } else {

                        JOptionPane.showMessageDialog(null, "ERROR INGRESA UN NUMERO DE " + ingresado + " DIGITOS!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        swt = false;
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "ERROR, INGRESA EL NUMERO CORRECTAMENTE", "ERROR", JOptionPane.ERROR_MESSAGE);
                    swt = false;
                }
            } while (!swt);

            do {

                num_2 = JOptionPane.showInputDialog(null, "Ingrese El Segundo Numero", "Ingresar Numero", JOptionPane.QUESTION_MESSAGE);

                if (validacion.validarDigito(num_2) && Integer.parseInt(num_2) > Integer.parseInt(num_1)) {

                    if (validacion.validarDigitos(ingresado, String.valueOf(num_2))) {

                        numero.setNum_2(num_2);
                        swt = true;

                    } else {

                        JOptionPane.showMessageDialog(null, "ERROR INGRESA UN NUMERO DE " + ingresado + " DIGITOS!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        swt = false;
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "ERROR, INGRESA EL NUMERO CORRECTAMENTE", "ERROR", JOptionPane.ERROR_MESSAGE);
                    swt = false;
                }
            } while (!swt);

            do {

                num_3 = JOptionPane.showInputDialog(null, "Ingrese El Tercer Numero", "Ingresar Numero", JOptionPane.QUESTION_MESSAGE);

                if (validacion.validarDigito(num_3) && Integer.parseInt(num_3) > Integer.parseInt(num_2)) {

                    if (validacion.validarDigitos(ingresado, String.valueOf(num_3))) {

                        numero.setNum_3(num_3);
                        swt = true;

                    } else {

                        JOptionPane.showMessageDialog(null, "ERROR INGRESA UN NUMERO DE " + ingresado + " IGITOS!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        swt = false;
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "ERROR, INGRESA EL NUMERO CORRECTAMENTE", "ERROR", JOptionPane.ERROR_MESSAGE);
                    swt = false;
                }
            } while (!swt);

            numeros.add(numero);
            ingresado++;

        } while (ingresado <= num);
    }

    public void mostrarNumeros(ArrayList<Numeros> numeros) {

        Iterator<Numeros> itrNumeros = numeros.iterator();
        StringBuilder numero = new StringBuilder();

        while (itrNumeros.hasNext()) {

            Numeros n = itrNumeros.next();

            numero.append("Numero 1: ").append(n.getNum_1()).append("\nNumero 2: ").append(n.getNum_2()).append("\nNumero 3: ").append(n.getNum_3()).append("\n - - - - - - - - - - - - \n");
        }

        if (numero.isEmpty()) {

            JOptionPane.showMessageDialog(null, "No Hay Numeros", "Lista VaciÂ­a", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null, numero.toString(), "Lista De Codigos", JOptionPane.INFORMATION_MESSAGE);
    }

    public void promedio(ArrayList<Numeros> numeros) {

        int i = 0, j = numeros.size() - 1;
        double prom1, prom2;
        StringBuilder promedios = new StringBuilder();

        while (i <= j) {

            Numeros n = new Numeros();

            if (i == j) {

                n = numeros.get(i);
                prom1 = calcularPromedio(Integer.parseInt(n.getNum_1()), Integer.parseInt(n.getNum_2()), Integer.parseInt(n.getNum_3()));

                promedios.append("Promedio Nodo ")
                        .append(i + 1)
                        .append(" = ")
                        .append(prom1)
                        .append("\n");
            } else {

                n = numeros.get(i);
                prom1 = calcularPromedio(Integer.parseInt(n.getNum_1()), Integer.parseInt(n.getNum_2()), Integer.parseInt(n.getNum_3()));

                promedios.append("Promedio Nodo ")
                        .append(i + 1)
                        .append(" = ")
                        .append(prom1)
                        .append("\n");
                n = numeros.get(j);

                prom2 = calcularPromedio(Integer.parseInt(n.getNum_1()), Integer.parseInt(n.getNum_2()), Integer.parseInt(n.getNum_3()));

                promedios.append("Promedio Nodo ")
                        .append(j + 1)
                        .append(" = ")
                        .append(prom2)
                        .append("\n");
            }
            i++;
            j--;
        }
        if (promedios.isEmpty()) {

            JOptionPane.showMessageDialog(null, "No Hay Elementos", "ListaVacia", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null, promedios.toString(), "Lista De Promedios", JOptionPane.INFORMATION_MESSAGE);
    }

    public double calcularPromedio(int a, int b, int c) {

        return (a + b + c) / 3;
    }
}


