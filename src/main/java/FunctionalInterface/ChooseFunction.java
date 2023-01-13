package FunctionalInterface;

import java.util.Random;

public class ChooseFunction {
    protected static class Person{
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    protected static class DataLoader {
        protected NoArgFunction<Person> loadPerson;

        public DataLoader(Boolean isDevelopment) {
            System.out.println("Development = " + isDevelopment);
            this.loadPerson = isDevelopment ? this::loadPersonReal : this::loadPersonFake;
        }

        private Person loadPersonReal() {
            System.out.println("Real Person Loading... {}");
            return new Person(34, "RealName");
        }
        private Person loadPersonFake(){
            System.out.println("Fake Person Loading...");
            return new Person(-100, "FakeName");
        }


    }
    public static void main(String[] args) {
        DataLoader dataLoader = new DataLoader(new Random().nextBoolean());
        System.out.println(dataLoader.loadPerson.apply());
    }
}
