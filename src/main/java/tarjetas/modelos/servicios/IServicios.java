package tarjetas.modelos.servicios;

import tarjetas.modelos.entidades.Tarjeta;

import java.util.List;

public interface IServicios {
    //El service interactua con el controlador
    public List<Tarjeta> findall();
    public int save (Tarjeta tarjeta);
    public int update (Tarjeta tarjeta);
    public int delete(int id);
}
