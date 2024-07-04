public class Recompensa {
    private String descripcion;
    private int puntosNecesarios;

    public Recompensa(String descripcion, int puntosNecesarios) {
        this.descripcion = descripcion;
        this.puntosNecesarios = puntosNecesarios;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPuntosNecesarios() {
        return puntosNecesarios;
    }

    @Override
    public String toString() {
        return "Recompensa{" + "descripcion=" + descripcion +  ", puntosNecesarios=" + puntosNecesarios ;
    }
}
