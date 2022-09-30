package br.com.credysystem.clientecartoes.cliente.application.api;

import java.time.LocalDate;

import lombok.Value;

@Value
public class ClienteAlteracaoRequest {

	private String nomeCompleto;
	private String email;
	private String celular;
	private String telefone;
	private LocalDate dataNascimento;
	private String cpf;
	private Integer salario;
}
