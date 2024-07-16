package ec.edu.ups.ppw.pruebafinal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_CONSUMO")
public class Consumo {

    @Id
    @Column(name = "consumo_id")
    private int id;

    @Column(name = "consumo_cedula")
    private String cedula;

    @Column(name = "consumo_valor")
    private double consumo;

    @Column(name = "consumo_deuda")
    private double deuda;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

    @Override
    public String toString() {
        return "Consumo [id=" + id + ", cedula=" + cedula + ", consumo=" + consumo + ", deuda=" + deuda + "]";
    }
}