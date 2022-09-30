package br.com.credysystem.clientecartoes.cliente.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.credysystem.clientecartoes.cliente.application.repository.ClienteRepository;
import br.com.credysystem.clientecartoes.cliente.domain.Cliente;
import br.com.credysystem.clientecartoes.cliente.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {

	private final ClienteSpringDataJpaRepository clienteSpringDataJpaRepository;

	@Override
	public Cliente salva(Cliente cliente) {
		log.info("[inicia] ClienteInfraRepository - salva");
		clienteSpringDataJpaRepository.save(cliente);
		log.info("[finaliza] ClienteInfraRepository - salva");
		return cliente;
	}

	@Override
	public List<Cliente> buscaTodosClientes() {
		log.info("[inicia] ClienteInfraRepository - buscaTodosClientes");
		List<Cliente> cliente = clienteSpringDataJpaRepository.findAll();
		log.info("[finaliza] ClienteInfraRepository - buscaTodosClientes");
		return cliente;
	}

	@Override
	public Cliente buscaClienteAtravesId(UUID idCliente) {
		log.info("[inicia] ClienteInfraRepository - buscaClienteAtravesId");
		Cliente cliente = clienteSpringDataJpaRepository.findById(idCliente).orElseThrow(
				() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente nao encontrado id nao Existe " + idCliente));
		log.info("[finaliza] ClienteInfraRepository - buscaClienteAtravesId");
		return cliente;
	}

	@Override
	public void deletaClientePorId(Cliente cliente) {
		log.info("[inicia] ClienteInfraRepository - deletaClientePorId");
		clienteSpringDataJpaRepository.delete(cliente);
		log.info("[inicia] ClienteInfraRepository - deletaClientePorId");

	}

}
