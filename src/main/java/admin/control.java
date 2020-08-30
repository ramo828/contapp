/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.util.Scanner;
import contapp.utilty;

public class control extends utilty {

    static Scanner sc = new Scanner(System.in);
    public static int run = 1;
    public static int unrun = 0;
    private static String userData;
    private static String userName = "admin";
    private static String userPass = "ramiz1234";

    public control(int i) {
        if (i != 0) {
            init();
        }
    }

    public control(String login, String pass) {
        while (!(login.length() == 4 && pass.length() == 10)) {
            if (userName.equals(login) && userPass.equals(pass)) {
                panel ap = new panel(true);
            } else {
                failAccess();
                init();
            }
        }
        print("Login ve ya parol heddinden artiq uzundur!");
    }

    public static void setUserName(String userName) {
        control.userName = userName;
    }

    public static void setUserPass(String userPass) {
        control.userPass = userPass;
    }

    private void failAccess() {
        print("Giris elde olunmadi!\nSifre ve ya login yalnisdir!");
    }

    public static void init() {
        Label();
        print("Login: ");
        String login = scanf(sc);
        print("Parol: ");
        String pass = scanf(sc);
        control c = new control(login, pass);
    }

    private String getUserName() {
        return userName;
    }

    private String getUserPass() {
        return userPass;
    }

    public void showAccess(boolean cont) {
        print("User: " + getUserName() + "\n" + "Password: " + getUserPass());
        if (cont) {
            quit_or_back(false);
        }

    }

    public void setAccess() {
        print("New User: ");
        String user = scanf(sc);
        setUserName(user);
        print("New Password: ");
        String pass = scanf(sc);
        setUserPass(pass);
        print("Yeni Login ve Shifre: ");
        showAccess(false);
        init();
    }

    public static void addDbUser() {
        useradd.add(1 + useradd.maxNumb());
    }

    public static void readDbUser() {
        useradd.read();
        userData = useradd.getUserList();
        if ((userData == null)) {
            error("\n\t***Siyahi Bosdur!***", false);
        }
    }

    public static void showDbUser() {
        if (userData == null) {
            return;
        }
        print("\t-----USER-----");
        print("\t---------------\n" + userData + "\t--------------\n");

    }
}
