package co.whitetree.reactiveprogramming.mono;

import co.whitetree.reactiveprogramming.mono.file.FileService;

import static co.whitetree.reactiveprogramming.util.Util.*;

public class Mono09FileService {
    public static void main(String[] args) {
        FileService.read("file04.txt")
                .subscribe(onNext(), onError(), onComplete());

        FileService.write("file03.txt", "This is file3")
                .subscribe(onNext(), onError(), onComplete());

        FileService.delete("file03.txt")
                .subscribe(onNext(), onError(), onComplete());
    }
}
