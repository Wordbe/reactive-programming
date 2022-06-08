package co.whitetree.reactiveprogramming.mono;

import co.whitetree.reactiveprogramming.util.Util;
import reactor.core.publisher.Mono;

import static co.whitetree.reactiveprogramming.util.Util.*;

public class Mono08MonoFromRunnable {

    public static void main(String[] args) {

//         Time consuming job
//        Runnable runnable = () -> System.out.println("run");

        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(onNext(), onError(), () -> System.out.println("Process is done. Sending emails..."));
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Operation completed");
        };
    }
}
