package br.com.credysystem.clientecartoes.cartao.application.api;

import br.com.credysystem.clientecartoes.cartao.domain.Bandeira;
import lombok.Value;

@Value
public class CartaoRequest {

	private Bandeira bandeiraCartao;
	private Double limiteTotal;

}
