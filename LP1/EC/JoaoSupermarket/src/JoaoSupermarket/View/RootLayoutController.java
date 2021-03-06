package JoaoSupermarket.View;

import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import JoaoSupermarket.MainApp;
import JoaoSupermarket.Data.ManageFile;

/*
 * Controller for the Root Layout (Ra�z do Layout [Configura��o da Tela])
 * Provides a bar with some actions to help the user during the application use
 */
public class RootLayoutController {

	// Reference to the MainApp
	private MainApp mainApp;

	// Method called by the MainApp to give a reference back to itself
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	// Creates an empty Produto list
	@FXML
	private void gerenciarNovo() {
		mainApp.getProdutosDados().clear();
		ManageFile.setProdutoFilePath(null, mainApp);
	}

	@FXML
	private void gerenciarAbrir() {
		FileChooser fc = new FileChooser();

		// Setting the extension filter
		FileChooser.ExtensionFilter extFilter =
				new FileChooser.ExtensionFilter("Arquivos XML (*.xml)", "*.xml");
		fc.getExtensionFilters().add(extFilter);

		// Show open file dialog
		File file = fc.showOpenDialog(mainApp.getPrimaryStage());

		if(file != null) {
			ManageFile.loadProdutoDataFromFile(file, mainApp);
		}
	}

	/*
	 * Saves the file to the Produto file path that is currently open
	 * If there is no open file, the "Salvar Como..." dialog is shown
	 */
	@FXML
	private void gerenciarSalvar() {
		File produtoFile = ManageFile.getProdutoFilePath();
		if(produtoFile != null) {
			ManageFile.saveProdutoDataToFile(produtoFile, mainApp);
		}
		else {
			gerenciarSalvarComo();
		}
	}

	/*
	 * Open a dialog to help the user to choose a directory to save the file to
	 */
	@FXML
	private void gerenciarSalvarComo() {
		FileChooser fc = new FileChooser();

		// Setting the extension filter
		FileChooser.ExtensionFilter extFilter =
						new FileChooser.ExtensionFilter("Arquivos XML (*.xml)", "*.xml");
		fc.getExtensionFilters().add(extFilter);

		// Show save file dialog
		File file = fc.showSaveDialog(mainApp.getPrimaryStage());

		if(file != null) {
			// Make sure the file has the correct extension
			if(!file.getPath().endsWith(".xml")) {
				file = new File(file.getPath() + ".xml");
			}
			ManageFile.saveProdutoDataToFile(file, mainApp);
		}
	}

	// Open an about (Sobre) dialog to show information to the user
	@FXML
	private void gerenciarSobre() {
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Vendinha do Seu Jo�o");
        alert.setHeaderText("Sobre");
        alert.setContentText("Autor Principal: Marco Jakob\nWebsite: http://code.makery.ch\n\n" +
        		"Autor desta vers�o: Lucas Viana\nEstudante do IFSP e Escola SENAI de Inform�tica\n" +
        		"17 de Junho de 2017");
        // Method to show the dialog to the user
        alert.showAndWait();
	}

	@FXML
	private void gerenciarFechar() {
		System.exit(0);
	}
}
