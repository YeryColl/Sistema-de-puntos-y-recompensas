public class Cliente extends Usuario {
    private int puntos;

    public Cliente(String nombre, String id) {
        super(nombre, id);
        this.puntos = 0;
    }

    public int getPuntos() {
        return puntos;
    }

    public void acumularPuntos(int puntos) {
        this.puntos += puntos*0.01;
    }

    public void redimirPuntos(int puntos) {
        this.puntos -= puntos;
    }

    @Override
    public String toString() {
        return super.toString() + ", puntos=" + puntos;
    }
}
