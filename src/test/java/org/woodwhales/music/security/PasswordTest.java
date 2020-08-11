package org.woodwhales.music.security;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @projectName: woodwhales-music
 * @author: woodwhales
 * @date: 20.8.11 21:32
 * @description:
 */
public class PasswordTest {
    @Test
    public void test() {
        String admin = new BCryptPasswordEncoder().encode("admin");
        System.out.println(admin);
    }
}
