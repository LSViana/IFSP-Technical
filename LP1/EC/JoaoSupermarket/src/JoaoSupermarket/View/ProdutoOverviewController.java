package JoaoSupermarket.View;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import JoaoSupermarket.MainApp;
import JoaoSupermarket.Model.*;
import JoaoSupermarket.Util.DateUtil;

public class ProdutoOverviewController {
	// TableView
	@FXML
	private TableView<Produto> produtoTabela;
	@FXML
	private TableColumn<Produto, String> produtoColuna;
	@FXML
	private TableColumn<Produto, String> categoriaColuna;
	// GridPane
	@FXML
	private Label produtoRotulo;
	@FXML
	private Label categoriaRotulo;
	@FXML
	private Label dataDeValidadeRotulo;
	@FXML
	private Label estoqueAtualRotulo;
	@FXML
	private Label estoqueMinimoAtualRotulo;
	// Reference to the Main Application
	private MainApp mainApp;
	// A standard constructor that is called before the initialize()
	public ProdutoOverviewController() {
		// Nothing here
	}
	/*
	 * Method to initialize the Controller class. This method is automatically called
	 * after the FXML file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Initialize the Produto table with two columns
		produtoColuna.setCellValueFactory(cellData -> cellData.getValue().NomeProperty());
		categoriaColuna.setCellValueFactory(cellData -> cellData.getValue().CategoriaProperty());
		// Clear Product details
		mostrarDetalhesProduto(null);
		// Listen for selection changes and show the Product details when changed
		produtoTabela.getSelectionModel().selectedItemProperty().addListener(
				(observador, velhoValor, novoValor) -> mostrarDetalhesProduto(novoValor));
	}
	/*
	 * It's called by the main application to give back a reference to itself
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Add ObservableList data to the TableView
		produtoTabela.setItems(mainApp.getProdutosDados());
	}

	/*
	 * Fills all text fields to show details about a Product
	 * If the Product passed as argument is null, all labels are cleared
	 */
	public void mostrarDetalhesProduto(Produto produto) {
		if(produto != null) {
			// Fill the labels with info from the produto object
			produtoRotulo.setText(produto.getNome());
			categoriaRotulo.setText(produto.getCategoria());
			dataDeValidadeRotulo.setText(DateUtil.format(produto.getDataDeValidade()));
			estoqueAtualRotulo.setText(Integer.toString(produto.getEstoque()));
			estoqueMinimoAtualRotulo.setText(Integer.toString(produto.getEstoqueMinimo()));
		}
		else {
			// If the object is null, all labels are cleared
			produtoRotulo.setText("");
			categoriaRotulo.setText("");
			dataDeValidadeRotulo.setText("");
			estoqueAtualRotulo.setText("");
			estoqueMinimoAtualRotulo.setText("");
		}
	}
	// Method to delete a Product from the list
	@FXML
	private void deletarProduto() {
		int indiceAtual = produtoTabela.getSelectionModel().getSelectedIndex();
		if(indiceAtual >= 0) {
			produtoTabela.getItems().remove(indiceAtual);
		}
		else {
			// If nothing is selected the returned value from getSelectedIndex() is -1
			// Declare and Instantiate of an Alert object
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Vendinha do Seu Jo�o");
			alert.setHeaderText("N�o havia produto algum selecionado!");
			alert.setContentText("Por favor selecione um produto, se houver, na tabela!");
			// Show the Alert on a pop-up
			alert.showAndWait();
		}
	}
	// Method called when the user clicks "Novo" or "Editar" buttons

	// Method to "Novo" button
	@FXML
	private void gerenciarNovoProduto() {
		Produto tempProduto = new Produto();
		boolean okClicked = mainApp.showProdutoEditDialog(tempProduto);
		if(okClicked) {
			mainApp.getProdutosDados().add(tempProduto);
		}
	}

	// Method to "Editar" button
	@FXML
	private void gerenciarEditarProduto() {
		Produto produtoSelecionado = produtoTabela.getSelectionModel().getSelectedItem();
		if(produtoSelecionado != null) {
			boolean okClicked = mainApp.showProdutoEditDialog(produtoSelecionado);
			if(okClicked) {
				mostrarDetalhesProduto(produtoSelecionado);
			}
		} else {
			// Nothing selected on TableView
			Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("N�o h� sele��o ativa");
	        alert.setHeaderText("N�o existem Produtos selecionados");
	        alert.setContentText("Por favor selecione um produto na tabela antes de tentar edit�-lo!");
	        // Method to the actual exhibition of the alert
	        alert.showAndWait();
		}
	}
}
