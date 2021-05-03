package cm.belrose.stockserveur.controller;

import cm.belrose.stockserveur.controller.api.CategorieApi;
import cm.belrose.stockserveur.dto.CategorieDto;
import cm.belrose.stockserveur.model.Categorie;
import cm.belrose.stockserveur.service.CategorieService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Le 11/11/2020
 *
 * @author Ngnawen Samuel
 */
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RequestMapping("/api")
@RestController
@Slf4j
public class CategorieController implements CategorieApi {

    @Autowired
    private CategorieService categorieService;

    @Override
    public CategorieDto save(CategorieDto dto) {
        return categorieService.save(dto);
    }

    @Override
    public CategorieDto findById(Long id) {
        return categorieService.findById(id);
    }

    @Override
    public CategorieDto findCategorieByCode(String code) {
        return categorieService.findCategorieByCode(code);
    }

    @Override
    public List<CategorieDto> findAll() {
        return categorieService.findAll();
    }

    @Override
    public void delete(Long id) {
        categorieService.delete(id);

    }
/*
    private static final Logger logger = LoggerFactory.getLogger(CategorieController.class);

    @Autowired
    CategorieService categorieService;

    *//**
     * retrieve all Categories
     *
     * @return
     * @throws Exception
     *//*
    @GetMapping("/categories1")
    public List<Categorie> findAll1() throws Exception {
        return categorieService.findAll();
    }

    *//**
     * retrieve all Categories with ResponseEntity
     *
     * @param nom
     * @return
     * @throws Exception
     *//*
    @GetMapping("/categories")
    public ResponseEntity<List<Categorie>> getAll(@RequestParam(required = false) String nom) throws Exception {
        try {
            List<Categorie> categories = new ArrayList<>();
            Consumer<Categorie> consumer = categories::add;
            if (nom == null)
                categorieService.findAll().forEach(consumer);
            else
                categorieService.findByNomContaining(nom).forEach(consumer);
            if (categories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/categories/code")
    public ResponseEntity<Categorie> getCategorieByCode(@RequestParam(required = false) String code) throws Exception {
        try {
            Categorie categorie = categorieService.findCategorieByCode(code);
            return new ResponseEntity<>(categorie, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    *//**
     * retrieve a Category by :id
     *
     * @param id
     * @return
     * @throws Exception
     *//*
    @GetMapping("/categories/{id}")
    public ResponseEntity<Categorie> findById(@PathVariable("id") Long id) throws Exception {
        Optional<Categorie> categorieData = categorieService.findById(id);

        if (categorieData.isPresent()) {
            return new ResponseEntity<>(categorieData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    *//* @PostMapping("/categories")
     public  ResponseEntity<MessageResponse> saveCategorie(@RequestBody CategorieDTO categorieDto) throws Exception{
         if(categorieService.existsByLibelle(categorieDto.getNom())){
             return new ResponseEntity(new MessageResponse(categorieDto.getNom()+" category already existe "),HttpStatus.BAD_REQUEST);
         }
         categorieService.save(categorieDto);
         return new ResponseEntity<>(new MessageResponse(categorieDto.getNom()+" category successful save!"),HttpStatus.CREATED);
     }
 *//*
    @PostMapping("/categories")
    public ResponseEntity<Categorie> save(@RequestBody Categorie categorie) throws Exception {
        try {
            //Categorie _categorie = categorieService.save(new Categorie(categorie.getCode(),categorie.getNom()));
            return new ResponseEntity<>(categorieService.save(categorie), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    *//*@PutMapping("/categories/{id}")
    public  ResponseEntity<Categorie> updateCategorie(@PathVariable("id") Long id, @RequestBody CategorieDTO categorieDto) throws Exception{
       Optional<Categorie> cat=categorieService.findById(id);
       System.out.println("Cat: "+cat);
        if(cat.isEmpty()){
            return new ResponseEntity(new MessageResponse("Categorie with id="+id+" don't exist!!! "), HttpStatus.BAD_REQUEST);
        }
        cat.get().setNom(categorieDto.getNom());
        cat.get().setCode(categorieDto.getCode());
        cat.get().setId(id);
        categorieService.update(cat.get());
        return new ResponseEntity(new MessageResponse(categorieDto.getNom()+" successful update!!! "), HttpStatus.OK);
    }
*//*

    @PutMapping("/categories/{id}")
    public ResponseEntity<Categorie> update(@PathVariable("id") long id, @RequestBody Categorie categorie) throws Exception {
        Optional<Categorie> categorieData = categorieService.findById(id);
        if (categorieData.isPresent()) {
            Categorie _categorie = categorieData.get();
            _categorie.setId(id);
            _categorie.setCode(categorie.getCode());
            _categorie.setLibelle(categorie.getLibelle());
            return new ResponseEntity<>(categorieService.update(_categorie), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    *//**
     * delete a Category by :id
     *
     * @param id
     * @return
     * @throws Exception
     *//*
   *//* @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) throws Exception{
        Categorie categorie=categorieService.findById(id).get();
        if(categorie!=null){
            categorieService.delete(categorie);
        }
       return new ResponseEntity<>(HttpStatus.GONE);
    }*//*
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {
            categorieService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/categories")
    public ResponseEntity<HttpStatus> deleteAll() {
        try {
            categorieService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    *//**
     *find all Categories which nom contains keyword
     * @param keyword
     * @param page
     * @param size
     * @return
     * @throws Exception
     *//*
   *//* @GetMapping("/chercher")
    public Page<Categorie> chercherContact(@RequestParam(name = "keyword",defaultValue = "") String keyword,
                                           @RequestParam(name = "page",defaultValue = "0") int page,
                                           @RequestParam(name = "size",defaultValue = "2") int size) throws Exception{
        Pageable paging = PageRequest.of(page, size);
        return categorieService.cherhcer("%"+keyword+"%", paging);
    }*//*
*/
}
