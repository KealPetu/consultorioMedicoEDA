package backend;

import java.io.Serializable;
import java.util.Stack;

public class ArregloDePilasDeCitas implements Serializable {
    private final int DIA = 30;
    private final int MES = 12;
    private final int AÑO = 5;
    private Stack<Cita>[][][] arregloDeStacksDeCitas = new Stack[DIA][MES][AÑO];

    public void agregarCita(Cita nuevaCita, int dia, int mes, int año){

        try{
            arregloDeStacksDeCitas[dia][mes][año].push(nuevaCita);
        } catch (NullPointerException e){
            arregloDeStacksDeCitas[dia][mes][año] = new Stack<Cita>();
            arregloDeStacksDeCitas[dia][mes][año].push(nuevaCita);
        }
    }

    public Stack<Cita> getCitas(int dia, int mes, int año) {
        return arregloDeStacksDeCitas[dia][mes][año];
    }
}
