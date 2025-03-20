import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private OptionalInt age;
    private String address = "";

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        // Проверка идет в билдере. Но в задании конструктор открыт, значит тут она тоже должна быть.
        if (age >= 0 && age <= 100) {
            this.age = OptionalInt.of(age);
        } else {
            throw new IllegalArgumentException("Передан недопустимы возраст");
        }
    }

    public boolean hasAge() {
        return this.age != null && this.age.isPresent();
    }

    public boolean hasAddress() {
        return !this.address.isEmpty();
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public OptionalInt getAge() {
        return this.age != null ? this.age : OptionalInt.empty();
    }

    public String getAddress() {
        return this.hasAddress() ? this.address : "Адрес отсутствует";
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (this.hasAge()) {
            this.age = OptionalInt.of(this.age.getAsInt() + 1);
        }
    }

    public PersonBuilder newChildBuilder() {
        // Зачем в условии возраст ребенка??? И какой он должен быть???
        PersonBuilder child = new PersonBuilder().setSurname(this.surname).setAge(0);
        if (!this.address.isEmpty()) {
            child.setAddress(this.address);
        }
        return child;
    }

    @Override
    public String toString() {
        return "Имя: " + this.name + " " + this.surname
                + (this.hasAge() ? ", возраст: " + this.age.getAsInt() : "")
                + (this.hasAddress() ? ", адрес: " + this.address : "");
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = result + (surname != null ? surname.hashCode() : 0);
        return result;
    }
}
