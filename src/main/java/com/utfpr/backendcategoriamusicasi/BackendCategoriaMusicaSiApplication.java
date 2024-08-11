package com.utfpr.backendcategoriamusicasi;

import com.utfpr.backendcategoriamusicasi.entity.Categoria;
import com.utfpr.backendcategoriamusicasi.entity.Musica;
import com.utfpr.backendcategoriamusicasi.service.CategoriaService;
import com.utfpr.backendcategoriamusicasi.service.MusicaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BackendCategoriaMusicaSiApplication {

	private static final Logger log = LoggerFactory.getLogger(BackendCategoriaMusicaSiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendCategoriaMusicaSiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CategoriaService service, MusicaService musicaService) {
		return (args) -> {
			log.info("");
			log.info("");
			log.info("===============Listagem das músicas===============");
			for (Musica m : musicaService.listarTodasAsMusicas()) {
				log.info(m.toString());
			}
			log.info("");
			log.info("");
			log.info("===============Listagem das categorias===============");
			for (Categoria c : service.listarTodasAsCategorias()) {
				log.info(c.toString());
			}

			log.info("");
			log.info("");
			log.info("===============Somar tempo das musicas===============");
			musicaService.procAdicioneTempo(1000);

			log.info("");
			log.info("");
			log.info("===============Listagem das músicas após a soma===============");
			for (Musica m : musicaService.listarTodasAsMusicas()) {
				log.info(m.toString());
			}

			log.info("");
			log.info("");
			log.info("===============Subtrair tempo das musicas===============");
			musicaService.procSubtraiTempo(1000);


			log.info("");
			log.info("");
			log.info("===============Listagem das músicas após subtração===============");
			for (Musica m : musicaService.listarTodasAsMusicas()) {
				log.info(m.toString());
			}





		};



	}


}
