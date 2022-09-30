package br.com.credysystem.clientecartoes.cartao.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cartao/{idCliente}/cartao\"")
public interface CartaoAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	CartaoResponse criaCartao(@PathVariable UUID idCliente, @RequestBody @Valid CartaoRequest cartaoRequest);

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<CartaoClienteListResponse> listaCartaoDosClientes(@PathVariable UUID idCliente);

	@GetMapping(value = "/{idCartao}")
	@ResponseStatus(code = HttpStatus.OK)
	CartaoClienteDetalhadoResponse listaCartaoDetalhadamente(@PathVariable UUID idCliente, @PathVariable UUID idCartao);

	@DeleteMapping(value = "/{idCartao}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaCartaoDosClientesPorId(@PathVariable UUID idCliente, @PathVariable UUID idCartao);

}
