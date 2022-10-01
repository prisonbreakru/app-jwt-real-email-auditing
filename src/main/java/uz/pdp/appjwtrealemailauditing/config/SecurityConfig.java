package uz.pdp.appjwtrealemailauditing.config;

import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Properties;

@Configuration
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public JavaMailSender javaMailSender(){
//        JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(587);
//        mailSender.setUsername("nurullaevmuzaffar96@gmail.com");
//        mailSender.setPassword("");
//        Properties properties = mailSender.getJavaMailProperties();
//        properties.put("mail.transport.protocol","smtp");
//
//
//    }
}
