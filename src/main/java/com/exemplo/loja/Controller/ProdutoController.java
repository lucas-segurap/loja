package com.exemplo.loja.Controller;
import com.exemplo.loja.Model.Produto;
import com.exemplo.loja.Sevice.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService service;
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }
    // LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("produtos", service.listar());
        return "produtos";
    }
    // ABRIR FORMULÁRIO
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("produto", new Produto());
        return "formulario";
    }

    // SALVAR
    @PostMapping("/salvar")
    public String salvar(
            @Valid @ModelAttribute("produto") Produto produto,
            BindingResult resultado,
            RedirectAttributes redirect) {
        if (resultado.hasErrors()) {
            return "formulario";
        }
        service.salvar(produto);
        redirect.addFlashAttribute(
                "mensagem", "Produto salvo com sucesso!");
        return "redirect:/produtos";
    }
    // EDITAR
    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model) {
        model.addAttribute("produto", service.buscar(id));
        return "formulario";
    }
    // EXCLUIR
    @PostMapping("/excluir/{id}")
    public String excluir(
            @PathVariable Long id,
            RedirectAttributes redirect) {
        service.excluir(id);
        redirect.addFlashAttribute(
                "mensagem", "Produto excluído com sucesso!");
        return "redirect:/produtos";
    }
}