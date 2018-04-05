package be.vdab.crm;

import be.vdab.crm.config.CrmConfig;
import be.vdab.crm.entity.Product;
import be.vdab.crm.entity.ProductCategory;
import be.vdab.crm.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CrmApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ac = SpringApplication.run(CrmApplication.class, args);
        //ConfigurableApplicationContext context = new SpringApplicationBuilder(CrmConfig.class).run();

    }
}
