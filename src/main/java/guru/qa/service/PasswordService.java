package guru.qa.service;

public interface PasswordService {

    String encode(String source);

    String decode(String source);

    class MockPasswordService implements PasswordService {

        @Override
        public String encode(String source) {
            return source;
        }

        @Override
        public String decode(String source) {
            return source;
        }
    }
}
