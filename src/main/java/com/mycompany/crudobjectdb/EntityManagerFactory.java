/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudobjectdb;

import javax.persistence.Persistence;

/**
 *
 * @author DavidRamosNavas
 */
public class EntityManagerFactory {
    
    private static javax.persistence.EntityManagerFactory emfp;
    
    static {
        try {
            emfp = Persistence.createEntityManagerFactory("pedidos.odb");
        } catch(Exception ex) {
            System.out.println("Error al iniciar EntityManagerFactory");
        }
    }
    
    private static javax.persistence.EntityManagerFactory emfc;
    
    static {
        try {
            emfc = Persistence.createEntityManagerFactory("carta.odb");
        } catch(Exception ex) {
            System.out.println("Error al iniciar EntityManagerFactory");
        }
    }

    public static javax.persistence.EntityManagerFactory getEmfp() {
        return emfp;
    }

    public static javax.persistence.EntityManagerFactory getEmfc() {
        return emfc;
    }
    
}
