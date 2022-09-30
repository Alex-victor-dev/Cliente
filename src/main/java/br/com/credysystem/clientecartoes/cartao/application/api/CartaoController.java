package br.com.credysystem.clientecartoes.cartao.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.credysystem.clientecartoes.cartao.application.service.CartaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class CartaoController implements CartaoAPI {

	private final CartaoService cartaoService;

	@Override
	public CartaoResponse criaCartao(UUID idCliente, @Valid CartaoRequest cartaoRequest) {
		log.info("[inicia] CartaoController - criaCartao");
		log.info("[idCliente]{}", idCliente);
		CartaoResponse cartaoCriado = cartaoService.criaCartao(idCliente, cartaoRequest);
		log.info("[finaliza] CartaoController - criaCartao");
		return cartaoCriado;
	}

	@Override
	public List<CartaoClienteListResponse> listaCartaoDosClientes(UUID idCliente) {
		log.info("[inicia] CartaoController - listaCartaoDosClientes");
		log.info("[idCliente]{}", idCliente);
		List<CartaoClienteListResponse> cartaoList = cartaoService.buscaCartaoDosClientes(idCliente);
		log.info("[finaliza] CartaoController - listaCartaoDosClientes");
		return cartaoList;
	}

	@Override
	public CartaoClienteDetalhadoResponse listaCartaoDetalhadamente(UUID idCliente, UUID idCartao) {
		log.info("[inicia] CartaoController - listaCartaoDosClientes");
		log.info("[idCliente] {} - [idCartao] {}", idCliente, idCartao);
		CartaoClienteDetalhadoResponse cartao = cartaoService.buscaCartaoDoClientePorId(idCliente, idCartao);
		log.info("[finaliza] CartaoController - listaCartaoDosClientes");
		return cartao;
	}

	@Override
	public void deletaCartaoDosClientesPorId(UUID idCliente, UUID idCartao) {
		log.info("[inicia] CartaoController - deletaCartaoDosClientesPorId");
		log.info("[idCliente] {} - [idCartao] {}", idCliente, idCartao);
		cartaoService.deletaCartaoDoCliente(idCliente, idCartao);
		log.info("[finaliza] CartaoController - deletaCartaoDosClientesPorId");

	}

}
