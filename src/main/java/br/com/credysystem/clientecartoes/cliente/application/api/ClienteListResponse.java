package br.com.credysystem.clientecartoes.cliente.application.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.credysystem.clientecartoes.cliente.domain.Cliente;
import br.com.credysystem.clientecartoes.cliente.domain.Sexo;
import lombok.Getter;

@Getter
public class ClienteListResponse {

	private UUID idCliente;
	private String nomeCompleto;
	private String email;
	private Sexo sexo;
	private Boolean aceitaTermos;
	private LocalDateTime dataHoraDoCadastro;

	public static List<ClienteListResponse> converte(List<Cliente> listaTodos) {

		return listaTodos.stream()
			.map(ClienteListResponse::new)
				.collect(Collectors.toList());

	}

	public ClienteListResponse(Cliente cliente) {
		this.idCliente = cliente.getIdCliente();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.email = cliente.getEmail();
		this.sexo = cliente.getSexo();
		this.aceitaTermos = cliente.getAceitaTermos();
		this.dataHoraDoCadastro = cliente.getDataHoraDoCadastro();
	}

}
