package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.SerieDto;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoAPI();
		String json = consumoApi.obterDados("https://www.omdbapi.com/?t=bigbang&apikey=37b7b775");
		System.out.println(json);
		ConverteDados converteDados = new ConverteDados();
		SerieDto dados = converteDados.obterDados(json, SerieDto.class);
		System.out.println("Dados convertidos: " + dados);
	}
}
