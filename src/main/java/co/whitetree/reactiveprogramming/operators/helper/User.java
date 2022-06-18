package co.whitetree.reactiveprogramming.operators.helper;

import co.whitetree.reactiveprogramming.util.Util;
import lombok.Data;

@Data
public class User {
    private int userId;
    private String name;

    public User(int userId) {
        this.userId = userId;
        this.name = Util.faker().name().fullName();
    }
}
