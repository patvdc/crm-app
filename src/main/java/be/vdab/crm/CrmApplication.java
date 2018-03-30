package be.vdab.crm;

import be.vdab.crm.entity.Address;

public class CrmApplication {

    public static void main(String[] args) {
        Address a = new Address();
        a.setZipCode("12a76");
        System.out.println(a.getZipCode());
    }
}
