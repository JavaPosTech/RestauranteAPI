package br.com.fiap.restauranteapi.model.mapper.usuario;

import br.com.fiap.restauranteapi.model.entity.usuario.User;
import br.com.fiap.restauranteapi.model.request.usuario.UpdateUserRequest;
import br.com.fiap.restauranteapi.model.request.usuario.CreateUserRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "senha", ignore = true)
    @Mapping(target = "enderecos", ignore = true)
    @Mapping(target = "tipoUsuario", ignore = true)
    @Mapping(target = "dataAlteracao", ignore = true)
    @Mapping(target = "situacaoCadastro.id", ignore = true)
    User fromCreateRequestToEntity(CreateUserRequest createUserRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "login", ignore = true)
    @Mapping(target = "senha", ignore = true)
    @Mapping(target = "enderecos", ignore = true)
    @Mapping(target = "tipoUsuario", ignore = true)
    @Mapping(target = "dataAlteracao", ignore = true)
    @Mapping(target = "situacaoCadastro", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUser(UpdateUserRequest updateUserRequest, @MappingTarget User entity);

}