package cm.belrose.stockserveur.service.impl;

import cm.belrose.stockserveur.dto.MouvementStockDto;
import cm.belrose.stockserveur.exceptions.ErrorCodes;
import cm.belrose.stockserveur.exceptions.InvalidEntityException;
import cm.belrose.stockserveur.model.MouvementStock;
import cm.belrose.stockserveur.model.TypeMouvementStock;
import cm.belrose.stockserveur.repository.MouvementStockRepository;
import cm.belrose.stockserveur.service.ArticleService;
import cm.belrose.stockserveur.service.MouvementStockService;
import cm.belrose.stockserveur.validator.MouvementStockValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MouvementStockServiceImpl implements MouvementStockService {

    @Autowired
    private MouvementStockRepository mouvementStockRepository;
    @Autowired
    private ArticleService articleService;

    @Override
    public BigDecimal stockReelArticle(Long idArticle) {
        if(idArticle==null){
            log.warn("ID article is null ");
            return BigDecimal.valueOf(-1);
        }
        articleService.findById(idArticle);
        return mouvementStockRepository.stockReelArticle(idArticle);
    }

    @Override
    public List<MouvementStockDto> mouvementStockArticle(Long idArticle) {
        return mouvementStockRepository.findAllByArticleId(idArticle).stream()
                .map(MouvementStockDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public MouvementStockDto entreeStock(MouvementStockDto dto) {
       return entreePositive(dto, TypeMouvementStock.ENTREE);
    }

    @Override
    public MouvementStockDto sortieStock(MouvementStockDto dto) {
        return sortieNegative(dto, TypeMouvementStock.SORTIE);
    }

    @Override
    public MouvementStockDto correctionStockPos(MouvementStockDto dto) {
        return entreePositive(dto, TypeMouvementStock.CORRECTION_POS);
    }

    @Override
    public MouvementStockDto correctionStockNeg(MouvementStockDto dto) {
        return sortieNegative(dto, TypeMouvementStock.CORRECTION_NEG);
    }

    private MouvementStockDto entreePositive(MouvementStockDto dto, TypeMouvementStock typeMouvementStock){
        List<String> errors= MouvementStockValidator.validator(dto);
        if(!errors.isEmpty()){
            log.error(" Mouvement du stock non valide {}", dto);
            throw new InvalidEntityException("Le Mouvementdu stock n'est pas valide", ErrorCodes.MOUVEMENT_NOT_VALID, errors);
        }
        //Tranformation de la quantité en une valeur positive
        dto.setQuantite(BigDecimal.valueOf(Math.abs(dto.getQuantite().doubleValue())));
        dto.setTypeMouvementStock(typeMouvementStock);
        return MouvementStockDto.fromEntity(mouvementStockRepository.save(MouvementStockDto.toEntity(dto)));
    }

    private MouvementStockDto sortieNegative(MouvementStockDto dto, TypeMouvementStock typeMouvementStock){
        List<String> errors= MouvementStockValidator.validator(dto);
        if(!errors.isEmpty()){
            log.error(" Mouvement du stock non valide {}", dto);
            throw new InvalidEntityException("Le Mouvementdu stock n'est pas valide", ErrorCodes.MOUVEMENT_NOT_VALID, errors);
        }
        //Tranformation de la quantité en une valeur positive
        dto.setQuantite(BigDecimal.valueOf(Math.abs(dto.getQuantite().doubleValue())*-1));
        dto.setTypeMouvementStock(typeMouvementStock);
        return MouvementStockDto.fromEntity(mouvementStockRepository.save(MouvementStockDto.toEntity(dto)));
    }
}
