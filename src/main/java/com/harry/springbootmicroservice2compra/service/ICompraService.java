package com.harry.springbootmicroservice2compra.service;

import com.harry.springbootmicroservice2compra.model.Compra;
import com.harry.springbootmicroservice2compra.response.CompraResponseRest;
import org.springframework.http.ResponseEntity;

public interface ICompraService {
    ResponseEntity<CompraResponseRest> saveCompra(Compra compra);

    ResponseEntity<CompraResponseRest> findAllCompraOfUser(Long id);
}
