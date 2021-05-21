package cm.belrose.stockserveur.service;

import cm.belrose.stockserveur.dto.MouvementStockDto;
import cm.belrose.stockserveur.model.MouvementStock;

import java.math.BigDecimal;
import java.util.List;

public interface MouvementStockService {
    BigDecimal stockReelArticle(Long idArticle);
    List<MouvementStockDto> mouvementStockArticle(Long idArticle);
    MouvementStockDto entreeStock(MouvementStockDto dto);
    MouvementStockDto sortieStock(MouvementStockDto dto);
    MouvementStockDto correctionStockPos(MouvementStockDto dto);
    MouvementStockDto correctionStockNeg(MouvementStockDto dto);
}
