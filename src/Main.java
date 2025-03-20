public class Main {
    public static void main(String[] args) {

        Person human1 = new PersonBuilder()
                .setName("Петя")
                .setSurname("Иванов")
                .build();
        System.out.println(human1);
        System.out.println(human1.getAge());

        Person human2 = new PersonBuilder()
                .setName("Иван")
                .setSurname("Сидоров")
                .setAge(20)
                .build();
        System.out.println(human2);
        human2.happyBirthday();
        System.out.println(human2);

        Person daughter = human2.newChildBuilder()
                .setName("Иришка")
                .setAge(2)
                .build();
        // С падежами беда, нужно поле "пол" и то, не факт, что будет корректно
        System.out.println("У " + human2 + " есть дочь, " + daughter);

        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        System.out.println(mom);
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

//        try {
//            // Не хватает обязательных полей
//            new PersonBuilder().build();
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}