package br.com.credysystem.clientecartoes.cliente.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import br.com.credysystem.clientecartoes.cliente.application.service.ClienteService;
import br.com.credysystem.clientecartoes.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
@Validated
public class ClienteController implements ClienteAPI {

	private final ClienteService clienteService;

	@Override
	public ClienteResponse criaCliente(@Valid ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteController - criaCliente");
		ClienteResponse clienteCriado = clienteService.criaCliente(clienteRequest);
		log.info("[finaliza] ClienteController - criaCliente");
		return clienteCriado;

	}

	@Override
	public List<ClienteListResponse> getCliente() {
		log.info("[inicia] ClienteController - getCliente");
		List<ClienteListResponse> listaCliente = clienteService.buscaListaDeClientes();
		log.info("[finaliza] ClienteController - getCliente");
		return listaCliente;
	}

	@Override
	public ClienteDetalhadoResponse getClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteController - getClientePorId");
		Cliente cliente = clienteService.buscaClienteAtravesId(idCliente);
		log.info("[finaliza] ClienteController - getClientePorId");
		return new ClienteDetalhadoResponse(cliente);
	}

	@Override
	public void deletaClientePorID(UUID idCliente) {
		log.info("[inicia] ClienteController - deletaClientePorID");
		clienteService.deletaClientePorId(idCliente);
		log.info("[finaliza] ClienteController - deletaClientePorID");

	}

	@Override
	public void alteraClientePorId(UUID idCliente, @Valid ClienteAlteracaoRequest clienteAlteracaoRequest) {
		log.info("[inicia] ClienteController - alteraClientePorId");
		clienteService.alteraClientePorId(idCliente,clienteAlteracaoRequest);
		log.info("[finaliza] ClienteController - alteraClientePorId");

	}

}
