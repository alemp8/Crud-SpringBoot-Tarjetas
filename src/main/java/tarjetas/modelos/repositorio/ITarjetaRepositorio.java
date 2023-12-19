package tarjetas.modelos.repositorio;

import tarjetas.modelos.entidades.Tarjeta;

import java.util.List;

public interface ITarjetaRepositorio {

    public List<Tarjeta> findAll();
    public int save(Tarjeta tarjeta);
    public int update(Tarjeta tarjeta);
    int delete(int id);
}
