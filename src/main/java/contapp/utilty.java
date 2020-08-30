/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contapp;

import admin.panel;
import static admin.panel.panelControl;
import java.util.Scanner;
import admin.panel;
import static admin.panel.panelControl;
import java.util.Scanner;

/**
 *
 * @author ramo828
 */
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author ramo828
 */
public class utilty {

    private static String errorMsg;

    public static void print(String s) {
        System.out.println(s);
    }

    public static String scanf(Scanner s) {
        return s.nextLine();
    }

    public static int scanfInt(Scanner s) {
        return s.nextInt();
    }

    public static void about() {
        print(
                "\t------------------------------------\n"
                + "\tBu program 23 Avqust 23:28 tarixlerinde\n"
                + "\tMemmedli Ramiz Terefinden telebe ve\n"
                + "\tMuellimlerin ishlerini sadeleshdirmek meqsedi\n"
                + "\tile hec bir maddi deyer gudmeden temannasiz \n"
                + "\tshekilde hazirlanmisdir\n"
                + "\t------------------------------------\n"
                + "\t\t#########RamoSoft#########");
    }

    public static void quit_or_back(boolean or) {
        if (or) {
            System.exit(0);
        } else {
            dntLabel(true);
        }
    }

    public static void error(int err) {
        switch (err) {
            case 0:
                panel.setAccess(false);
                utilty.print("Sehv emir daxil etdiniz");
                break;
            case 1:
                print(errorMsg);
                break;
            default:
                panel.setAccess(false);
                utilty.print("xeta!");
        }
    }

    public static void setErrorMsg(String errorMsg) {
        utilty.errorMsg = errorMsg;
    }

    public static void error(String setErrors, boolean status) {
        setErrorMsg(setErrors);
        error(1);
        if (status) {
            quit_or_back(false);
        }
    }

    public static void dntLabel(boolean or) { //Setting or main menu
        if (or) {
            panel.setAccess(false);
            panelControl();
        } else {
            panel.setAccess(false);
            panel.settings();
        }
    }

    public static void Label() {
        print("\n\tTelebe melumat bazasina xosh gelmisiniz\n"
                + "\tZehmet olmasa shexsi melumatlarinizi\n"
                + "\tdaxil edin.\n");
    }
}


