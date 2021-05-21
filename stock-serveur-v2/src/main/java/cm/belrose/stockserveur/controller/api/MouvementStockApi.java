package cm.belrose.stockserveur.controller.api;

import cm.belrose.stockserveur.dto.MouvementStockDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

import static cm.belrose.stockserveur.config.constants.Constant.APP_ROOT;

@Api(APP_ROOT+"/mouvementstock")
public interface MouvementStockApi {
    @GetMapping(APP_ROOT+"/mouvementstock/stockreel/{idArticle}")
    BigDecimal stockReelArticle(@PathVariable("idArticle") Long idArticle);
    @GetMapping(APP_ROOT+"/mouvementstock/filter/article/{idArticle}")
    List<MouvementStockDto> mouvementStockArticle(@PathVariable("idArticle") Long idArticle);
    @PostMapping(APP_ROOT+"/mouvementstock/entree")
    MouvementStockDto entreeStock(@RequestBody MouvementStockDto dto);
    @PostMapping(APP_ROOT+"/mouvementstock/sortie")
    MouvementStockDto sortieStock(@RequestBody MouvementStockDto dto);
    @PostMapping(APP_ROOT+"/mouvementstock/correctionpos")
    MouvementStockDto correctionStockPos(@RequestBody MouvementStockDto dto);
    @PostMapping(APP_ROOT+"/mouvementstock/correctionneg")
    MouvementStockDto correctionStockNeg(@RequestBody MouvementStockDto dto);
}
