package tarjetas.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tarjetas.modelos.entidades.Response;
import tarjetas.modelos.entidades.Tarjeta;
import tarjetas.modelos.servicios.IServicios;

import java.util.List;

@RestController
@RequestMapping("api/v1/tarjeta")
@CrossOrigin("*")
public class TarjetaControlador {
    @Autowired
    private IServicios iServicios;

    @GetMapping("/lista")
    public ResponseEntity<List<Tarjeta>> lista(){
        var result= iServicios.findall();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/Guardar")
    public ResponseEntity<Response> save(@RequestBody Tarjeta tarjeta){
        Response response = new Response();
        int result= iServicios.save(tarjeta);
        if (result==1){
            response.setMessage("Completado con exito");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/Modificar")
    public ResponseEntity<Response> update(@RequestBody Tarjeta tarjeta){
        Response response = new Response();
        int result= iServicios.update(tarjeta);
        if (result==1){
            response.setMessage("Modificacion exitosa");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/Eliminar")
    public ResponseEntity<Response> delete(@PathVariable int id){
        Response response = new Response();
        int result= iServicios.delete(id);
        if (result==1){
            response.setMessage("Se elimino con exito");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
