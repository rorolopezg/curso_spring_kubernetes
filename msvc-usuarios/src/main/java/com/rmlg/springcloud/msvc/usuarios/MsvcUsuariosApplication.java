package com.rmlg.springcloud.msvc.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.logging.Logger;

@EnableFeignClients
@SpringBootApplication
public class MsvcUsuariosApplication implements ApplicationRunner {
	@Value("${spring.datasource.url}")
	String dbUrl;

	public static void main(String[] args) {
		System.out.println("*** Iniciando aplicación");
		SpringApplication.run(MsvcUsuariosApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("*** URL de Base de Datos: " + dbUrl);
	}
}


@Component
class PostConstructExampleBean {

	private static final Logger LOG
			= Logger.getLogger(PostConstructExampleBean.class.getName());

	@Autowired
	private Environment environment;

	@PostConstruct
	public void init() {
		System.out.println("*** propiedades de entoro:");
		LOG.info(String.valueOf(environment.getDefaultProfiles()));
	}
}