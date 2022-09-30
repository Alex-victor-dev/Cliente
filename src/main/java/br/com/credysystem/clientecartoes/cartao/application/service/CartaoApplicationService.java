package br.com.credysystem.clientecartoes.cartao.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.credysystem.clientecartoes.cartao.application.api.CartaoClienteDetalhadoResponse;
import br.com.credysystem.clientecartoes.cartao.application.api.CartaoClienteListResponse;
import br.com.credysystem.clientecartoes.cartao.application.api.CartaoRequest;
import br.com.credysystem.clientecartoes.cartao.application.api.CartaoResponse;
import br.com.credysystem.clientecartoes.cartao.application.repository.CartaoRepository;
import br.com.credysystem.clientecartoes.cartao.domain.Cartao;
import br.com.credysystem.clientecartoes.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class CartaoApplicationService implements CartaoService {

	private final ClienteService clienteService;
	private final CartaoRepository cartaoRepository;

	@Override
	public CartaoResponse criaCartao(UUID idCliente, CartaoRequest cartaoRequest) {
		log.info("[start] CartaoApplicationService - criaCartao");
		clienteService.buscaClienteAtravesId(idCliente).getSalario();
		Cartao cartao = cartaoRepository.criaCartao(new Cartao(idCliente, cartaoRequest));
		log.info("[finish] CartaoApplicationService - criaCartao");
		return new CartaoResponse(cartao.getIdCartao());
	}

	@Override
	public List<CartaoClienteListResponse> buscaCartaoDosClientes(UUID idCliente) {
		log.info("[start] CartaoApplicationService - buscaCartaoDosClientes");
		clienteService.buscaClienteAtravesId(idCliente);
		List<Cartao> cartao = cartaoRepository.buscaCartaoDosClientes(idCliente);
		log.info("[finish] CartaoApplicationService - buscaCartaoDosClientes");
		return CartaoClienteListResponse.converte(cartao);
	}

	@Override
	public CartaoClienteDetalhadoResponse buscaCartaoDoClientePorId(UUID idCliente, UUID idCartao) {
		log.info("[start] CartaoApplicationService - buscaCartaoDoClientePorId");
		clienteService.buscaClienteAtravesId(idCliente);
		Cartao cartao = cartaoRepository.buscaCartaoDoClientePorId(idCartao);
		log.info("[finish] CartaoApplicationService - buscaCartaoDoClientePorId");
		return new CartaoClienteDetalhadoResponse(cartao);
	}

	@Override
	public void deletaCartaoDoCliente(UUID idCliente, UUID idCartao) {
		log.info("[start] CartaoApplicationService - deletaCartaoDoCliente");
		clienteService.buscaClienteAtravesId(idCliente);
		Cartao cartao = cartaoRepository.buscaCartaoDoClientePorId(idCartao);
		cartaoRepository.deletaCartao(cartao);
		log.info("[finish] CartaoApplicationService - deletaCartaoDoCliente");

	}

}
