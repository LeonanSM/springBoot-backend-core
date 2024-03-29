package com.sistema.core.model.ordemservico.mapper;

import org.mapstruct.Mapper;

import com.sistema.core.model.abstractions.BaseMapper;
import com.sistema.core.model.ordemservico.OrdemServico;
import com.sistema.core.model.ordemservico.dto.OrdemServicoDTOCreate;
import com.sistema.core.model.ordemservicoitem.mapper.OrdemServicoItemDTOCreateMapper;
import com.sistema.core.model.pessoa.mapper.PessoaCreateDTOMapper;

@Mapper(componentModel = "spring",uses= {OrdemServicoItemDTOCreateMapper.class, PessoaCreateDTOMapper.class})
public interface OrdemServicoDTOCreateMapper extends BaseMapper<OrdemServico, OrdemServicoDTOCreate> {

}
