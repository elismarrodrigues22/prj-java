package senai.org.prjjava.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import senai.org.prjjava.entity.Produtos;
import senai.org.prjjava.repository.ProdutoRepository1;

@Controller
@RequestMapping(path = "/api/produtos")
@CrossOrigin("*")
public class ProdutoController {
    @Autowired ProdutoRepository1 pRepository1;

    @PostMapping("/")
    public @ResponseBody Integer addProduto(@RequestBody Produtos objP){
        pRepository1.save(objP);
        return objP.getId();
    }

    @GetMapping("/")
    public @ResponseBody Iterable<Produtos>buscarProdutos(){
        return pRepository1.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Produtos>buscarProduto(@PathVariable Integer id){
        return pRepository1.findById(id);
    }

    @PutMapping("/")
    public @ResponseBody Produtos atualizar(@RequestBody Produtos objP){
        pRepository1.save(objP);
        return objP;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String apagar(@PathVariable Integer id){
        pRepository1.deleteById(id);
        return " Produto Aapagado com sucesso! ";
    }
    


}
