package be.vdab.crm;

import be.vdab.crm.config.CrmConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class CrmApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ac = SpringApplication.run(CrmConfig.class, args);

    }
}
