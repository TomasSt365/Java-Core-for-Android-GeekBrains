package Lessons.Lesson5;

public class Main {

    public static void main(String[] args) {

        Person[] personsArr = new Person[5];

        personsArr[0] = new Person("Klimov Sergey", "Department employee",
                "sergey@gmail.com", "(123) 555-0100",
                50000, 23);

        personsArr[1] = new Person("Zorin Andrew", "Teaam Lider",
                "andrew@gmail.com","(123) 555-0100",
                150000 ,30);

        personsArr[2] = new Person("Melnik Julia","Department employee",
                "julia@gmail.com","(123) 555-0100",
                45000,41);

        personsArr[3] = new Person("Kulikov Evgen","Department employee",
                "evgen@gmail.com","(123) 555-0100",
                128000,53);

        personsArr[4] = new Person("Couperin Vadim","director of the company",
                "vadim@gmail.com","(123) 555-0100",
                200000,42);

        for (Person person : personsArr)
            if (person.getAge() > 40) {
                person.printInfo();
                System.out.println();
            }
    }

}
