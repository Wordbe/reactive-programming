package co.whitetree.reactiveprogramming.operators;

import co.whitetree.reactiveprogramming.operators.helper.OrderService;
import co.whitetree.reactiveprogramming.operators.helper.UserService;
import co.whitetree.reactiveprogramming.util.Util;

public class Op12FlatMap {
    public static void main(String[] args) {
        UserService.getUsers()
//                .map(user -> OrderService.getOrders(user.getUserId())) // Flux<Flux<PurchaseOrder>>
                .flatMap(user -> OrderService.getOrders(user.getUserId())) // Flux<PurchaseOrder>
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
