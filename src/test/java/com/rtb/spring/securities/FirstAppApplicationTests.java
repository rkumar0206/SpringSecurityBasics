package com.rtb.spring.securities;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.beans.Encoder;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class FirstAppApplicationTests {

    @Test
    void testPasswordEncoders() {

        System.out.println("BCryptPasswordEncoder : " + new BCryptPasswordEncoder(31).encode("rohit"));
        System.out.println("Pbkdf2PasswordEncoder : " + new Pbkdf2PasswordEncoder().encode("rohit"));
        System.out.println("SCryptPasswordEncoder : " + new SCryptPasswordEncoder().encode("rohit"));

        Map<String, PasswordEncoder> encoders = new HashMap<>();

        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());

        String selectedEncoder = "bcrypt";

        System.out.println("DelegatingPasswordEncoder : " + new DelegatingPasswordEncoder(selectedEncoder, encoders).encode("rohit"));
    }

}
