package br.com.credysystem.clientecartoes.cliente.application.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.credysystem.clientecartoes.cliente.domain.Cliente;
import br.com.credysystem.clientecartoes.cliente.domain.Sexo;
import lombok.Value;

@Value
public class ClienteDetalhadoResponse {

	private UUID idCliente;
	private String nomeCompleto;
	private String email;
	private String telefone;
	private Sexo sexo;
	private LocalDate dataNascimento;
	private String cpf;
	private double salario;
	private LocalDateTime dataHoraDoCadastro;

	public ClienteDetalhadoResponse(Cliente cliente) {
		this.idCliente = cliente.getIdCliente();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.email = cliente.getEmail();
		this.telefone = cliente.getTelefone();
		this.sexo = cliente.getSexo();
		this.dataNascimento = cliente.getDataNascimento();
		this.cpf = cliente.getCpf();
		this.salario = cliente.getSalario();
		this.dataHoraDoCadastro = cliente.getDataHoraDoCadastro();

	}

}
