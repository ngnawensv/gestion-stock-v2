package cm.belrose.stockserveur.service.impl;

import cm.belrose.stockserveur.dto.LigneVenteDto;
import cm.belrose.stockserveur.dto.VenteDto;
import cm.belrose.stockserveur.exceptions.EntityNotFoundException;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidEntityException;
import cm.belrose.stockserveur.model.Article;
import cm.belrose.stockserveur.model.LigneVente;
import cm.belrose.stockserveur.model.Vente;
import cm.belrose.stockserveur.repository.ArticleRepository;
import cm.belrose.stockserveur.repository.LigneVenteRepository;
import cm.belrose.stockserveur.repository.VenteRepository;
import cm.belrose.stockserveur.service.VenteService;
import cm.belrose.stockserveur.validator.VenteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VenteServiceImpl implements VenteService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private VenteRepository venteRepository;
    @Autowired
    private LigneVenteRepository ligneVenteRepository;

    @Override
    public VenteDto save(VenteDto dto) {
        List<String> errors = VenteValidator.validator(dto);
        if (!errors.isEmpty()) {
            log.error("Vente non valide");
            throw new InvalidEntityException("", ErrorCodes.VENTE_NOT_VALID);
        }

        List<String> articleErrors = new ArrayList<>();
        dto.getLigneVenteList().forEach(ligneVenteDto -> {
            Optional<Article> article = articleRepository.findById(ligneVenteDto.getArticle().getId());
            if (article.isEmpty()) {
                articleErrors.add("Aucun article avec l'ID " + ligneVenteDto.getArticle().getId() + " n'est pas trouvé dans la BD");

            }
        });

        if (!articleErrors.isEmpty()) {
            log.error("Un ou plusieurs articles ne sont pas trouvés dans la BD, {}", errors);
            throw new InvalidEntityException("Un ou plusieurs articles non trouvés dans la BD ", ErrorCodes.VENTE_NOT_VALID, errors);
        }
        Vente saveVente = venteRepository.save(VenteDto.toEntity(dto));
        dto.getLigneVenteList().forEach(ligneVentedto -> {
            LigneVente ligneVente = LigneVenteDto.toEntity(ligneVentedto);
            ligneVente.setVente(saveVente);
            ligneVenteRepository.save(ligneVente);
        });
        return VenteDto.fromEntity(saveVente);
    }

    @Override
    public VenteDto findById(Long id) {
        if (id == null) {
            log.error("Vente ID is null");
            return null;
        }
        return venteRepository.findById(id)
                .map(VenteDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucune vente n'a été trouvé dans la BD", ErrorCodes.VENTE_NOT_FOUND));
    }

    @Override
    public VenteDto findVenteByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Vente code is null");
            return null;
        }
        return venteRepository.findVenteByCode(code)
                .map(VenteDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucune vente n'a été trouvé dans la BD avec le code " + code, ErrorCodes.VENTE_NOT_FOUND));
    }



    @Override
    public List<VenteDto> findAll() {
        return venteRepository.findAll().stream()
                .map(VenteDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if(id==null){
            log.error("Vente ID is null");
            return ;
        }
        venteRepository.deleteById(id);
    }
}
