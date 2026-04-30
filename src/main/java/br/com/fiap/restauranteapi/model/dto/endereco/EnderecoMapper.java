package br.com.fiap.restauranteapi.model.dto.endereco;

import br.com.fiap.restauranteapi.model.entity.endereco.Endereco;
import br.com.fiap.restauranteapi.model.request.endereco.CriarEnderecoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    Endereco fromCreateRequestToEntity(CriarEnderecoRequest criarEnderecoRequest);

}