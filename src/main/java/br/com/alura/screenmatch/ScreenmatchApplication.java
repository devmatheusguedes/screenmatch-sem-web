package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.EpirsodioDTO;
import br.com.alura.screenmatch.model.SerieDto;
import br.com.alura.screenmatch.model.TemporadaDTO;
import br.com.alura.screenmatch.principal.Menu;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import com.sun.tools.javac.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu menu = new Menu();
	}
}
