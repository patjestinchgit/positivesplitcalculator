package be.positive.calculator.positivesplitcalculator;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan
public class PositiveSplitCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PositiveSplitCalculatorApplication.class, args);
	}

}
