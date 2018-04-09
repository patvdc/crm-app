package be.vdab.crm.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Little helper program to help generating hashes from plain text passwords.
 * (the output here is used to put in import.sql
 */
public class HasherHelperMain {
    public static void main(String[] args) {
        hash("aaa");
        hash("bbb");
    }

    private static void hash(String plainText) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
        String hash = encoder.encode(plainText);
        System.out.format("plain-text: %-10s hash: %-100s\n", plainText, hash);
    }
}
