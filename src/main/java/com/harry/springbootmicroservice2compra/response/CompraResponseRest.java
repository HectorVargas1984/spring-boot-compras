package com.harry.springbootmicroservice2compra.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompraResponseRest extends ResponseRest {

    private CompraResponse compraResponse = new CompraResponse();
}
