package br.com.alura.screenmatch.model;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class Episodios {
    private Integer temporada;
    private String titulo;
    private Integer numeroEpisodio;
    private Double avaliacao;
    private LocalDateTime dataLancamento;

    public Episodios(Integer numeroTemporada, EpirsodioDTO epirsodioDTO) {
        this.temporada = numeroTemporada;
        this.titulo = epirsodioDTO.titulo();
        this.numeroEpisodio = epirsodioDTO.numero();
        try {
            this.avaliacao = Double.valueOf(epirsodioDTO.avaliacao());
            this.dataLancamento = LocalDateTime.parse(epirsodioDTO.dataLancamento());
        }catch (NumberFormatException | DateTimeParseException exception){
            this.avaliacao = 0.0;
            this.dataLancamento = LocalDateTime.now();
        }

    }

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(Integer numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public LocalDateTime getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDateTime dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    @Override
    public String toString() {
        return
                "temporada=" + temporada +
                ", titulo='" + titulo + '\'' +
                ", numeroEpisodio=" + numeroEpisodio +
                ", avaliacao=" + avaliacao +
                ", dataLancamento=" + dataLancamento;
    }
}
