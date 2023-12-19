package tarjetas.modelos.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tarjetas.modelos.entidades.Tarjeta;
import tarjetas.modelos.repositorio.ITarjetaRepositorio;

import java.util.List;

@Service
public class Servicios implements IServicios{

    @Autowired
    private ITarjetaRepositorio iTarjetaRepositorio;

    @Override
    public List<Tarjeta> findall() {
       List<Tarjeta> lista;
       try {
           lista = iTarjetaRepositorio.findAll();
       } catch (Exception e){
          throw e;
       }
       return lista;
    }

    @Override
    public int save(Tarjeta tarjeta) {
        int row;
        try {
            row= iTarjetaRepositorio.save(tarjeta);
        } catch (Exception e){
            throw e;
        }
        return row;
    }

    @Override
    public int update(Tarjeta tarjeta) {
        int row;
        try {
            row= iTarjetaRepositorio.update(tarjeta);
        } catch (Exception e){
            throw e;
        }
        return row;
    }

    @Override
    public int delete(int id) {
        int row;
        try {
            row= iTarjetaRepositorio.delete(id);
        } catch (Exception e){
            throw e;
        }
        return row;
    }
}
