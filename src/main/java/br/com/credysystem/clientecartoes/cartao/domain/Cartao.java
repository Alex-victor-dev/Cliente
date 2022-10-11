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

	private static final Double limiteMaximu = 2000.0;
	private static final Double limiteMinimu = 200.0;

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

	public Cartao(UUID idCliente, CartaoRequest cartaoRequest, Double salario) {
		this.idClienteCartao = idCliente;
		this.bandeiraCartao = cartaoRequest.getBandeiraCartao();
		this.limiteTotal = cartaoRequest.getLimiteTotal();
		this.numeroCartao = maskaraDigitos(gerarDigitosAleatorios(16));
		this.limiteTotal = geraLimiteCartao(salario);

	}

	public Double geraLimiteCartao(Double salario) {
		Double limiteTotal = (salario / 100) * 30;
		if (limiteTotal < limiteMinimu) {
			limiteTotal = limiteMinimu;
		} else if (limiteTotal > limiteMaximu) {
			limiteTotal = limiteMaximu;
		}
		return limiteTotal;

	}

	private static String gerarDigitosAleatorios(int digitos) {
		StringBuilder string = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < digitos; i++) {
			string.append(random.nextInt(10));

		}
		return string.toString();
	}

	private static String maskaraDigitos(String posicao) {
		int total = posicao.length();
		int startlen = 4, endlen = 4;
		int masklen = total - (startlen + endlen);
		StringBuffer maskedbuf = new StringBuffer(posicao.substring(0, startlen));
		for (int i = 0; i < masklen; i++) {
			maskedbuf.append('X');
		}
		maskedbuf.append(posicao.substring(startlen + masklen, total));
		String masked = maskedbuf.toString();
		return masked;
	}

}
