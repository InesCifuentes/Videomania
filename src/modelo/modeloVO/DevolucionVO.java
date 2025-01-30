package modelo.modeloVO;

public class DevolucionVO {
    private int idDevolucion;
    private int idAlquiler;
    private String fechaDevolucion;

    public DevolucionVO(int idDevolucion, int idAlquiler, String fechaDevolucion) {
        this.idDevolucion = idDevolucion;
        this.idAlquiler = idAlquiler;
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(int idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
