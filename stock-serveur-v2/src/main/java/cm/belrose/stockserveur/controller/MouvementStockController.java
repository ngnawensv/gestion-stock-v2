package cm.belrose.stockserveur.controller;

import cm.belrose.stockserveur.controller.api.MouvementStockApi;
import cm.belrose.stockserveur.dto.MouvementStockDto;
import cm.belrose.stockserveur.service.MouvementStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class MouvementStockController implements MouvementStockApi {

    @Autowired
    private MouvementStockService mouvementStockService;

    @Override
    public BigDecimal stockReelArticle(Long idArticle) {
        return mouvementStockService.stockReelArticle(idArticle);
    }

    @Override
    public List<MouvementStockDto> mouvementStockArticle(Long idArticle) {
        return mouvementStockService.mouvementStockArticle(idArticle);
    }

    @Override
    public MouvementStockDto entreeStock(MouvementStockDto dto) {
        return mouvementStockService.entreeStock(dto);
    }

    @Override
    public MouvementStockDto sortieStock(MouvementStockDto dto) {
        return mouvementStockService.sortieStock(dto);
    }

    @Override
    public MouvementStockDto correctionStockPos(MouvementStockDto dto) {
        return mouvementStockService.correctionStockPos(dto);
    }

    @Override
    public MouvementStockDto correctionStockNeg(MouvementStockDto dto) {
        return mouvementStockService.correctionStockNeg(dto);
    }
}
