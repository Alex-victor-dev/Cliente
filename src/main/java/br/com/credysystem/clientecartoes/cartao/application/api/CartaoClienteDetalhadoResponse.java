package br.com.credysystem.clientecartoes.cartao.application.api;

import java.util.UUID;

import br.com.credysystem.clientecartoes.cartao.domain.Bandeira;
import br.com.credysystem.clientecartoes.cartao.domain.Cartao;
import lombok.Value;

@Value
public class CartaoClienteDetalhadoResponse {

	private UUID idCartao;
	private Bandeira bandeiraCartao;
	private Double limiteTotal;
	private String numeroCartao;

	public CartaoClienteDetalhadoResponse(Cartao cartao) {

		this.idCartao = cartao.getIdCartao();
		this.bandeiraCartao = cartao.getBandeiraCartao();
		this.limiteTotal = cartao.getLimiteTotal();
		this.numeroCartao = cartao.getNumeroCartao();

	}

}
