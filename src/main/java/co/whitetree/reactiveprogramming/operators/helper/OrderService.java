package co.whitetree.reactiveprogramming.operators.helper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    private static final Map<Integer, List<PurchaseOrder>> db = new HashMap<>();

    static {
        List<PurchaseOrder> list1 = Arrays.asList(
                PurchaseOrder.of(1),
                PurchaseOrder.of(1),
                PurchaseOrder.of(1)
        );
        List<PurchaseOrder> list2 = Arrays.asList(
                PurchaseOrder.of(2),
                PurchaseOrder.of(2)
        );
        db.put(1, list1);
        db.put(2, list2);
    }

    public static Flux<PurchaseOrder> getOrders(int userId) {
        return Flux.create((FluxSink<PurchaseOrder> purchaseOrderFluxSink) -> {
            db.get(userId).forEach(purchaseOrderFluxSink::next);
            purchaseOrderFluxSink.complete();
        }).delayElements(Duration.ofSeconds(1));
    }
}
