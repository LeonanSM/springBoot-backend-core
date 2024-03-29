package com.sistema.core.model.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.core.model.servico.dto.ServicoDTOChange;
import com.sistema.core.model.servico.dto.ServicoDTOCreate;
import com.sistema.core.model.servico.dto.ServicoDTOList;
import com.sistema.core.model.servico.dto.ServicoDTOShow;
import com.sistema.core.model.servico.mapper.ServicoChangeDTOMapper;
import com.sistema.core.model.servico.mapper.ServicoCreateDTOMapper;
import com.sistema.core.model.servico.mapper.ServicoListDTOMapper;
import com.sistema.core.model.servico.mapper.ServicoShowDTOMapper;



@Service
public class ServicoService {

	@Autowired
	private ServicoRepository repository;

	@Autowired
	private ServicoListDTOMapper dtoListmapper;
	
	@Autowired
	private ServicoShowDTOMapper dtoShowmapper;
	
	@Autowired
	private ServicoCreateDTOMapper dtoCreatemapper;
	
	@Autowired
	private ServicoChangeDTOMapper dtoChangemapper;

	
	
	
	public List<ServicoDTOList> listar() {
		return dtoListmapper.toDTO(repository.findAll());
	}

	public ServicoDTOShow buscarPorId(Long id) {

		Optional<Servico> optional = repository.findById(id);
		if (!optional.isPresent()) {
			throw new RuntimeException("Servico não encontrada!");
		}

		return dtoShowmapper.toDTO(optional.get());
	}
	
	public ServicoDTOShow criar(ServicoDTOCreate dto) {
		
		Servico servico = dtoCreatemapper.toEntity(dto);
		servico= repository.save(servico);
		return dtoShowmapper.toDTO(servico);
	}
	
	public Servico alterar(ServicoDTOChange dto) {
		
		Servico servico = dtoChangemapper.toEntity(dto);
		Servico alterado = repository.save(servico);
		
		return alterado;
	}
	
	public String excluir(Long id) {
		String excluido = "Serviço excluido";
		repository.deleteById(id);

		return excluido;

	}

}
