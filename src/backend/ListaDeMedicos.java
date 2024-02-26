package backend;

import java.util.ArrayList;

public class ListaDeMedicos extends ArrayList<Medico>{
    public void agregarMedico(Medico medico){
        this.add(medico);
    }

    public void eliminarMedico(Medico medico){
        this.remove(medico);
    }

    public boolean buscarMedico(Medico medico){
        return this.contains(medico);
    }
}
