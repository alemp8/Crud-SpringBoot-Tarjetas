package tarjetas.modelos.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tarjetas.modelos.entidades.Tarjeta;

import java.util.List;

@Repository
public class Implementacion implements ITarjetaRepositorio{
//Inyectamos el jdbc
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Tarjeta> findAll() {
        String SQL= "SELECT * FROM tarjetas WHERE status =1";
        /*retornaremos un query enviando como parametros SQl con una sentencia que nos
        permitira mostrar todos los datos de la base de datos, con el BeanProperty recorre
        todos los atributos de la clase tarjeta y nos devuelve una nueva instancia.
        */
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Tarjeta.class));
    }

    @Override
    public int save(Tarjeta tarjeta) {
        String SQL= "INSERT INTO tarjetas VALUES(?,?,?,?,?)";
        //El object nos permite mapear los atributos que tenemos como parametro de entrada
        return jdbcTemplate.update(SQL,new Object[]{tarjeta.getName(), tarjeta.getNumber(),
                tarjeta.getType(), tarjeta.getCvv(), tarjeta.getStatus()});
    }

    @Override
    public int update(Tarjeta tarjeta) {
        String SQL= "UPDATE tarjetas SET nombre=?, numero=?, tipo=?, cvv=? WHERE id_tarjeta =?";
        //El object nos permite mapear los atributos que tenemos como parametro de entrada
        return jdbcTemplate.update(SQL,new Object[]{tarjeta.getName(), tarjeta.getNumber(),
                tarjeta.getType(), tarjeta.getCvv(), tarjeta.getId_tarjeta()});
    }

    @Override
    public int delete(int id) {
        String SQL= "UPDATE tarjetas SET nombre=1 WHERE id_tarjeta =?";
        return jdbcTemplate.update(SQL,new Object[]{id});
    }
}
