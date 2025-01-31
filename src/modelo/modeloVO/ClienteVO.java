package modelo.modeloVO;

public class ClienteVO extends UsuarioVO {
    private int edad;

    public ClienteVO(String nombre, String password, int edad) {
        super(nombre, password);
        this.edad = edad;
    }
    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}