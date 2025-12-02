package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // ignorar os campos que não estão sendo serializados
public record SerieDto (@JsonAlias("Title") String title,
                        @JsonAlias("totalSeasons") Integer totalTempradas,
                        @JsonAlias("imdbRating") String avaliacao){
}
