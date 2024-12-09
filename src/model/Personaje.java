package model;

public class Personaje {
    private String nombre;
    private String tipoElemental;

    public Personaje(String nombre, String tipoElemental) {
        this.nombre = nombre;
        this.tipoElemental = tipoElemental;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoElemental() {
        return tipoElemental;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", tipoElemental='" + tipoElemental + '\'' +
                '}';
    }
}
