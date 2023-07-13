
package util;

import main.PersonData;
import beans.Person;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Yusif
 */
public class PersonUtil {

    public static Person fillPersons() {
        String name = MenuUtil.requireName();
        String surname = MenuUtil.requireSurname();
        int age = MenuUtil.requireAge();
        Person person = new Person(name, surname, age);
        try {
            InputOutput.fileWriter("src/main/person.txt", name, surname, age, true);
        } catch (IOException ex) {
            Logger.getLogger(PersonUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person;
    }

    public static void printAllRegisteredPersons() {
        if (PersonData.persons == null) {
            return;

        }
        for (int i = 0; i < PersonData.persons.length; i++) {
            Person person = PersonData.persons[i];
            System.out.println((i + 1) + "." + person.getFullInfo());
            try {
                InputOutput.fileReader("src/main/person.txt");
            } catch (IOException ex) {
                Logger.getLogger(PersonUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void registerPersons() {
        int count = InputUtil.requireNumber("Nece nefer qeydiyyatdan kececek?");
        PersonData.persons = new Person[count];

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ".Register");

            PersonData.persons[i] = PersonUtil.fillPersons();

        }
        MenuUtil.showSuccesMessage();
        // PersonUtil.printAllRegisteredPersons();
    }

    public static void findPersonAndPrint() {
        String text = InputUtil.requireText("type name,surname:");
        Person[] result = findPersons(text);
        for (int i = 0; i < result.length; i++) {

            System.out.println(result[i].getFullInfo());

        }

    }

    public static Person[] findPersons(String text) {
        int count = 0;
        for (int i = 0; i < PersonData.persons.length; i++) {
            Person persons = PersonData.persons[i];
            if (persons.getName().contains(text) || persons.getSurname().contains(text)) {
                count++;
            }

        }
        Person[] result = new Person[count];
        int found = 0;
        for (int i = 0; i < PersonData.persons.length; i++) {
            Person persons = PersonData.persons[i];
            if (persons.getName().contains(text) || persons.getSurname().contains(text)) {
                result[found] = persons;
                found++;
            }

        }
        return result;
    }

    public static void updatePerson() {
        PersonUtil.printAllRegisteredPersons();
        int index = InputUtil.requireNumber("Necenci adamda deyisiklik etmek isteyirsiz?");
        System.out.println("Yeni melumatlari daxil edin");
        Person selectedPerson = PersonData.persons[index - 1];

        String changeParams = InputUtil.requireText("Neleri deyismek isteyirsiz? mes:'name','surname','age'");

        String[] parameters = changeParams.split(",");

        for (int i = 0; i < parameters.length; i++) {
            String param = parameters[i];

            if (param.equalsIgnoreCase("name")) {
                selectedPerson.setName(MenuUtil.requireName());
            } else if (param.equalsIgnoreCase("surname")) {
                selectedPerson.setSurname(MenuUtil.requireSurname());
            } else if (param.equalsIgnoreCase("age")) {
                selectedPerson.setAge(MenuUtil.requireAge());

            }
        }
    }

    public static void deletePerson() {
        PersonData.persons = null;
    }
}
