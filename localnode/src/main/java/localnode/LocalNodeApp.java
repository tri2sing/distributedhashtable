package localnode;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class LocalNodeApp extends Application<LocalNodeConfig>{

    @Override
    public void run(LocalNodeConfig localNodeConfig, Environment environment) throws Exception {
        final LocalNodeResource localNodeResource = new LocalNodeResource();
        environment.jersey().register(localNodeResource);
    }

    public static void main(String[] args) throws Exception {
        new LocalNodeApp().run(args);
    }
}
