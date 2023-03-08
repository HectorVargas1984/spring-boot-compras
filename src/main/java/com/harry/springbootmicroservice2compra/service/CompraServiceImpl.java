package com.harry.springbootmicroservice2compra.service;

import com.harry.springbootmicroservice2compra.model.Compra;
import com.harry.springbootmicroservice2compra.repository.CompraRepository;
import com.harry.springbootmicroservice2compra.response.CompraResponseRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompraServiceImpl implements ICompraService {

    private final CompraRepository compraRepository;

    public CompraServiceImpl(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public ResponseEntity<CompraResponseRest> saveCompra(Compra compra){
        CompraResponseRest response = new CompraResponseRest();
        List<Compra> list = new ArrayList<>();
        compra.setFechaCompra(LocalDateTime.now());

        try {

            Compra compraSave = compraRepository.save(compra);

            if(compraSave != null){
                list.add(compraSave);
                response.getCompraResponse().setCompras(list);
                response.setMetadata("Respuesta ok", "00", "Se a Guardado de forma exitosa");
            }else{
                response.setMetadata("Error en la respuesta", "-1", "Error al guardar la compra");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

        }catch (Exception e){
            response.setMetadata("Respuesta error", "-1", "Error al conectarse a la Base de datos");
            e.getStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CompraResponseRest> findAllCompraOfUser(Long id){

        CompraResponseRest response = new CompraResponseRest();

        try {

            List<Compra> listCompra =(List<Compra>) compraRepository.findAllByUserId(id);

            if(listCompra.size() > 0){

                response.getCompraResponse().setCompras(listCompra);
                response.setMetadata("Respuesta ok", "00", "Se lista de compra con exitosa");
            }else{
                response.setMetadata("Error en la respuesta", "-1", "Error al listara las compras compra");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

        }catch (Exception e){
            response.setMetadata("Respuesta error", "-1", "Error al conectarse a la Base de datos");
            e.getStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

/*
        InmubleResponseRest response = new InmubleResponseRest();
        List<Inmueble> list = new ArrayList<>();

        inmueble.setFechaCreacion(LocalDateTime.now());

        try {
            Inmueble saveInmueble = inmuebleRepository.save(inmueble);

            if (saveInmueble != null) {
                list.add(saveInmueble);
                response.getInmubleResponse().setInmuebles(list);
                response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
            } else {
                response.setMetadata("Error en la respuesta", "-1", "Error al guardar el inmueble");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            response.setMetadata("Respuesta error", "-1", "Error al conectarse a la Base de datos");
            e.getStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
 */
