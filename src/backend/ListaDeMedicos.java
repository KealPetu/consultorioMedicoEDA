package backend;

import java.io.Serializable;
import java.util.Hashtable;

public class ListaDeMedicos extends Hashtable<String, Medico> implements Serializable {
        public void agregarMedico(String cedula, Medico medico){
            this.put(cedula, medico);
        }

        public void eliminarMedico(String cedula){
            this.remove(cedula);
        }

        public Medico buscarMedico(String cedula){
            return this.get(cedula);
        }

        public boolean existeMedicoConCedula(String cedula){
            return this.containsKey(cedula);
        }


}
