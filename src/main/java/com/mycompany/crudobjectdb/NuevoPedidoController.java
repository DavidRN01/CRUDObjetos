/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudobjectdb;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import models.Carta;
import models.Pedido;
/**
 * FXML Controller class
 *
 * @author DavidRamosNavas
 */
public class NuevoPedidoController implements Initializable {


    @FXML
    private TextField txtNombre;
    @FXML
    private Button btnAceptar;
    @FXML
    private TableView<Carta> tabla;
    @FXML
    private TableColumn<Carta, Long> colID;
    @FXML
    private TableColumn<Carta, String> colNombre;
    @FXML
    private TableColumn<Carta, Double> colPrecio;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        actualizar();
        
    }
    
    private void actualizar() {
        
        EntityManager em = EntityManagerFactory.getEmfc().createEntityManager();
        
        TypedQuery<models.Carta> q = em.createQuery("SELECT c FROM Carta c", models.Carta.class);
        var resultado = q.getResultList();
        
        ObservableList<Carta> contenido = FXCollections.observableArrayList();
        tabla.setItems(contenido);

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        
        contenido.addAll(resultado);
        
    }

    @FXML
    private void aceptar(ActionEvent event) {
        
        Carta productoSeleccionado = tabla.getSelectionModel().getSelectedItem();
        
        EntityManager em = EntityManagerFactory.getEmfp().createEntityManager();
        
        Pedido p = new Pedido();
        p.setEstado("SIN ENTREGAR");
        java.util.Date ahora = new java.util.Date();
        java.sql.Date fecha = new java.sql.Date(ahora.getTime());
        p.setFecha(fecha);
        p.setNombre(txtNombre.getText());
        p.setPrecio(productoSeleccionado.getPrecio());
        p.setProducto_id(productoSeleccionado.getId());
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        
        try {
            App.setRoot("inicio");
        } catch (IOException ex) {
            Logger.getLogger(NuevoPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
