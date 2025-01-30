package modelo.modeloVO;

public class MultaVO {
    private int idMulta;
    private int idAlquiler;

    public MultaVO(int idMulta, int idAlquiler) {
        this.idMulta = idMulta;
        this.idAlquiler = idAlquiler;
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
}
