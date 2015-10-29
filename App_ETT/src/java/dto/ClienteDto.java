package dto;

import java.util.Objects;

public class ClienteDto {
    private String rut;
    private String nombre;
    private String direccion;
    private String telefono;

    public ClienteDto() {
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ClienteDto{" + "rut=" + rut + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.rut);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteDto other = (ClienteDto) obj;
        if (!Objects.equals(this.rut, other.rut)) {
            return false;
        }
        return true;
    }
    
    
}
