public class Compra {
    private String idCliente;
    private double monto;
    private String descripcion;

    public Compra(String idCliente, double monto, String descripcion) {
        this.idCliente = idCliente;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Compra{" + "idCliente='" + idCliente  + ", monto=" + monto + ", descripcion='" + descripcion ;
    }
}
