public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private boolean isAge = false;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age >= 0 && age <= 100) {
            this.age = age;
            this.isAge = true;
            return this;
        } else {
            throw new IllegalArgumentException("Передан недопустимы возраст");
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (this.name == null || this.surname == null) {
            throw new IllegalArgumentException("Не хватает обязательных полей");
        }

        Person person;
        if (this.isAge) {
            person = new Person(this.name, this.surname, this.age);
        } else {
            person = new Person(this.name, this.surname);
        }

        if (this.address != null) {
            person.setAddress(this.address);
        }

        return person;
    }
}
