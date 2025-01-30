package modelo.modeloVO;

public class AlquilerVO {
    private int idAlquiler;
    private String nombreCliente;
    private String fechaAlquiler;

    public AlquilerVO(int idAlquiler, String nombreCliente, String fechaAlquiler) {
        this.idAlquiler = idAlquiler;
        this.nombreCliente = nombreCliente;
        this.fechaAlquiler = fechaAlquiler;
    }

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(String fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }
}
