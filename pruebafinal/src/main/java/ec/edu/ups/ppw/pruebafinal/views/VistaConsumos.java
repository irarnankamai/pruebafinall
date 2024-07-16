package ec.edu.ups.ppw.pruebafinal.views;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.ppw.pruebafinal.business.ConsumoGestion;
import ec.edu.ups.ppw.pruebafinal.model.Consumo;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("consumos")
@RequestScoped
public class VistaConsumos implements Serializable {
    @Inject
    private ConsumoGestion consumoGestion;

    private Consumo consumo = new Consumo();
    private List<Consumo> listado;
    private String cedulaBusqueda;

    @PostConstruct
    public void init() {
        listado = consumoGestion.getConsumos();
    }

    public List<Consumo> getListado() {
        return listado;
    }

    public void setListado(List<Consumo> listado) {
        this.listado = listado;
    }

    public Consumo getConsumo() {
        return consumo;
    }

    public void setConsumo(Consumo consumo) {
        this.consumo = consumo;
    }

    public String getCedulaBusqueda() {
        return cedulaBusqueda;
    }

    public void setCedulaBusqueda(String cedulaBusqueda) {
        this.cedulaBusqueda = cedulaBusqueda;
    }

    public String buscarPorCedula() {
        listado = consumoGestion.obtenerConsumosPorCedula(cedulaBusqueda);
        return null; 
    }

    public String guardar() {
        try {
            if (consumo.getId() == 0) {
                consumoGestion.createConsumo(consumo);
            } else {
                consumoGestion.updateConsumo(consumo);
            }
            consumo = new Consumo(); 
            return "listadoconsumos.xhtml?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    public String eliminar(int id) {
        try {
            consumoGestion.deleteConsumo(id);
            return "listadoconsumos.xhtml?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    public String retroceder() {
        return "formulario.xhtml?faces-redirect=true";
    }

    public String editar(Consumo consumo) {
        this.consumo = consumo; 
        return null; 
    }
}
