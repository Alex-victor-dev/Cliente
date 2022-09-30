package br.com.credysystem.clientecartoes.cartao.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.credysystem.clientecartoes.cartao.domain.Bandeira;
import br.com.credysystem.clientecartoes.cartao.domain.Cartao;
import lombok.Value;

@Value
public class CartaoClienteListResponse {

	private UUID idCartao;
	private Double limiteTotal;
	private Bandeira bandeiraCartao;

	public static List<CartaoClienteListResponse> converte(List<Cartao> cartao) {
		return cartao.stream().map(CartaoClienteListResponse::new).collect(Collectors.toList());

	}

	public CartaoClienteListResponse(Cartao cartao) {
		this.idCartao = cartao.getIdCartao();
		this.limiteTotal = cartao.getLimiteTotal();
		this.bandeiraCartao = cartao.getBandeiraCartao();
	}

}