package br.com.credysystem.clientecartoes.cliente.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import br.com.credysystem.clientecartoes.cliente.application.api.ClienteAlteracaoRequest;
import br.com.credysystem.clientecartoes.cliente.application.api.ClienteListResponse;
import br.com.credysystem.clientecartoes.cliente.application.api.ClienteRequest;
import br.com.credysystem.clientecartoes.cliente.application.api.ClienteResponse;
import br.com.credysystem.clientecartoes.cliente.domain.Cliente;

public interface ClienteService {

	List<ClienteListResponse> buscaListaDeClientes();

	ClienteResponse criaCliente(@Valid ClienteRequest clienteRequest);

	Cliente buscaClienteAtravesId(UUID idCliente);

	void deletaClientePorId(UUID idCliente);

	void alteraClientePorId(UUID idCliente, @Valid ClienteAlteracaoRequest clienteAlteracaoRequest);

}
