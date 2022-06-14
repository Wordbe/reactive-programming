package co.whitetree.reactiveprogramming.operators;

import reactor.core.publisher.Flux;

import static co.whitetree.reactiveprogramming.util.Util.subscriber;

public class Op04LimitRate {
    public static void main(String[] args) {
        Flux.range(1, 1000)
                .log()
                /**
                 * 첫번쨰요청에서 100개만 요청 request(100)
                 * 90번째까지만 소비하고(drain), request(90) 요청을 보낸다.
                 * 이후 90개씩만 받고 request(90) 요청 보내는 것을 반복한다.
                 */
                .limitRate(100, 90) // lowTide default 75%
                .subscribe(subscriber());


    }
}
