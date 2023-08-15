package csw.estoquecsw.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Valid
public class EstoqueDTO {

    @NotBlank
    private String produto;
    @NotNull
    private Integer sku;
    @NotNull
    private Integer volumeQtd;
    @NotNull @PositiveOrZero
    private Double valorCp;
    @NotNull @PositiveOrZero
    private Double valorVd;
    @NotNull @PositiveOrZero
    private Double lucroFi;
    @NotBlank
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
