package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class BookStoreApp {
    public static void main( String[] args )
    {
        System.out.println( "Starting BookStoreApp" );
		SpringApplication.run(BookStoreApp.class, args);
    }
}
