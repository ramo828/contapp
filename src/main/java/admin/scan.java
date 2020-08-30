/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import admin.useradd;
import java.util.List;
import java.util.Scanner;
import contapp.utilty;

/**
 *
 * @author ramo828
 */
public class scan extends utilty {

    public static List list = admin.useradd.getList();
    private static Scanner sc = new Scanner(System.in);

    public scan() {

    }

    public static void searchID() {
        print("Telebenin ID-ni daxil edin: ");
        int id = scanfInt(sc);
        if (list.size() <= id) {
            error("\n\t***Sistemde bele ID movcud deyil!***", true);
        }
        print("\n\t*** [" + id + "] " + (String) list.get(id) + " ***");
    }

    public static int setUserID() {
        print("ID - ni daxil edin: ");
        int id = scanfInt(sc);
        if (list.size() <= id) {
            error("\n\t***Sistemde bele ID movcud deyil!***", true);
        }
        return id;
    }

    public static void setUserName(int id) {
        sc = new Scanner(System.in);
        print("Telebenin adini yazin: ");
        String userData = scanf(sc);
        list.set(id, userData);
    }

    public static void setUser() {
        int id = setUserID();
        if (list.size() <= id) {
            error("\n\t***Sistemde bele ID movcud deyil!***", true);
        }
        setUserName(id);
    }

    private static void nameSearch(String name) {
        boolean flag = true;
        if (!(list.size() == 0)) {
            String s[] = new String[list.size()];
            for (int i = 0; i <= list.size() - 1; i++) {     ///////////////////
                s[i] = (String) list.get(i);
                if (s[i].equalsIgnoreCase(name)) {
                    //Deyisilen setir
                    print("\n\t***Neticeye uygun olanlar***");
                    flag = false;
                    print("\n\t*** [" + i + "] " + s[i] + " ***");
                }
                flag = true;
                if (!flag) {
                    print("\n\t***Netice tapilmadi***");
                }

            }
        }
    }

    public static void searchUser() {
        sc = new Scanner(System.in);
        print("Telebenin adini yazin: ");
        String userName = scanf(sc);
        if (userName.isEmpty()) {
            error("\n\t***Axtarish metni bosh ola bilmez!***", true);
        }
        nameSearch(userName.toLowerCase());
    }

    public static String searchLastName(String search) {
        int surn = search.indexOf(" ");
        String LastName = search.substring(surn + 1, search.length());
        return LastName;
    }

    public static boolean fullSearch(String name) {
        String ss[] = new String[list.size()];
        for (int i = 0; i <= list.size() - 1; i++) {
            ss[i] = (String) list.get(i);
        }
        for (int ii = 0; ii <= list.size() - 1; ii++) {
            if (ss[ii].toLowerCase().equalsIgnoreCase(searchLastName(name))) {
                return true;
            }
        }

        return false;

    }
}
