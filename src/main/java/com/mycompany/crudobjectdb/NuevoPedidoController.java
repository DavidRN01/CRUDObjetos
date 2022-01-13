/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudobjectdb;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private TableView<?> tabla;
    @FXML
    private TableColumn<?, ?> colID;
    @FXML
    private TableColumn<?, ?> colNombre;
    @FXML
    private TableColumn<?, ?> colPrecio;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
