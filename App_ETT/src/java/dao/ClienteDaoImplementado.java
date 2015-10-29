package dao;

import dto.ClienteDto;
import dto.ReservaDto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import sql.Conexion;

public class ClienteDaoImplementado
        implements ClienteDao {

    @Override
    public List<ClienteDto> listarTodosLosClientes() {
        List<ClienteDto> lista = null;
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM CLIENTE ";
            PreparedStatement buscar
                    = conexion.prepareStatement(query);
            ResultSet rs = buscar.executeQuery();

            lista = new ArrayList<ClienteDto>();

            while (rs.next()) {
                ClienteDto dto = new ClienteDto();
                dto.setRut(rs.getString("rut"));
                dto.setNombre(rs.getString("nombre"));
                dto.setDireccion(rs.getString("direccion"));
                dto.setTelefono(rs.getString("telefono"));
                lista.add(dto);
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
        return lista;
    }

    @Override
    public boolean existeCliente(String rut) {
        boolean resp = false;
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM CLIENTE "
                    + "WHERE rut=?";
            PreparedStatement buscar
                    = conexion.prepareStatement(query);
            buscar.setString(1, rut);
            ResultSet rs = buscar.executeQuery();
            if (rs.next()) {
                resp = true;
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

    @Override
    public boolean agregar(ClienteDto dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO Cliente("
                    + "rut, nombre, direccion ,"
                    + " telefono) VALUES(?,?,?,?)";
            PreparedStatement insertar
                    = conexion.prepareStatement(query);
            insertar.setString(1, dto.getRut());
            insertar.setString(2, dto.getNombre());
            insertar.setString(3, dto.getDireccion());
            insertar.setString(4, dto.getTelefono());
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
    public boolean eliminar(ClienteDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(ClienteDto dto) {
        try {
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE Cliente SET nombre=?,"
                    + " direccion=?, telefono=? "
                    + "WHERE rut=?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setString(1, dto.getNombre());
            buscar.setString(2, dto.getDireccion());
            buscar.setString(3, dto.getTelefono());
            buscar.setString(4, dto.getRut());
            buscar.executeUpdate();
            buscar.close();
            conexion.close();
            return true;
        } catch (SQLException w) {
            System.out.println("Error SQL al "
                    + " modificar " + w.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al "
                    + " modificar " + e.getMessage());
            return false;
        }
    }

    @Override
    public ClienteDto buscarPorID(String id) {
        ClienteDto dto = null;
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM Cliente"
                    + " WHERE rut=?";
            PreparedStatement buscar
                    = conexion.prepareStatement(query);
            buscar.setString(1, id);
            ResultSet rs = buscar.executeQuery();
            if (rs.next()) {
                dto = new ClienteDto();
                dto.setRut(rs.getString("rut"));
                dto.setNombre(rs.getString("nombre"));
                dto.setTelefono(rs.getString("telefono"));
                dto.setDireccion(rs.getString("direccion"));
            }

            buscar.close();
            conexion.close();
        } catch (SQLException w) {
            System.out.println("Error SQL al "
                    + " buscar " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al "
                    + " buscar " + e.getMessage());
        }
        return dto;
    }

    /**Este método retornará TODOS los rut 
     * de clientes ordenados ascendentemente   */
    public ArrayList<String> rutClientes(){
        ArrayList<String> lista= new ArrayList<String>();
        try{
         Connection conexion=Conexion.getConexion();
         String query="SELECT rut as rutCliente FROM "
                 + "Cliente ORDER BY rut ASC";
         PreparedStatement buscar=
                 conexion.prepareStatement(query);
         ResultSet rs=buscar.executeQuery();
         while(rs.next()){
             lista.add(rs.getString("rutCliente"));
         }
         buscar.close();
         conexion.close();
        } catch (SQLException w) {
            System.out.println("Error SQL al "
                    + " buscar " + w.getMessage());
        } catch (Exception e) {
            System.out.println("Error al "
                    + " buscar " + e.getMessage());
        }
        return lista;
    }
    
}
