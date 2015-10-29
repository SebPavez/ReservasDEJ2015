package dto;
import java.util.Date;
import java.util.Objects;
public class ReservaDto {
    private Integer codReserva;
    private String clienteRut;
    private Date fechaInicio;
    private Date fechaEntrega;
    private Integer litrosBencina;

    public ReservaDto() {
    }

    public Integer getCodReserva() {
        return codReserva;
    }

    public void setCodReserva(Integer codReserva) {
        this.codReserva = codReserva;
    }

    public String getClienteRut() {
        return clienteRut;
    }

    public void setClienteRut(String clienteRut) {
        this.clienteRut = clienteRut;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Integer getLitrosBencina() {
        return litrosBencina;
    }

    public void setLitrosBencina(Integer litrosBencina) {
        this.litrosBencina = litrosBencina;
    }

    @Override
    public String toString() {
        return "ReservaDto{" + "codReserva=" + codReserva + ", clienteRut=" + clienteRut + ", fechaInicio=" + fechaInicio + ", fechaEntrega=" + fechaEntrega + ", litrosBencina=" + litrosBencina + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.codReserva);
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
        final ReservaDto other = (ReservaDto) obj;
        if (!Objects.equals(this.codReserva, other.codReserva)) {
            return false;
        }
        return true;
    }
    
    
}
