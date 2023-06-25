package guru.qa.front;

import guru.qa.service.Session;

public interface Frontend {

    void start(Session session);

    class MockFrontend implements Frontend {

        @Override
        public void start(Session session) {
            System.out.println("Frontend started!");
        }
    }
}
