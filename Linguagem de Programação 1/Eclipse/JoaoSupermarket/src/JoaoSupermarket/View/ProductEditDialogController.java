package JoaoSupermarket.View;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.time.LocalDate;
import JoaoSupermarket.Model.Produto;
import JoaoSupermarket.Util.DateUtil;

public class ProductEditDialogController {
	@FXML
	private TextField produtoField;
	@FXML
	private TextField categoriaField;
	@FXML
	private TextField dataDeValidField;
	@FXML
	private TextField estoqueField;
	@FXML
	private TextField estoqueMinField;

	private Stage dialogStage;
	private Produto produto;
	private boolean clicouOK = false;

	// This method is automatically called after the FXML has been loaded
	@FXML
	private void initialize() {
	}

	// Set the Stage of this dialog
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	// Set the Produto to be edited on the dialog
	public void setProduto(Produto produto) {
		this.produto = produto;

		produtoField.setPromptText("Nome do Produto");
		categoriaField.setPromptText("Categoria do Produto");
		dataDeValidField.setPromptText("dd/mm/yyyy");
		estoqueField.setPromptText("Estoque do Produto");
		estoqueMinField.setPromptText("Estoque Mínimo do Produto");

		if(produto.getNome().length() == 0) {
			estoqueField.setText("");
			estoqueMinField.setText("");
			dataDeValidField.setText("");
		}
		else {
			produtoField.setText(produto.getNome());
			categoriaField.setText(produto.getCategoria());
			dataDeValidField.setText(DateUtil.format(produto.getDataDeValidade()));
			estoqueField.setText(Integer.toString(produto.getEstoque()));
			estoqueMinField.setText(Integer.toString(produto.getEstoqueMinimo()));
		}
	}

	// Method to verify if the user clicked OK, false otherwise
	public boolean clicouOK() {
		return clicouOK;
	}

	// Validate the user input in the text fields
	private boolean isInputValid() {
		String mensagemDeErro = "";
		String excecoesLancadas = "Corrija os erros antes de tentar novamente!\n";
		// Nome
		if(produtoField.getText() == null || produtoField.getText().length() == 0) {
			mensagemDeErro += "• Nome do Produto\n";
		}
		// Categoria
		if(categoriaField.getText() == null || categoriaField.getText().length() == 0) {
			mensagemDeErro += "• Categoria do Produto \n";
		}
		// Data de Validade
		if(dataDeValidField.getText() == null || dataDeValidField.getText().length() == 0) {
			mensagemDeErro += "• Data de Validade do Produto \n";
		}
		else if(!DateUtil.validDate(dataDeValidField.getText())) {
			mensagemDeErro += "O valor informado no campo Data de Validade não é válido! " + DateUtil.getDate_Pattern() + "\n";
		}
		else if(DateUtil.parse(dataDeValidField.getText()).isBefore(LocalDate.now().plusDays(1))) {
			mensagemDeErro += "O valor informado no campo Data de Validade é anterior à data de hoje somado a um dia!\n";
		}
		// Estoque
		if(estoqueField.getText() == null || estoqueField.getText().length() == 0) {
			mensagemDeErro += "Campo de Estoque do Produto está vazio!\n";
		}
		else {
			try {
				if(!(Integer.parseInt(estoqueField.getText()) > 0))
					throw new Exception();
			}
			catch (Exception exc) {
				mensagemDeErro += "O valor informado no campo Estoque não é válido!\n";
				excecoesLancadas += exc.getMessage() + "\n";
			}
		}
		// Estoque Mínimo
		if(estoqueMinField.getText() == null || estoqueMinField.getText().length() == 0) {
			mensagemDeErro += "Campo de Estoque Mínimo do Produto está vazio!\n";
		}
		else {
			try {
				if(!(Integer.parseInt(estoqueMinField.getText()) > 0))
					throw new Exception();
			}
			catch (Exception exc) {
				mensagemDeErro += "O valor informado no campo Estoque Mínimo não é válido!\n";
				excecoesLancadas += exc.getMessage() + "\n";
			}
		}
		// Verifying the Error Message
		if(mensagemDeErro.length() == 0) {
			return true;
		}
		else {
			// Show the error message
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(dialogStage);
			alert.setTitle("Campos inválidos!");
			alert.setHeaderText(mensagemDeErro);
			alert.setContentText(excecoesLancadas);
			// Method called to the actual exhibition
			alert.showAndWait();

			return false;
		}
	}

	// Called when the user clicks OK
	@FXML
	private void gerenciarOK() {
		if(isInputValid()) {
			produto.setNome(produtoField.getText());
			produto.setCategoria(categoriaField.getText());
			produto.setDataDeValidade(DateUtil.parse(dataDeValidField.getText()));
			produto.setEstoque(Integer.parseInt(estoqueField.getText()));
			produto.setEstoqueMinimo(Integer.parseInt(estoqueMinField.getText()));

			// Certifies the OK button is clicked
			clicouOK = true;
			dialogStage.close();
		}
	}

	@FXML
	private void gerenciarCancelar() {
		dialogStage.close();
	}
}