package pl.wizyg.quarkus;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main {

    public static void main(String[] args) {
        System.out.println("running main");
        Quarkus.run(args);
    }
}
