import java.time.LocalDate;

public class Vaccination {
    private LocalDate date;
    private String producer;
    private String name;

    public Vaccination(LocalDate date, String producer, String name) {
        this.date = date;
        this.producer = producer;
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getProducer() {
        return producer;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Vaccination [date=" + date + ", producer=" + producer + ", name=" + name + "]";
    }
}
