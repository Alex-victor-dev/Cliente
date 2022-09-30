package br.com.credysystem.clientecartoes.cliente.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.credysystem.clientecartoes.cliente.application.api.ClienteAlteracaoRequest;
import br.com.credysystem.clientecartoes.cliente.application.api.ClienteListResponse;
import br.com.credysystem.clientecartoes.cliente.application.api.ClienteRequest;
import br.com.credysystem.clientecartoes.cliente.application.api.ClienteResponse;
import br.com.credysystem.clientecartoes.cliente.application.repository.ClienteRepository;
import br.com.credysystem.clientecartoes.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Service
@Log4j2
public class ClienteApplicationService implements ClienteService {

	private final ClienteRepository clienteRepository;

	@Override
	public ClienteResponse criaCliente(@Valid ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteApplicationService -  criaCliente");
		Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
		log.info("[finaliza] ClienteApplicationService -  criaCliente");
		return ClienteResponse.builder().idCliente(cliente.getIdCliente()).build();
	}

	@Override
	public List<ClienteListResponse> buscaListaDeClientes() {
		log.info("[inicia] ClienteApplicationService -  buscaListaDeClientes");
		List<Cliente> listaTodos = clienteRepository.buscaTodosClientes();
		log.info("[finaliza] ClienteApplicationService -  buscaListaDeClientes");
		return ClienteListResponse.converte(listaTodos);
	}

	@Override
	public Cliente buscaClienteAtravesId(UUID idCliente) {
		log.info("[inicia] ClienteApplicationService -  buscaClienteAtravesId");
		Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
		log.info("[finaliza] ClienteApplicationService -  buscaClienteAtravesId");
		return cliente;
	}

	@Override
	public void deletaClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteApplicationService -  deletaClientePorId");
		Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
		clienteRepository.deletaClientePorId(cliente);
		log.info("[finaliza] ClienteApplicationService - deletaClientePorId");

	}

	@Override
	public void alteraClientePorId(UUID idCliente, ClienteAlteracaoRequest clienteAlteracaoRequest) {
		log.info("[inicia] ClienteApplicationService - alteraClientePorId");
		Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
		cliente.alteraClientePorId(clienteAlteracaoRequest);
		clienteRepository.salva(cliente);
		log.info("[finaliza] ClienteApplicationService - alteraClientePorId");

		
	}

}
