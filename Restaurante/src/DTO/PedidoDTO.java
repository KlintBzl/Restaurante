
package DTO;

import java.sql.Date;

public class PedidoDTO {
    private int id, idC;
    private String data;
    private double valorTotal;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdC() {
        return idC;
    }
    public void setIdC(int idC) {
        this.idC = idC;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    
    
}
