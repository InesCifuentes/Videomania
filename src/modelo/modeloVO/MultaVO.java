package modelo.modeloVO;

public class MultaVO {
    private int idMulta;
    private int idAlquiler;
    private double cantidad;

    public MultaVO(int idMulta, int idAlquiler, double cantidad) {
        this.idMulta = idMulta;
        this.idAlquiler = idAlquiler;
        this.cantidad = cantidad;
    }

    public int getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(int idMulta) {
        this.idMulta = idMulta;
    }

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}