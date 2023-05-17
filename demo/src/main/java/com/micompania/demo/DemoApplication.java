package com.micompania.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping("/suma")
	public int suma(@RequestParam int a, @RequestParam int b) {
		return a + b;
	}

	@GetMapping("/resta")
	public int resta(@RequestParam int a, @RequestParam int b) {
		return a - b;
	}



	@GetMapping("/multi")
	public int multi(@RequestParam int a, @RequestParam int b) {
		return a * b;
	}


	@GetMapping("/div")
	public double div(@RequestParam int a, @RequestParam int b) {
		if (b == 0) {
			throw new Calc("Divisor cannot be zero");

		}
		return (double) a / b;
	}

	@ExceptionHandler(Calc.class)
	public ResponseEntity<String> handleDivisionByZeroException(Calc ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}


	@GetMapping("/power")
	public double power(@RequestParam double a, @RequestParam double b) {
		return Math.pow(a,b);
	}


	@GetMapping("/sqrt")
	public double sqrt(@RequestParam double a) {
		return Math.sqrt(a);
	}

	@GetMapping("/log")
	public double log(@RequestParam double a) {
		return Math.log(a);
	}

	@GetMapping("/log10")
	public double log10(@RequestParam double a) {
		return Math.log10(a);
	}


	@GetMapping("/sen")
	public double sen(@RequestParam double a) {
		return Math.sin(a);
	}

	@GetMapping("/cos")
	public double cos(@RequestParam double a) {
		return Math.cos(a);
	}


	@GetMapping("/tan")
	public double tan(@RequestParam double a) {
		return Math.tan(a);
	}

}


