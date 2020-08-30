/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import contapp.utilty;

/**
 *
 * @author ramo828
 */
public class useradd extends utilty {

    private static final StringBuffer sb = new StringBuffer();
    private static String userList;
    private static final Scanner sc = new Scanner(System.in);
    private static final List list = new ArrayList();
    private static int counter = 0;

    public useradd() {

    }

    public static void addUserList(String[] name_surname) { // Sisteme telebe elave edir
        for (int i = 0; i < name_surname.length; i++) {
            userList = sb.append("\t").append("[").append(i).append("] ").append(name_surname[i]).append("\n").toString();
        }
        counter++;
        sb.append("\t---------******").append(counter).append("******---------\n");
    }

    public static String getUserList() {
        return userList;
    }

    public static void add(int value) {           //sisteme telebe elave edir 2
        print("Telebelerin adini ve soyadini daxil edin: ");
        print("Daxil etmeni deyandirmaq ucun < | > isaresinden istifade edin");
        for (int i = 0 + maxNumb(); i < value + maxNumb(); i++) {
            String data = scanf(sc);
            if (data.equals("|")) {
                break;
            }
            list.add(data);
        }
    }

    public static void read() {             //Sistemde yuklu olan telebeleri siralayir
        String s[] = new String[list.size()];   ///////////////dd
        if (s == null) {
            return;
        }
        for (int i = 0; i <= list.size() - 1; i++) {     ///////////////////
            s[i] = (String) list.get(i);
        }
        if (s.length != 0) {
            addUserList(s);
        } else {
            System.gc();
            error(1);
            setErrorMsg("\n\n\n\n\t***Telebe siyahisi bosdur!***");
        }

    }

    private static void delete(int id) {  //ID sirasina gore sistemden silir
        if (!list.isEmpty() || list.size() == 0) {
            print("\t\t***" + id + "-Nomreli telebe sistemden silindi***");
            list.remove(id);
        } else {
            error("Daxil etdiyiniz ID-e uygun telebe tapilmadi!", false);
        }
    }

    private static void deleteAll() { //butun siyahini temizleyir
        if (!list.isEmpty()) {
            print("\t\t***Butun telebeler silindi***");
            list.clear();
        } else {
            error("Telebe siyahisi yoxdur!", false);
        }
    }

    public static void DeleteDb(int all) {
        if (all != -1) {  //all -1 deyilse all deyerine uygun id sil
            delete(all);
        } else {          //all -1 ise sistemden herkesi sil
            deleteAll();
        }
    }

    public static void userListNumber() {  //Sistemde olan telebelerin sayini gosterir
        int maxUser = list.size();
        String maxu = String.valueOf(maxUser);
        print("\t----------" + "[" + maxu + "]" + "----------\n");
    }

    public static int maxNumb() { //max list
        return list.size();
    }

    public static List getList() {
        return list;
    }

}
