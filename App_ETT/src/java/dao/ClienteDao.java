package dao;

import dto.ClienteDto;
import java.util.List;

public interface ClienteDao
        extends BaseDao<ClienteDto> {

    public List<ClienteDto> listarTodosLosClientes();
    
    public boolean existeCliente(String rut);
    public ClienteDto buscarPorID(String id);
}
