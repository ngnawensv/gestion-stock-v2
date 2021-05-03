package cm.belrose.stockserveur.service.impl;

import cm.belrose.stockserveur.dto.ClientDto;
import cm.belrose.stockserveur.dto.FournisseurDto;
import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidEntityException;
import cm.belrose.stockserveur.model.Fournisseur;
import cm.belrose.stockserveur.repository.FournissseurRepository;
import cm.belrose.stockserveur.service.FournisseurService;
import cm.belrose.stockserveur.validator.FournisseurValidator;
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
public class FournisseurServiceImpl implements FournisseurService {

    @Autowired
    private FournissseurRepository fournissseurRepository;

    @Override
    public FournisseurDto save(FournisseurDto dto) {
        List<String> errors= FournisseurValidator.validator(dto);
        if(!errors.isEmpty()){
            log.error(" Fournisseur non valide {}", dto);
            throw new InvalidEntityException("Le fournisseur n'est pas valide", ErrorCodes.FOURNISSEUR_NOT_VALID, errors);
        }
        return FournisseurDto.fromEntity(fournissseurRepository.save(FournisseurDto.toEntity(dto)));
    }

    @Override
    public FournisseurDto findById(Long id) {
        if(id==null){
            log.error("Categorie ID is null");
            return null;
        }
        return fournissseurRepository.findById(id)
                .map(FournisseurDto::fromEntity).orElseThrow(
                ()->new EntityNotFoundException("Aucun fournisseur avec l'ID="+id+"n'a été trouvé dans la BD",
                        ErrorCodes.FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournissseurRepository.findAll().stream()
                .map(FournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if(id==null){
            log.error("Fournisseur ID is null");
            return ;
        }
        fournissseurRepository.deleteById(id);
    }

}
