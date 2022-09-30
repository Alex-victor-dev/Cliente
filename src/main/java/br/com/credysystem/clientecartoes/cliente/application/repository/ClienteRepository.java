package br.com.credysystem.clientecartoes.cliente.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.credysystem.clientecartoes.cliente.domain.Cliente;

public interface ClienteRepository {

	Cliente salva(Cliente cliente);

	List<Cliente> buscaTodosClientes();

	Cliente buscaClienteAtravesId(UUID idCliente);

	void deletaClientePorId(Cliente cliente);

}
