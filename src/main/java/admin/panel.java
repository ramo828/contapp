/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import contapp.utilty;
import java.util.Scanner;


/**
 *
 * @author ramo828
 */
public class panel extends utilty{

    static control co = new control(0);
    static Scanner sc = new Scanner(System.in);
    static boolean access = false;

    public panel(boolean success) {
        if (success) {
            setAccess(true);
            panelControl();
        } else {

        }
    }

    public panel() {
        //  this(false);
    }

    public static void panelControl() {
        if (access) {
            print("\t---Sisteme giris elde etdiniz---");
        }
        print("\n1 - Yeni telebe elave et\n"
                + "2 - Telebe siyahisini oxu\n"
                + "3 - DB -dan Telebe sil\n"
                + "4 - DB -dan herkesi sil\n"
                + "5 - DB-da olan telebelerin sayi\n"
                + "6 - ID - ile axtar\n"
                + "7 - Adi ile axtar\n"
                + "8 - Telebenin melumatlarini deyish\n"
                + "9 - Ayarlar\n"
                + "10 - Haqqinda\n"
                + "0 - Cixish\n");
        gotoFunc(scanfInt(sc));

    }

    private static void gotoFunc(int go) {
        switch (go) {
            case 0:
                quit_or_back(true);
                break;
            case 1:
                control.addDbUser();
                dntLabel(true);

                break;
            case 2:
                control.readDbUser();
                control.showDbUser();
                print("\t\t--------------------------");
                utilty.dntLabel(true);
                break;
            case 3:
                deleteUser(false);
                dntLabel(true);

                break;
            case 4:
                deleteUser(true);
                dntLabel(true);

                break;
            case 5:
                print("\t***DB-da telebelirin sayi***");
                useradd.userListNumber();
                dntLabel(true);
                break;
            case 6:
                scan.searchID();
                dntLabel(true);

                break;
            case 7:
                scan.searchUser();
                dntLabel(true);
                break;

            case 8:
                scan.setUser();
                dntLabel(true);

                break;
            case 9:
                settings();
                break;
            case 10:
                about();
                dntLabel(true);
                break;
            default:
                error(0);
                dntLabel(true);
        }
    }

    private static void gotoFunc2(int go) {
        switch (go) {
            case 0:
                quit_or_back(false);
                break;
            case 1:
                co.showAccess(true);
                break;
            case 2:
                co.setAccess();
                break;
            case 3:
            default:
                error(0);
                dntLabel(false);
        }
    }

    public static void settings() {
        print("\n1 - parola bax\n"
                + "2 - parolu deyish\n"
                + "0 - Geriye\n");
        gotoFunc2(scanfInt(sc));

    }

    public static void setAccess(boolean access) {
        panel.access = access;
    }

    public static void deleteUser(boolean or) {
        if (!or) {
            print("Silmek istediyiniz telebenin ID-ni daxil edin: ");
            int id = scanfInt(sc);
            useradd.DeleteDb(id);
        } else {
            useradd.DeleteDb(-1);
        }

    }
}
