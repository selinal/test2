package ru.autoparts.zap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import ru.autoparts.zap.jwt.db.ZapUser;
import ru.autoparts.zap.jwt.db.ZapUserRepository;

import java.util.Set;

import static ru.autoparts.zap.jwt.db.ZapRole.ADMIN;
import static ru.autoparts.zap.jwt.db.ZapRole.USER;

@SpringBootApplication
@ComponentScan(basePackages = {"laximo.oem.sdk"})
public class ZapApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZapApplication.class, args);
    }

    /***
     * "Этот бин для проверки
     * Удалить в ПРОМе
     * @param userRepository
     * @return
     */
    @Bean
    CommandLineRunner commandLineRunner(ZapUserRepository userRepository) {
        return args -> {
            userRepository.save(new ZapUser(null, "admin", "admin", "ADMIN ADMIN", null, null, Set.of(ADMIN, USER)));

            System.out.println(">>>>>>>>>>>> " + userRepository.findByLogin("admin"));
        };
    }
}
