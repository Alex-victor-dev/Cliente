package br.com.credysystem.clientecartoes.cliente.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.credysystem.clientecartoes.cliente.domain.Cliente;

public interface ClienteSpringDataJpaRepository extends JpaRepository<Cliente, UUID> {

}
