package com.harry.springbootmicroservice2compra.response;

import com.harry.springbootmicroservice2compra.model.Compra;
import lombok.Data;

import java.util.List;

@Data
public class CompraResponse{
    List<Compra> compras;
}
