package EPICODE.U5S2L2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class U5S2L2Application {

	public static final Random r = new Random();

	public static void main(String[] args) {
		SpringApplication.run(U5S2L2Application.class, args);
	}

}
