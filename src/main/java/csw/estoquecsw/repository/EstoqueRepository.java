package csw.estoquecsw.repository;

import csw.estoquecsw.model.EstoqueModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueModel,Integer> {
    public boolean existsBySku(Integer sku);
    public boolean existsByProduto(String produto);
}
