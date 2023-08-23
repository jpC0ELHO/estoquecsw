package csw.estoquecsw.model;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="estoquecsw")
public class EstoqueModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//gera algo parecido com codigo de barras.
    @Column(nullable = false)
    private String produto;
    @Column(nullable = false)
    private Integer sku;
    @Column
    private Integer volumeQtd;
    @Column
    private Double valorCp;
    @Column
    private Double valorCp2;
    @Column
    private Double valorVd;
    @Column
    private Double valorVd2;
    @Column
    private Double lucroFi;
    @Column
    private String situacao;
    @Column
    private Date data;
    @Column
    private LocalDateTime dataPostada;

    //Essas variaveis devem receber os valores devidos e retornar em forma de tabela ou grafico.
//    private Double gastoTtl;
//    private Double lucroBt;
//    private Double lucroLc;

    //Constructor

    public EstoqueModel() {
    }


    //Getters and Setters


    public Double getValorCp2() {
        return valorCp2;
    }

    public void setValorCp2(Double valorCp2) {
        this.valorCp2 = valorCp2;
    }

    public Double getValorVd2() {
        return valorVd2;
    }

    public void setValorVd2(Double valorVd2) {
        this.valorVd2 = valorVd2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public LocalDateTime getDataPostada() {
        return dataPostada;
    }

    public void setDataPostada(LocalDateTime dataPostada) {
        this.dataPostada = dataPostada;
    }
}
