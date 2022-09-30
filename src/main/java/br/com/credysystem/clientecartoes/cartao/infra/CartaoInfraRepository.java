package br.com.credysystem.clientecartoes.cartao.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.credysystem.clientecartoes.cartao.application.repository.CartaoRepository;
import br.com.credysystem.clientecartoes.cartao.domain.Cartao;
import br.com.credysystem.clientecartoes.cliente.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@RequiredArgsConstructor
@Log4j2
public class CartaoInfraRepository implements CartaoRepository {

	private final CartaoInfraRepositoryJpa cartaoInfraRepositoryJpa;

	@Override
	public Cartao criaCartao(Cartao cartao) {
		log.info("[start] CartaoInfraRepository - criaCartao");
		cartaoInfraRepositoryJpa.save(cartao);
		log.info("[finish] CartaoInfraRepository - criaCartao");
		return cartao;
	}

	@Override
	public List<Cartao> buscaCartaoDosClientes(UUID idCliente) {
		log.info("[inicia] CartaoInfraRepository - buscaCartaoDosClientes");
		List<Cartao> cartao = cartaoInfraRepositoryJpa.findByIdClienteCartao(idCliente);
		log.info("[finish] CartaoInfraRepository - buscaCartaoDosClientes");
		return cartao;
	}

	@Override
	public Cartao buscaCartaoDoClientePorId(UUID idCartao) {
		log.info("[inicia] CartaoInfraRepository - buscaCartaoDoClientePorId");
		Cartao cartao = cartaoInfraRepositoryJpa.findById(idCartao)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cartao nao encontrado: "));
		return cartao;
	}

	@Override
	public void deletaCartao(Cartao cartao) {
		log.info("[inicia] CartaoInfraRepository - deletaCartao");
		cartaoInfraRepositoryJpa.delete(cartao);
		log.info("[inicia] CartaoInfraRepository - deletaCartao");

	}

}
