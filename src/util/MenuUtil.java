
package util;

import main.PersonData;

/**
 * @author Yusif
 */
public class MenuUtil {

    public static void processMenu(int selectedMenu) {
        if (selectedMenu == 1) {
            System.out.println("Add person");
            PersonUtil.registerPersons();
        } else if (selectedMenu == 2) {
            System.out.println("List Person");
            PersonUtil.printAllRegisteredPersons();
        } else if (selectedMenu == 3) {
            if (PersonData.persons == null) {
                return;
            }
            PersonUtil.findPersonAndPrint();

        } else if (selectedMenu == 4) {
            System.out.println("Sort Person");

        } else if (selectedMenu == 5) {
            PersonUtil.updatePerson();
        } else if (selectedMenu == 6) {
            System.out.println("Delete Person");
            PersonData.persons = null;


        } else if (selectedMenu == 7) {
            MenuUtil.showSuccesMessage();
            System.exit(0);
        }

    }

    public static String requireName() {
        return InputUtil.requireText("enter name");
    }

    public static String requireSurname() {
        return InputUtil.requireText("enter surname");
    }

    public static int requireAge() {
        return InputUtil.requireNumber("enter age");
    }

    public static void showSuccesMessage() {
        System.out.println("Operation completed succesfull");
    }

}
