package com.exemplo.loja.Repository;
import com.exemplo.loja.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProdutoRepository
        extends JpaRepository<Produto, Long> {
}