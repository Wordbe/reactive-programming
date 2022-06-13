package co.whitetree.reactiveprogramming.fluxemit.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import static java.util.Objects.isNull;

public class FileReaderService {

    // state supplier
    private Callable<BufferedReader> openReader(Path path) {
        return () -> Files.newBufferedReader(path);
    }

    // generate
    private BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> read() {
        return ((bufferedReader, stringSynchronousSink) -> {
            try {
                String line = bufferedReader.readLine();
                System.out.println("reading ... " + line);
                if (isNull(line)) stringSynchronousSink.complete();
                else stringSynchronousSink.next(line);

            } catch (IOException e) {
                stringSynchronousSink.error(e);
            }
            return bufferedReader;
        });
    }

    // state consumer
    private Consumer<BufferedReader> closeReader() {
        return bufferedReader -> {
            try {
                bufferedReader.close();
                System.out.println("closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    public Flux<String> read(Path path) {
        return Flux.generate(openReader(path), read(), closeReader());
    }
}
