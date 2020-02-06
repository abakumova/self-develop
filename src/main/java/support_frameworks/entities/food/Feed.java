package support_frameworks.entities.food;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

public class Feed {

    private String title;
    @Getter
    @Setter
    private double weight;
    @Getter
    @Setter
    private int calorie;

    public Feed(String title, double weight) {
        this.title = title;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("title", title)
                .append("weight", weight)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feed feed = (Feed) o;
        return Double.compare(feed.weight, weight) == 0 &&
                calorie == feed.calorie &&
                title.equals(feed.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, weight, calorie);
    }
}