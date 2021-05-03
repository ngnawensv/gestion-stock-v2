package cm.belrose.stockserveur.service.impl;

import cm.belrose.stockserveur.dto.CategorieDto;
import cm.belrose.stockserveur.dto.ClientDto;
import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidEntityException;
import cm.belrose.stockserveur.model.Client;
import cm.belrose.stockserveur.repository.ClientRepository;
import cm.belrose.stockserveur.service.ClientService;
import cm.belrose.stockserveur.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors= ClientValidator.validator(dto);
        if(!errors.isEmpty()){
            log.error(" Client non valide {}", dto);
            throw new InvalidEntityException("Le client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);
        }
        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(dto)));
    }

    @Override
    public ClientDto findById(Long id) {
        if(id==null){
            log.error("Client ID is null");
            return null;
        }

        return clientRepository.findById(id)
                .map(ClientDto::fromEntity)
                .orElseThrow(
                ()->new EntityNotFoundException("Aucune caegoriet avec le CODE= "+id+" n'a été trouvé dans la BD",
                        ErrorCodes.CLIENT_NOT_FOUND));
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if(id==null){
            log.error("Client ID is null");
            return ;
        }
        clientRepository.deleteById(id);
    }


}

