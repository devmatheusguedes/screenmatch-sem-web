package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.EpirsodioDTO;
import br.com.alura.screenmatch.model.Episodios;
import br.com.alura.screenmatch.model.SerieDto;
import br.com.alura.screenmatch.model.TemporadaDTO;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {
    private final Scanner leitura;
    private final ConsumoAPI consumoAPI;
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=37b7b775";
    public Menu(){
        consumoAPI = new ConsumoAPI();
        leitura = new Scanner(System.in);
        iniciar();
    }

    public void iniciar(){
        System.out.print("Digite o nome da serie: ");
        String nomeSerie = leitura.next().replace(" ", "+");

        String json = consumoAPI.obterDados(ENDERECO+nomeSerie+API_KEY).replace(" ", "+");
        ConverteDados converteDados = new ConverteDados();
        SerieDto serieDto = converteDados.obterDados(json, SerieDto.class);

        System.out.println("\tresultado da pesquisa");
        System.out.println("\t"+serieDto);

        List<TemporadaDTO> temporadas = new ArrayList<>();
        for (int i = 1; i <= serieDto.totalTempradas(); i++) {
            json = consumoAPI.obterDados(ENDERECO+nomeSerie+"&season="+i+API_KEY).replace(" ", "+");
            TemporadaDTO temporadaDTO = converteDados.obterDados(json, TemporadaDTO.class);
            temporadas.add(temporadaDTO);
        }



//        for (int i = 0; i < temporadas.size() ; i++) {
//            System.out.println("\t TEMPORADA "+(i+1));
//            List<EpirsodioDTO> epirsodios = temporadas.get(i).episodios();
//            for (EpirsodioDTO epirsodio : epirsodios) {
//                System.out.println(epirsodio);
//            }
//        }

        temporadas.forEach(t ->{
            t.episodios().forEach(e->{
                System.out.println(e.titulo());
            });
        });

        List<EpirsodioDTO> epsiodiosDTO = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());

        System.out.println("Top 5 episodios");

        epsiodiosDTO.stream()
                .filter(e -> !e.avaliacao().equals("N/A"))
                .sorted(Comparator.comparing(EpirsodioDTO::avaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);

        List<Episodios> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodios(t.numero(), d))
                )
                .collect(Collectors.toList());

        System.out.println("\n episodios e temporada");
        episodios.forEach(System.out::println);





    }
}
