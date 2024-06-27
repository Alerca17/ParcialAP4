package Principal;

import Punto3.Docentes;
import Punto4.Datos;
import Punto5.Tarjeta;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GestionValidaciones {

    public GestionValidaciones() {
    }

    //--------------------- Validaciones del punto 5  --------------------
    public boolean validarTipoTarjeta(String tarjeta) {

        return tarjeta.matches("(?i)(MasterCard|Visa)");
    }
    public boolean validarNumeroTarjeta(String nTarjeta) {

        return nTarjeta.matches("^\\d{4}-?\\d{4}-?\\d{4}-?\\d{4}$");
    }
    public boolean validarFecha(String fecha) {

        return fecha.matches("^(0[1-9]|1[0-2])-(\\d{2})$");
    }
    public boolean validarCadenas(String cadena) {

        return cadena.matches("^[A-Z]+$");
    }
    public boolean validarCVV(String CCV) {

        return CCV.matches("^\\d{3}$");
    }
    public boolean validarAno(String ano) {

        return ano.matches("\\d{2}");
    }
    public ArrayList buscarTipoTarjeta(String tipoTarjeta, ArrayList<Tarjeta> tarjetas) {

        ArrayList<Tarjeta> tarjetasMastercard = new ArrayList<>();
        ArrayList<Tarjeta> tarjetasVisa = new ArrayList<>();

        Pattern patronMasterCard = Pattern.compile("MasterCard", Pattern.CASE_INSENSITIVE);
        Pattern patronVisa = Pattern.compile("Visa", Pattern.CASE_INSENSITIVE);

        for (Tarjeta tarjeta : tarjetas) {

            Matcher matcherMasterCard = patronMasterCard.matcher(tarjeta.getTipoTarjeta());
            Matcher matcherVisa = patronVisa.matcher(tarjeta.getTipoTarjeta());

            if (matcherMasterCard.find()) {

                tarjetasMastercard.add(tarjeta);

            } else if (matcherVisa.find()) {

                tarjetasVisa.add(tarjeta);
            }
        }

        if (tipoTarjeta.equalsIgnoreCase("MasterCard")) {

            return tarjetasMastercard;

        } else {

            return tarjetasVisa;
        }
    }
    public ArrayList buscarAno(String ano, ArrayList<Tarjeta> tarjetas) {

        ArrayList<Tarjeta> tAno = new ArrayList<>();
        String patronAno = "\\d{2}-" + ano + "$";

        for (Tarjeta tarjeta : tarjetas) {

            if (tarjeta.getFecha().matches(patronAno)) {

                tAno.add(tarjeta);
            }
        }
        return tAno;
    }

//------------------------------------------------------------------------------------------------
    //----------------- Validaciones Punto 4 ---------------------
    public boolean validarLetras(String letras) {

        return letras.matches("[A-Z]\\d{3} \\d{3}-\\d{6}");
    }
    public boolean validarNumeros(String numeros) {

        return numeros.matches("^1\\d{3}[A-Z]{6}[3-9]{2}$");
    }
    public boolean validarCodigos(String codigo) {

        return codigo.matches("E-ISSN \\d{4}-\\d{4}");
    }
    public ArrayList filtrarCodigos(ArrayList<Datos> datos) {

        ArrayList<Datos> dFiltrados = new ArrayList<>();
        String patronCodigo = ".*(\\d)\\1.*";

        for (Datos dato : datos) {

            Datos d = new Datos();

            if (dato.getLetras().matches(patronCodigo)) {

                d.setLetras(dato.getLetras());
            }

            if (dato.getNumeros().matches(patronCodigo)) {

                d.setNumeros(dato.getNumeros());
            }

            if (dato.getCodigo().matches(patronCodigo)) {

                d.setCodigo(dato.getCodigo());
            }
            dFiltrados.add(d);
        }
        return dFiltrados;
    }

    //-----------------------------------------------------------------
    // ------------------ Punto 3 ---------------------
    public boolean validarCedula(String cedula) {

        return cedula.matches("\\d{6,10}");
    }
    public boolean validarFechaDocentes(String fecha) {

        return fecha.matches("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{4})$");
    }
    public ArrayList buscarMesDocentes(String mes, String tipoDocente, ArrayList<Docentes> docentes) {

        ArrayList<Docentes> docentesMesCatedra = new ArrayList<>();

        String patronMes = "^(0[1-9]|[12][0-9]|3[01])-" + mes + "-(\\d{4})$";

        for (Docentes docente : docentes) {

            if (docente.getFecha().matches(patronMes) && docente.getTipo().equalsIgnoreCase(tipoDocente)) {

                docentesMesCatedra.add(docente);
            }
        }
        return docentesMesCatedra;
    }

    public boolean validarMes(String mes) {

        return mes.matches("^(0[1-9]|1[0-2])$");
    }
    //----------------------------------------------------------
    //-------------- Punto 1 --------------
    public boolean validarDigito(String numero) {

        return numero.matches("\\d+");
    }
    public boolean validarNumeroPrimo(int numero) {

        if (numero <= 1) {

            return false;
        }

        for (int i = 2; i < numero; i++) {

            if (numero % i == 0) {

                return false;
            }
        }
        return true;
    }

    public boolean validarDigitos(int cantidad,String numero){

        return numero.matches("\\d{"+cantidad+ "}");
    }

}