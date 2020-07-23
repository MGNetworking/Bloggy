package entities;

import java.sql.Timestamp;
import java.util.Objects;

public class Cookie {

    private String cookie;
    private Timestamp timestamp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cookie)) return false;
        Cookie cookie1 = (Cookie) o;
        return Objects.equals(cookie, cookie1.cookie) &&
                Objects.equals(timestamp, cookie1.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cookie, timestamp);
    }
}
