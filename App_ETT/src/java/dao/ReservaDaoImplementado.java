package dao;

import dto.ClienteDto;
import dto.ReservaDto;
import sql.Conexion;
import java.sql.*;  //-->incluye java.sql.Date
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class ReservaDaoImplementado implements ReservaDao {

    @Override
    public List<ReservaDto> buscarEntreFechas(Date desde, Date hasta) {
        List<ReservaDto> lista = new ArrayList<ReservaDto>();
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM RESERVA "
                    + " WHERE fecha_inicio BETWEEN ? AND ?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setDate(1, new java.sql.Date(desde.getTime()));
            buscar.setDate(2, new java.sql.Date(hasta.getTime()));
            ResultSet rs = buscar.executeQuery();
            while (rs.next()) {
                ReservaDto dto = new ReservaDto();
                dto.setCodReserva(rs.getInt("codreserva"));
                dto.setFechaInicio(rs.getDate("fecha_inicio"));
                dto.setFechaEntrega(rs.getDate("fecha_entrega"));
                dto.setLitrosBencina(rs.getInt("litros_bencina"));
                dto.setClienteRut(rs.getString("cliente_rut"));
                lista.add(dto);
            }
            buscar.close();
            conexion.close();
        } catch (SQLException w) {
            System.out.println("Error SQL al "
                    + "agregar " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al "
                    + "agregar " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean agregar(ReservaDto dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO RESERVA("
                    + "codReserva,fecha_inicio,"
                    + "fecha_entrega,litros_bencina,"
                    + "cliente_rut) VALUES(?,?,?,?,?)";
            PreparedStatement insertar
                    = conexion.prepareStatement(query);
            insertar.setInt(1, dto.getCodReserva());
            //crearemos un objeto java.sql.Date
            //con el java.util.Date que llega del dto
            insertar.setDate(2, new java.sql.Date(
                    dto.getFechaInicio().getTime()));
            insertar.setDate(3, new java.sql.Date(
                    dto.getFechaEntrega().getTime()));
            insertar.setInt(4, dto.getLitrosBencina());
            insertar.setString(5, dto.getClienteRut());
            insertar.execute();
            insertar.close();
            conexion.close();
            return true;
        } catch (SQLException w) {
            System.out.println("Error SQL al "
                    + "agregar " + w.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al "
                    + "agregar " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(ReservaDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(ReservaDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReservaDto buscarPorID(Integer id) {
        ReservaDto dto = null;
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM Reserva"
                    + " WHERE codReserva=?";
            PreparedStatement buscar
                    = conexion.prepareStatement(query);
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();
            if (rs.next()) {
                dto = new ReservaDto();
                dto.setCodReserva(rs.getInt("codReserva"));
                dto.setFechaInicio(rs.getDate("fecha_inicio"));
                dto.setFechaEntrega(rs.getDate("fecha_entrega"));
                dto.setLitrosBencina(rs.getInt("litros_bencina"));
                dto.setClienteRut(rs.getString("cliente_rut"));
            }

            buscar.close();
            conexion.close();
        } catch (SQLException w) {
            System.out.println("Error SQL al "
                    + " listar " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al "
                    + " listar " + e.getMessage());
        }
        return dto;
    }

    @Override
    public boolean existeReserva(Integer id) {
        boolean resp=false;
       try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM Reserva "
                    + "WHERE codReserva=?";
            PreparedStatement buscar
                    = conexion.prepareStatement(query);
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();
            if (rs.next()) {
                resp=true;
            }
            buscar.close();
            conexion.close();
            return resp;
        } catch (SQLException w) {
            System.out.println("Error SQL al "
                    + " listar " + w.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al "
                    + " listar " + e.getMessage());
            return false;
        }
    }

}
