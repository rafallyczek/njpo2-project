package njpo2.project.bookrepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class BookrepoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookrepoApplication.class, args);
    }

}
