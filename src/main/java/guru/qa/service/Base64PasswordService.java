package guru.qa.service;

import java.util.Base64;

public class Base64PasswordService implements PasswordService{
    @Override
    public String encode(String source) {
        return Base64.getEncoder().encodeToString(source.getBytes());
    }

    @Override
    public String decode(String source) {
        return new String(Base64.getDecoder().decode(source));
    }
}
