package com.sistema.core.model.pessoa;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.core.model.pessoa.dto.PessoaChangeDTO;
import com.sistema.core.model.pessoa.dto.PessoaCreateDTO;
import com.sistema.core.model.pessoa.dto.PessoaListDTO;
import com.sistema.core.model.pessoa.dto.PessoaShowDTO;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService service;

	@GetMapping("/listar")
	public List<PessoaListDTO> listar() {

		return service.listar();
	}

	@GetMapping("/buscar")
	public PessoaShowDTO buscar(@RequestParam Long id) {
		return service.buscarPorId(id);
	}

	@GetMapping("/pesquisanome")
	public List<Pessoa> buscar(@RequestParam String nome) {
		return service.pesquisarPorNome(nome);
	}

	@PostMapping("/criar")
	public PessoaShowDTO criar(@Valid @RequestBody PessoaCreateDTO dto) {

		return service.criar(dto);
	}

	@PutMapping("/alterar")
	public Pessoa alterar(@Valid @RequestBody PessoaChangeDTO dto) {

		return service.alterar(dto);
	}

	@DeleteMapping("/excluir")
	public void excluir(@RequestParam Long id) {

		service.excluir(id);
	}

	@GetMapping("/safada")
	public String safada(SafadaDTO dto) {

		return dto.getNome();
	}

}

class SafadaDTO {
	private String nome;
	private int busto;
	private int cintura;
	private int nivelBeleza;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getBusto() {
		return busto;
	}

	public void setBusto(int busto) {
		this.busto = busto;
	}

	public int getCintura() {
		return cintura;
	}

	public void setCintura(int cintura) {
		this.cintura = cintura;
	}

	public int getNivelBeleza() {
		return nivelBeleza;
	}

	public void setNivelBeleza(int nivelBeleza) {
		this.nivelBeleza = nivelBeleza;
	}

}