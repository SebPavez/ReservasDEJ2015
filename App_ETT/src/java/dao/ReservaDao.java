package dao;

import java.util.List;
import dto.ReservaDto;

//OJO aqui "aterrizamos" el generics a forma del este DAO,
//es decir, en simples palabras "la T adopta el valor de la clase"
public interface ReservaDao extends BaseDao<ReservaDto>{
    public List<ReservaDto> buscarEntreFechas(
    java.util.Date desde,  java.util.Date hasta);

    public ReservaDto buscarPorID(Integer id);
    
    public boolean existeReserva(Integer id);
}

