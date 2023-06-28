package csw.estoquecsw.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class EstoqueDTO {

    private String produto;

    private Integer sku;

    private Integer volumeQtd;

    private Double valorCp;

    private Double valorVd;

    private Double lucroFi;

    private String situacao;

    //Getters and setters


    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public Integer getVolumeQtd() {
        return volumeQtd;
    }

    public void setVolumeQtd(Integer volumeQtd) {
        this.volumeQtd = volumeQtd;
    }

    public Double getValorCp() {
        return valorCp;
    }

    public void setValorCp(Double valorCp) {
        this.valorCp = valorCp;
    }

    public Double getValorVd() {
        return valorVd;
    }

    public void setValorVd(Double valorVd) {
        this.valorVd = valorVd;
    }

    public Double getLucroFi() {
        return lucroFi;
    }

    public void setLucroFi(Double lucroFi) {
        this.lucroFi = lucroFi;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
