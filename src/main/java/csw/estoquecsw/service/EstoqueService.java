package csw.estoquecsw.service;

import csw.estoquecsw.model.EstoqueModel;
import csw.estoquecsw.repository.EstoqueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository estoqueRepository;

    public List<EstoqueModel>findAll(){
        return estoqueRepository.findAll();
    }


    public EstoqueModel save(EstoqueModel estoqueModel){
            String situacao=estoqueModel.getSituacao().toLowerCase();
            double result;

            //Tratado com exceções...
        try{

            if(situacao.equals("vendido")){

                result = (estoqueModel.getValorVd() - estoqueModel.getValorCp()) * estoqueModel.getVolumeQtd();
                estoqueModel.setLucroFi(result);
            }
            else if (situacao.equals("em estoque")){
                estoqueModel.setLucroFi(0.0);
            }else{
                throw new IllegalArgumentException("Situação errada: "+situacao);

            }

        }catch (IllegalArgumentException e){
            System.err.println("Situação errada: "+e+situacao);
                    return new EstoqueModel();
        }
        if(estoqueModel.getVolumeQtd()>=2||estoqueModel.getVolumeQtd()<=10){
            Double num1= estoqueModel.getValorCp()*estoqueModel.getVolumeQtd();
            estoqueModel.setValorCp2(num1);
            Double num2=estoqueModel.getValorVd()*estoqueModel.getVolumeQtd();
            estoqueModel.setValorVd2(num2);
        }
        return estoqueRepository.save(estoqueModel);

    }
    
    public boolean existsBySku(Integer sku){
        return estoqueRepository.existsBySku(sku);
    }
    public boolean existsByProduto(String produto){
        return estoqueRepository.existsByProduto(produto);
    }
    public Optional<EstoqueModel>findByIdProduto(Integer id){
        return estoqueRepository.findById(id);
    }

    public void deletById(Integer id){
        estoqueRepository.deleteById(id);
    }

}
