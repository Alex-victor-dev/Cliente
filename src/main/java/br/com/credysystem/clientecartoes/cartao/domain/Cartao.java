package br.com.credysystem.clientecartoes.cartao.domain;

import java.util.Random;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import br.com.credysystem.clientecartoes.cartao.application.api.CartaoRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idCartao", updatable = false, unique = true, nullable = false)
	private UUID idCartao;
	@NotNull
	@Column(columnDefinition = "uuid", name = "idClienteCartao", nullable = false)
	private UUID idClienteCartao;
	@Enumerated(EnumType.STRING)
	private Bandeira bandeiraCartao;
	private Double limiteTotal;
	private String numeroCartao;

	public Cartao(UUID idCliente, CartaoRequest cartaoRequest) {
		this.idClienteCartao = idCliente;
		this.bandeiraCartao = cartaoRequest.getBandeiraCartao();
		this.limiteTotal = cartaoRequest.getLimiteTotal();
		this.numeroCartao = maskaraDigitos(gerarDigitosAleatorios(16));

	}

	private static String gerarDigitosAleatorios(int digitos) {
		StringBuilder string = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < digitos; i++) {
			string.append(random.nextInt(10));

		}
		return string.toString();
	}

	private static String maskaraDigitos(String ccnum) {
		int total = ccnum.length();
		int startlen = 4, endlen = 4;
		int masklen = total - (startlen + endlen);
		StringBuffer maskedbuf = new StringBuffer(ccnum.substring(0, startlen));
		for (int i = 0; i < masklen; i++) {
			maskedbuf.append('X');
		}
		maskedbuf.append(ccnum.substring(startlen + masklen, total));
		String masked = maskedbuf.toString();
		return masked;
	}

}
