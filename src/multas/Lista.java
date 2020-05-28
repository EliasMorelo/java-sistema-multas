package multas;

import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lista {

    private Nodo inicio;
    private int tam;

    public boolean estaVacia() {
        return inicio == null;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public int tamLista() {
        return tam;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public void agregarMulta() {
        //Objeto de tipo feha
        Date objDate = new Date();
        String strDateFormat = "dd-MMM-yyyy hh: mm: ss a";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        String f = objSDF.format(objDate);

        //Vector que guarda los tipos de vehiculos
        String[] tiposVeh = {
            "TIPO 1. Motocicleta", "TIPO 2. Motocarro", "TIPO 3. Mototriciclo",
            "TIPO 4. Cuatrimoto", "TIPO 5. Automóvil", "TIPO 6. Campero", "TIPO 7. Camioneta",
            "TIPO 8. Microbús", "TIPO 9. Bus", "TIPO 10. Buseta", "TIPO 11. Camión",
            "TIPO 12. Tractocamión", "TIPO 13. Volqueta", "TIPO 14. Buggy", "TIPO 15. Convertible"
        };
        String tiposV = "";
        for (int i = 0; i < tiposVeh.length; i++) {
            tiposV += "\n" + tiposVeh[i];
        }
        //Vector que guarda los tipos de multa
        String[] tiposMulta = {"TIPO 1\n"
            + "Ejemplo: Ocupación de espacio público.\n"
            + "Valor de la multa en SMDL: 4 SMDL = ($117.040)\n",
            "TIPO 2\n"
            + "Ejemplo: Porte de bebidas alcohólicas, sustancias psicoactivas o prohibidas.\n"
            + "Valor de la multa en SMDL: 8 SMDL = ($234.081)\n",
            "TIPO 3\n"
            + "Ejemplo: Vender celulares con reporte de hurto.\n"
            + "Valor de la multa en SMDL: 16 SMDLV = ($468.160)\n",
            "TIPO 4\n"
            + "Ejemplo: Arrojar basuras en espacio público.\n"
            + "Valor de la multa en SMDL: 32 SMDLV = ($936.320)\n"
        };
        String tipos = "";
        for (int i = 0; i < tiposMulta.length; i++) {
            tipos += "\n" + tiposMulta[i];
        }
        Vehiculo v = new Vehiculo();
        v.setNombreD(JOptionPane.showInputDialog("Ingrese el nombre del dueño del vehiculo"));
        int tv = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de vehiculo" + tiposV + "\nPOR FAVOR INGRESAR SOLO EL NÚMERO DEL TIPO DE VEHICULO"));
        if (tv >= 1 && tv <= 15) {
            switch (tv) {
                case 1:
                    v.setTipoVeh("Motocicleta");
                    break;
                case 2:
                    v.setTipoVeh("Motocarro");
                    break;
                case 3:
                    v.setTipoVeh("Mototriciclo");
                    break;
                case 4:
                    v.setTipoVeh("Cuatrimoto");
                    break;
                case 5:
                    v.setTipoVeh("Automóvil");
                    break;
                case 6:
                    v.setTipoVeh("Campero");
                    break;
                case 7:
                    v.setTipoVeh("Camioneta");
                    break;
                case 8:
                    v.setTipoVeh("Microbús");
                    break;
                case 9:
                    v.setTipoVeh("Bus");
                    break;
                case 10:
                    v.setTipoVeh("Buseta");
                    break;
                case 11:
                    v.setTipoVeh("Camión");
                    break;
                case 12:
                    v.setTipoVeh("Tractocamión");
                    break;
                case 13:
                    v.setTipoVeh("Volqueta");
                    break;
                case 14:
                    v.setTipoVeh("Buggy");
                    break;
                case 15:
                    v.setTipoVeh("Convertible");
                    break;
            }
            v.setPlaca(JOptionPane.showInputDialog("Ingrese la placa del vehiculo"));
            v.setNumChasis(JOptionPane.showInputDialog("Ingrese el número del chasis"));
            v.setNumMotor(JOptionPane.showInputDialog("Ingrese el número del motor"));
            int t = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de multa" + tipos + "\nPOR FAVOR INGRESAR SOLO EL NÚMERO DEL TIPO DE LA MULTA"));
            if (t >= 1 && t <= 4) {
                switch (t) {
                    case 1:
                        v.setTipoMulta("TIPO 1");
                        v.setValorMulta(117040);
                        break;
                    case 2:
                        v.setTipoMulta("TIPO 2");
                        v.setValorMulta(234081);
                        break;
                    case 3:
                        v.setTipoMulta("TIPO 3");
                        v.setValorMulta(468160);
                        break;
                    case 4:
                        v.setTipoMulta("TIPO 4");
                        v.setValorMulta(936320);
                        break;
                }
                v.setFecha(f);
                Nodo nuevo = new Nodo();
                nuevo.setValor(v);
                if (estaVacia()) {
                    inicio = nuevo;
                } else {
                    Nodo aux = inicio;
                    while (aux.getSiguiente() != null) {
                        aux = aux.getSiguiente();
                    }
                    aux.setSiguiente(nuevo);
                }
                tam++;
            } else {
                JOptionPane.showMessageDialog(null, "Dato incorrecto");
            }
        }

    }

    public boolean buscarPorPlaca(String placa) {
        Nodo temp = inicio;
        boolean bandera = false;
        while (temp != null && bandera != true) {
            // Consulta si el valor del nodo es igual al de referencia.
            if (temp.getValor().getPlaca().equals(placa)) {
                bandera = true;
            } else {
                temp = temp.getSiguiente();
            }
        }
        return bandera;
    }

    public void abonarMulta(String placa, float abonar) {
        if (buscarPorPlaca(placa)) {
            Nodo temp = inicio;
            boolean bandera = true;
            while (bandera) {
                if (temp.getValor().getPlaca().equals(placa)) {
                    break;
                } else {
                    temp = temp.getSiguiente();
                }
            }
            Vehiculo vehiculo = temp.getValor();
            if (vehiculo.getValorMulta() == abonar) {
                eliminarMulta(placa);
                JOptionPane.showMessageDialog(null, "¡Vehiculo eliminado de la lista! Ya que, el valor a abonado es igual al valor de la multa");
            } else {
                vehiculo.setValorMulta(vehiculo.getValorMulta() - abonar);
                temp.setValor(vehiculo);
                JOptionPane.showMessageDialog(null, "Pago abonado a multa del vehiculo de placa: " + placa);
            }

        } else {
            JOptionPane.showMessageDialog(null, "El vehiculo con la placa " + placa + " no está en la lista");
        }
    }

    public void eliminarMulta(String placa) {
        if (buscarPorPlaca(placa)) {
            if (inicio.getValor().getPlaca().equals(placa)) {
                inicio = inicio.getSiguiente();
            } else {
                boolean bandera = true;
                Nodo aux = inicio;
                while (bandera) {
                    if (aux.getSiguiente().getValor().getPlaca().equals(placa)) {
                        break;
                    } else {
                        aux = aux.getSiguiente();
                    }
                }

                Nodo siguiente = aux.getSiguiente().getSiguiente();
                aux.setSiguiente(siguiente);
                JOptionPane.showMessageDialog(null, "El vehiculo con la placa " + placa + " fue eliminado la lista");
            }
            tam--;
        } else {
            JOptionPane.showMessageDialog(null, "El vehiculo con la placa " + placa + " no está en la lista");
        }
    }

    public String mostrarlista() {
        String datos = "-------------------------------------------------------------------------------------------MULTAS----------------------------------------------------------------------------------------" + "\n"
                + "-----------------------------------------------------------------------------------------CANTIDAD DE MULTAS: " + tam + "-----------------------------------------------------------------------------" + "\n";
        String mensaje;
        if (!estaVacia()) {
            Nodo aux = inicio;
            int i = 0;
            while (aux != null) {
                datos
                        += "----------------------------------------------------------------------------------------MULTA " + (i + 1) + "----------------------------------------------------------------------------------" + "\n"
                        + "\u2000Nombre del dueño: " + aux.getValor().getNombreD() + "\u2000" + "Tipo de Vehiculo: " + aux.getValor().getTipoVeh() + "\u2000" + "Placa del vehiculo: "
                        + aux.getValor().getPlaca() + "\u2000" + "Valor de la multa: " + aux.getValor().getValorMulta() + "\n"
                        + "\n";
                aux = aux.getSiguiente();
                i++;
            }
        }
        return datos;
    }

    public void buscarMulta(String placa) {
        if (buscarPorPlaca(placa)) {
            Nodo temp = inicio;
            boolean bandera = true;
            while (bandera) {
                if (temp.getValor().getPlaca().equals(placa)) {
                    break;
                } else {
                    temp = temp.getSiguiente();
                }
            }
            String m = "Nombre del dueño del vehiculo: " + temp.getValor().getNombreD() + "\n"
                    + "Tipo del vehiculo: " + temp.getValor().getTipoVeh() + "\n"
                    + "Placa del Vehiculo: " + temp.getValor().getPlaca() + "\n"
                    + "Número del chasis: " + temp.getValor().getNumChasis() + "\n"
                    + "Número del motor: " + temp.getValor().getNumMotor() + "\n"
                    + "Valor de la multa: " + temp.getValor().getValorMulta() + "\n"
                    + "Tipo de multa: " + temp.getValor().getTipoMulta() + "\n"
                    + "Fecha: " + temp.getValor().getFecha();
            JOptionPane.showMessageDialog(null, m);

        } else {
            JOptionPane.showMessageDialog(null, "El vehiculo con la placa " + placa + " no está en la lista");
        }
    }

    public void eliminarTodos() {
        inicio = null;
        tam = 0;
    }
}
