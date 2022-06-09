package co.whitetree.reactiveprogramming.flux;

import co.whitetree.reactiveprogramming.flux.helper.NameGenerator;

import static co.whitetree.reactiveprogramming.util.Util.onNext;

public class Flux07fluxVsList {
    public static void main(String[] args) {
        // 5초가 지나고 나서 완성된 List 가 반환됨
//        List<String> names = NameGenerator.getNames(5);
//        System.out.println(names);

        // 1초에 한 개의 원소가 출력됨
        NameGenerator.getNames(5)
                .subscribe(onNext());
    }
}
