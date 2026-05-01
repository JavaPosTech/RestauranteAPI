package br.com.fiap.restauranteapi.service.tipousuario;

import br.com.fiap.restauranteapi.model.dto.tipousuario.UserTypeDTO;
import br.com.fiap.restauranteapi.repository.tipousuario.UserTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserTypeService {

    private final UserTypeRepository userTypeRepository;

    @Transactional(readOnly = true)
    public List<UserTypeDTO> findAll() {
        var userTypes = userTypeRepository.findAll();

        return userTypes.stream()
                .map(UserTypeDTO::new)
                .toList();
    }
}