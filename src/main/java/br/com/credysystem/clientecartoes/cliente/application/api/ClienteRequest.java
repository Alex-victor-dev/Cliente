package br.com.credysystem.clientecartoes.cliente.application.api;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.credysystem.clientecartoes.cliente.domain.Sexo;
import lombok.Getter;

@Getter
public class ClienteRequest {

	private String nomeCompleto;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String celular;
	private String telefone;
	private Sexo sexo;
	@NotNull
	private LocalDate dataNascimento;
	@CPF
	private String cpf;
	private double salario;
	@NotNull
	private Boolean aceitaTermos;
	private LocalDateTime dataHoraDoCadastro;

}
