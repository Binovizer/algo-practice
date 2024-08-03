package algo.practice.v2.general;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The type Coupon
 *
 * @author nadeem Date : 28/07/24
 */
@Data
public class Coupon implements Comparable<Coupon> {
    private String name;
    private LocalDate dateModified;

    public Coupon(String name) {
        this.name = name;
    }

    public Coupon(String name, String dateModified) {
        this.name = name;
        this.dateModified = LocalDate.parse(dateModified, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Override
    public int compareTo(Coupon other) {
        return other.dateModified.compareTo(this.dateModified);
    }

    public boolean isValid() {
        return !isInvalid();
    }

    public boolean isInvalid() {
        return this.dateModified.isAfter(LocalDate.now());
    }
}
