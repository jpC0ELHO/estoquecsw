package csw.estoquecsw.dto;

import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDateTime;

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
    @NotBlank
    private String situacao;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataPostada;

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

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
