/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudobjectdb;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    @FXML
    private Button btnTodo;
    @FXML
    private Button btnPendientes;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        añadirHandlers();
        actualizar();
        
    }
    
    private void añadirHandlers() {

        btnEliminar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
                Pedido pedidoSeleccionado = tabla.getSelectionModel().getSelectedItem();
                
                EntityManager em = EntityManagerFactory.getEmfp().createEntityManager();
                
                Pedido p = em.find(Pedido.class, pedidoSeleccionado.getId());

                em.getTransaction().begin();
                em.remove(p);
                em.getTransaction().commit();
                
                actualizar();
                
            }
        });
        
        btnAñadir.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                
                try {
                    App.setRoot("nuevoPedido");
                } catch (IOException ex) {
                    Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
        
        tabla.setRowFactory( tv -> {
            TableRow<Pedido> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Pedido pedidoSeleccionado = tabla.getSelectionModel().getSelectedItem();
                
                    EntityManager em = EntityManagerFactory.getEmfp().createEntityManager();

                    Pedido p = em.find(Pedido.class, pedidoSeleccionado.getId());

                    em.getTransaction().begin();
                    p.setEstado("RECOGIDO");
                    em.getTransaction().commit();

                    actualizar();
                }
            });
            return row ;
        });
        
    }
    
    private void actualizar() {
        
        EntityManager em = EntityManagerFactory.getEmfp().createEntityManager();
        
        TypedQuery<models.Pedido> q = em.createQuery("SELECT p FROM Pedido p", models.Pedido.class);
        var resultado = q.getResultList();
        
        ObservableList<Pedido> contenido = FXCollections.observableArrayList();
        tabla.setItems(contenido);

        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        
        contenido.addAll(resultado);
        
    }

    @FXML
    private void todo(ActionEvent event) {
        
        actualizar();
        
    }

    @FXML
    private void pendientes(ActionEvent event) {
        
        EntityManager em = EntityManagerFactory.getEmfp().createEntityManager();
        
        TypedQuery<models.Pedido> q = em.createQuery("SELECT p FROM Pedido p WHERE estado = 'SIN ENTREGAR'", models.Pedido.class);
        var resultado = q.getResultList();
        
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
