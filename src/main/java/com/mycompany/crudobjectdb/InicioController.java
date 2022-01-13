/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudobjectdb;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import models.Carta;
import models.Pedido;
/**
 * FXML Controller class
 *
 * @author DavidRamosNavas
 */
public class InicioController implements Initializable {


    @FXML
    private ChoiceBox<String> selector;
    @FXML
    private ImageView btnAñadir;
    @FXML
    private ImageView btnEliminar;
    @FXML
    private TableView<Pedido> tabla;
    @FXML
    private TableColumn<Pedido, Long> colID;
    @FXML
    private TableColumn<Pedido, String> colNombre;
    @FXML
    private TableColumn<Pedido, Double> colPrecio;
    @FXML
    private TableColumn<Pedido, Date> colFecha;
    @FXML
    private TableColumn<Pedido, String> colEstado;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        EntityManager em = EntityManagerFactory.getEmfp().createEntityManager();
        
        TypedQuery<models.Pedido> q = em.createQuery("SELECT p FROM Pedido p", models.Pedido.class);
        var resultado = q.getResultList();
        
//        Carta c1 = new Carta();
//        c1.setNombre("Bollycaos");
//        c1.setPrecio(2.0);
//        Carta c2 = new Carta();
//        c2.setNombre("Kebab");
//        c2.setPrecio(5.0);
//        Carta c3 = new Carta();
//        c3.setNombre("Maguera");
//        c3.setPrecio(10.0);
//        Carta c4 = new Carta();
//        c4.setNombre("Ferrari");
//        c4.setPrecio(1000000.0);
//        Carta c5 = new Carta();
//        c5.setNombre("Pisito en Miami");
//        c5.setPrecio(5000.0);
//        
//        em.getTransaction().begin();
//        em.persist(c1);
//        em.persist(c2);
//        em.persist(c3);
//        em.persist(c4);
//        em.persist(c5);
//        em.getTransaction().commit();
//        
//        Pedido p = new Pedido();
//        p.setEstado("SIN ENTREGAR");
//        java.util.Date ahora = new java.util.Date();
//        java.sql.Date fecha = new java.sql.Date(ahora.getTime());
//        p.setFecha(fecha);
//        p.setNombre("Jackson Aceituno");
//        p.setPrecio(2.0);
//        p.setProducto_id(1L);
//
//        em.getTransaction().begin();
//        em.persist(p);
//        em.getTransaction().commit();
//
//        TypedQuery<models.Carta> q = em.createQuery("SELECT p FROM Pedido p", models.Carta.class);
//        var resultado = q.getResultList();
//        
//        System.out.println(resultado);

        ObservableList<Pedido> contenido = FXCollections.observableArrayList();
        tabla.setItems(contenido);

        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        
        contenido.addAll(resultado);
        
    }    
    
}
