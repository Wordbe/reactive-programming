package co.whitetree.reactiveprogramming.fluxemit;

import co.whitetree.reactiveprogramming.fluxemit.service.FileReaderService;

import java.nio.file.Path;
import java.nio.file.Paths;

import static co.whitetree.reactiveprogramming.util.Util.faker;
import static co.whitetree.reactiveprogramming.util.Util.subscriber;

public class Emit09FileReaderService {

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderService();

        Path path = Paths.get("src/main/resources/file/fluxemit/file01.txt");
        fileReaderService.read(path)
                .map(s -> {
                    Integer integer = faker().random().nextInt(0, 10);
                    if (integer > 8) throw new RuntimeException("oops");
                    return s;
                })
                .take(15)
                .subscribe(subscriber());
    }
}
