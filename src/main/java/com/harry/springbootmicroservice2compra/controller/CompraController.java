package com.harry.springbootmicroservice2compra.controller;

import com.harry.springbootmicroservice2compra.model.Compra;
import com.harry.springbootmicroservice2compra.response.CompraResponseRest;
import com.harry.springbootmicroservice2compra.service.ICompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v2/compra")
public class CompraController {

    private final ICompraService compraService;

    public CompraController(ICompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public ResponseEntity<CompraResponseRest> saveCompra(@RequestBody Compra compra){
        return compraService.saveCompra(compra);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CompraResponseRest> findCompraOfUserId(@PathVariable Long userId){
        return compraService.findAllCompraOfUser(userId);
    }


}
