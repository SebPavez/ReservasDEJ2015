package dao;

import dto.ReservaDto;
public interface BaseDao <T> {
    //GENERICO!!!! con esto podemos 
    // extender a TODOS los dao (ClienteDao, ReservaDao, etc)
    public boolean agregar(T dto);    
    public boolean eliminar(T dto); 
    //sobrecargamos 
    //public boolean eliminar(int posicion); 

    public boolean modificar(T dto);
    
}
