/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contapp;

import admin.control;
import admin.scan;
import admin.useradd;
import static contapp.utilty.print;
import java.util.List;

public class Main extends utilty {

    public static void main(String[] args) {
control c = new control(control.run);
print(useradd.getUserList());

        

    }
    
}
