package Punto2;

import Principal.GestionValidaciones;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class GestionArrays {

    GestionValidaciones validacion = new GestionValidaciones();
    int tamaño, tamañoInterno = 3, valorMayor;
    boolean swt = true;

    public void llenarArray(ArrayList<ArrayList> a) {

        do {

            String t = (JOptionPane.showInputDialog(null, "Ingrese El Numero De Nodos Para El ArrayList", "Ingresar Tamaño", JOptionPane.QUESTION_MESSAGE));

            if (validacion.validarDigito(t)) {

                tamaño = Integer.parseInt(t);
                swt = true;

            } else {

                JOptionPane.showMessageDialog(null, "ERROR INGRESA UN TAMAÑO VALIDO  !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                swt = false;
            }
        } while (!swt);

        swt = true;

        for (int i = 0; i < tamaño; i++) {

            JOptionPane.showMessageDialog(null, "Nodo #" + (i + 1), "Nodo #" + (i + 1), JOptionPane.INFORMATION_MESSAGE);

            do {
                String valor = (JOptionPane.showInputDialog(null, "Ingrese Un Numero Padre ", "Ingresar Numero Mayor", JOptionPane.QUESTION_MESSAGE));

                if (validacion.validarDigito(valor)) {

                    valorMayor = Integer.parseInt(valor);
                    swt = true;

                } else {

                    JOptionPane.showMessageDialog(null, "ERROR INGRESA UN NUMERO VALIDO  !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    swt = false;
                }
            } while (!swt);

            a.add(new ArrayList<Integer>());

            for (int j = 1; j <= tamañoInterno; j++) {

                do {
                    JOptionPane.showMessageDialog(null, "Nodo interno #" + (j), "Nodo Interno  #" + (j), JOptionPane.INFORMATION_MESSAGE);
                    String v = (JOptionPane.showInputDialog(null, "Ingrese Un Numero Menor Que El Numero Padre ", "Ingresar Numero Menor", JOptionPane.QUESTION_MESSAGE));

                    if (validacion.validarDigito(v)) {

                        int valor = Integer.parseInt(v);

                        if (valor < valorMayor) {

                            a.get(i).add(valor);
                            swt = true;

                        } else {

                            JOptionPane.showMessageDialog(null, "ERROR INGRESA UN NUMERO MAYOR AL PADRE  !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            swt = false;
                        }

                    } else {

                        JOptionPane.showMessageDialog(null, "ERROR INGRESA UN NUMERO VALIDO  !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        swt = false;
                    }
                } while (!swt);
            }
            tamañoInterno += 2;
        }
    }

    public void mostrarArrayList(ArrayList<ArrayList> a) {

        StringBuilder cadenaArray = new StringBuilder();
        int contadorNodos = 1;

        for (ArrayList<Integer> arrayInterno : a) {

            cadenaArray.append("Nodo  #").append(contadorNodos);
            cadenaArray.append("\n ---------------------------------------\n");
            Iterator<Integer> iterator = arrayInterno.iterator();

            while (iterator.hasNext()) {

                cadenaArray.append(iterator.next()).append(" - ");
            }
            cadenaArray.append("\n ---------------------------------------\n");
            contadorNodos++;
        }

        if (cadenaArray.isEmpty()) {

            JOptionPane.showMessageDialog(null, "No Hay Arrays", "Lista Vacia", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null, cadenaArray.toString(), "Lista De Arrays", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarMayores(ArrayList<ArrayList> a) {

        int contadorNodos = 1;
        StringBuilder cadenaMayores = new StringBuilder();

        for (ArrayList<Integer> arrayInterno : a) {

            int mayor = encontrarMayor(arrayInterno);
            cadenaMayores.append("Nodo  #").append(contadorNodos);
            cadenaMayores.append("\n ---------------------------------------\n");
            cadenaMayores.append("El Numero Mayor Es: ").append(mayor);
            cadenaMayores.append("\n ---------------------------------------\n");
            contadorNodos++;
        }
        if (cadenaMayores.isEmpty()) {

            JOptionPane.showMessageDialog(null, "No Hay Numeros Mayores", "Lista Vaci­a", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null, cadenaMayores.toString(), "Lista De Numeros Mayores", JOptionPane.INFORMATION_MESSAGE);

    }

    public int encontrarMayor(ArrayList<Integer> b) {

        int mayor = Integer.MIN_VALUE;

        for (int num : b) {

            if (num > mayor) {
                mayor = num;
            }
        }
        return mayor;
    }
}

