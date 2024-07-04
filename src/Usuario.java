public abstract class Usuario {
    private String nombre;
    private String id;

    public Usuario(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre +  ", id=" + id ;
    }
}
