package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import shop.dao.ProductDaoDataJpa;
import shop.dao.interfaces.ProductDao;
import shop.entities.Product;
import shop.repositories.ProductRepository;

import java.util.List;

@SpringBootApplication
public class Hw24Application{

    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(Hw24Application.class, args);
//        ctx.getBean(DemoService.class).demo();
    }
}