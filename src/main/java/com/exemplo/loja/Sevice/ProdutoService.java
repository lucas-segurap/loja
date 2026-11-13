package com.exemplo.loja.Sevice;
import com.exemplo.loja.Model.Produto;
import com.exemplo.loja.Repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProdutoService {
    private final ProdutoRepository repository;
    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }
    public List<Produto> listar() {
        return repository.findAll();
    }
    public Produto buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Produto não encontrado"));
    }
                public Produto salvar(Produto produto) {
        return repository.save(produto);
    }
    public void excluir(Long id) {
        repository.deleteById(id);
    }
}