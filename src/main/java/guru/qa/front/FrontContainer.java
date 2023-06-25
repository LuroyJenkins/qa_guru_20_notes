package guru.qa.front;

import guru.qa.service.Session;

public class FrontContainer implements Frontend {

    private final Frontend[] frontends;

    public FrontContainer(Frontend... frontends) {
        this.frontends = frontends;
    }

    @Override
    public void start(Session session) {
        for (Frontend frontend : frontends) {
            frontend.start(session);
        }
    }
}
