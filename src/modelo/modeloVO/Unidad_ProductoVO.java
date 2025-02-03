package modelo.modeloVO;

public class Unidad_ProductoVO {
    private int id;
    private String nombreProducto;
    private Integer idAlquiler;
    private String estado;

    public Unidad_ProductoVO(int id, String nombreProducto, Integer idAlquiler, String estado) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.idAlquiler = idAlquiler;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(Integer idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
