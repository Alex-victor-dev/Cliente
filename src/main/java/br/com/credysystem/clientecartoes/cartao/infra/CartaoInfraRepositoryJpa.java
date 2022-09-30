package br.com.credysystem.clientecartoes.cartao.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.credysystem.clientecartoes.cartao.domain.Cartao;

public interface CartaoInfraRepositoryJpa extends JpaRepository<Cartao, UUID> {

	List<Cartao> findByIdClienteCartao(UUID idClienteCartao);
}
