package modelo.modeloVO;

public class ProductoVO {
    private String nombreProducto;
    private String categoria;
    private String genero;
    private int pegi;
    private double precio;

    public ProductoVO(String nombreProducto, String categoria, String genero, int pegi, double precio) {
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.genero = genero;
        this.pegi = pegi;
        this.precio = precio;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPegi() {
        return pegi;
    }

    public void setPegi(int pegi) {
        this.pegi = pegi;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
