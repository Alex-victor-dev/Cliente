package br.com.credysystem.clientecartoes.cartao.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.credysystem.clientecartoes.cartao.domain.Cartao;

public interface CartaoRepository {

	Cartao criaCartao(Cartao cartao);

	List<Cartao> buscaCartaoDosClientes(UUID idCliente);

	Cartao buscaCartaoDoClientePorId(UUID idCartao);

	void deletaCartao(Cartao cartao);

}
