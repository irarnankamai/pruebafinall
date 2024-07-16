package ec.edu.ups.ppw.pruebafinal.business;

import java.util.List;

import ec.edu.ups.ppw.pruebafinal.dao.ConsumoDAO;
import ec.edu.ups.ppw.pruebafinal.model.Consumo;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ConsumoGestion {
    
    @Inject
    private ConsumoDAO daoConsumo;
    
    public Consumo getConsumo(int id) throws Exception {
        Consumo consumo = daoConsumo.read(id);
        
        if (consumo == null) 
            throw new Exception("Consumo no existe");
        
        return consumo;
    }
    
    public List<Consumo> getConsumos() {
        return daoConsumo.getAll();
    }

    public void createConsumo(Consumo consumo) throws Exception {
        if (consumo.getCedula().length() != 10) {
            throw new Exception("Cédula incorrecta");
        }
        
        daoConsumo.insert(consumo);
    }

    public void updateConsumo(Consumo consumo) throws Exception {
        if (consumo.getCedula().length() != 10) {
            throw new Exception("Cédula incorrecta");
        }
        
        daoConsumo.update(consumo);
    }

    public void deleteConsumo(int id) throws Exception {
        Consumo consumo = daoConsumo.read(id);

        if (consumo == null) {
            throw new Exception("Consumo no existe");
        }

        daoConsumo.delete(id);
    }

    public List<Consumo> obtenerConsumosPorCedula(String cedula) {
        return daoConsumo.findByCedula(cedula);
    }
}
