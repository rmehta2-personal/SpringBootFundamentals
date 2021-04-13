package ttl.larku.someapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ttl.larku.specialprinter.SpecialPrinter;

@SpringBootTest
public class TestSpecialAutoConfig {
    @Autowired
    private SpecialPrinter printer;

    @Test
    public void testSpecialPrinter() {
        System.out.println("Printer: " + printer.log("Boo"));
    }
}

//@Configuration
//class UserConfiguration {
//
//    @Bean
//    public SpecialPrinter specialPrinter() {
//        return new SpecialPrinter();
//    }
//
//}