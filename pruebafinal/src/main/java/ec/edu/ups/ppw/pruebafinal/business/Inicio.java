package ec.edu.ups.ppw.pruebafinal.business;

import java.util.List;

import ec.edu.ups.ppw.pruebafinal.dao.ConsumoDAO;
import ec.edu.ups.ppw.pruebafinal.model.Consumo;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class Inicio {

    @Inject
    private ConsumoDAO daoConsumo;

    @PostConstruct
    public void init() {
        System.out.println("Hola Mundo EJB");

        // Crear y guardar consumos
        Consumo consumo1 = new Consumo();
        consumo1.setId(1);
        consumo1.setCedula("1450170350");
        consumo1.setConsumo(120.5);
        consumo1.setDeuda(30.0);
        daoConsumo.insert(consumo1);

        Consumo consumo2 = new Consumo();
        consumo2.setId(2);
        consumo2.setCedula("1450170351");
        consumo2.setConsumo(80.0);
        consumo2.setDeuda(0.0);
        daoConsumo.insert(consumo2);

        Consumo consumo3 = new Consumo();
        consumo3.setId(3);
        consumo3.setCedula("1450170352");
        consumo3.setConsumo(150.0);
        consumo3.setDeuda(50.0);
        daoConsumo.insert(consumo3);

        // Imprimir datos de consumos
        System.out.println("DATOS DE CONSUMO");
        List<Consumo> consumos = daoConsumo.getAll();
        for (Consumo c : consumos) {
            System.out.println("ID: " + c.getId() + " Cedula: " + c.getCedula() + " Consumo: " + c.getConsumo() + " Deuda: " + c.getDeuda());
        }
    }
}
