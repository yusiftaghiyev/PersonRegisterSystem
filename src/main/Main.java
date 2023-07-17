
package main;

import util.InputUtil;
import util.MenuUtil;

/**
 * @author Yusif
 */
public class Main {
    public static void main(String[] args) {

        int menu = 0;
        while (true) {

            menu = InputUtil.requireNumber("Menudan seciminizi edin:"
                    + "\n1.Add Person."
                    + "\n2.Show All Persons."
                    + "\n3.Find Persons."
                    + "\n4.Sort Persons."
                    + "\n5.Update Persons"
                    + "\n6.Delete Persons"
                    + "\n7.System Exit");
            MenuUtil.processMenu(menu);
        }

    }

}
