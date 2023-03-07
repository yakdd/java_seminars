import java.time.LocalDate;
import java.util.ArrayList;

public class Cat {
    private String name; // кличка
    private String owner; // хозяин
    private String breed; // порода
    private String color; // окрас
    private LocalDate birthday;
    private ArrayList<Vaccination> vaccinations = new ArrayList<>();

    public Cat(String name, String owner, String breed, String color, LocalDate birthday) {
        this.name = name;
        this.owner = owner;
        this.breed = breed;
        this.color = color;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nCat [name=" + name + ", owner=" + owner + ", breed=" + breed + ", color=" + color + ", birthday="
                + birthday + ", vaccination=" + vaccinations + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBreed() {
        return breed;
    }

    public String getColor() {
        return color;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void addVaccinationt(Vaccination vaccination) {
        vaccinations.add(vaccination);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Cat)) {
            return false;
        }
        Cat other = (Cat) obj;
        return this.name.equals(other.name) && this.owner.equals(other.owner) && this.breed.equals(other.breed);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((breed == null) ? 0 : breed.hashCode());
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
        result = prime * result + ((vaccinations == null) ? 0 : vaccinations.hashCode());
        return result;
    }
}