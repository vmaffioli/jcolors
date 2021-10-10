package com.vmaffioli.jcolors;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.vmaffioli.jcolors.App;
import com.vmaffioli.jcolors.model.DatabaseConnectionModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.Hyperlink;

public class LoginController {

	@FXML
	private Button loginButton;

	@FXML
	private Label signinMessageLabel;

	@FXML
	private TextField useremailTextField;

	@FXML
	private PasswordField passwordPasswordField;

	@FXML
	private Hyperlink createAccountLink;

	@FXML
	private Label useremailLabel;
	
	@FXML
	private Button guestButton;

	public void loginButtonOnAction(ActionEvent e) throws IOException {

		// validations
		if ((useremailTextField.getText().isEmpty()) && (passwordPasswordField.getText().isEmpty())) {

			signinMessageLabel.setText("Please provide your username and password.");

		} else {

			if (validateLogin()) {
				goLogged();
			} else {
				signinMessageLabel.setText("Invalid login, please try again.");

			}
			;
		}
		;
	}

	public boolean validateLogin() {
		boolean result = false;

		DatabaseConnectionModel connectNow = new DatabaseConnectionModel();
		Connection connectDB = connectNow.getConnection();

		String verifyLogin = "SELECT count(1) FROM users WHERE username = '" + useremailTextField.getText()
				+ "' AND password = '" + passwordPasswordField.getText() + "'";

		try {

			Statement statement = connectDB.createStatement();
			ResultSet queryResult = statement.executeQuery(verifyLogin);

			while (queryResult.next()) {
				if (queryResult.getInt(1) == 1) {
					result = true;
				} else {
					result = false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public void createAccountOnAction() {
		goSignup();
	}

	public void goLogged() {
			App.loadScene("MainScreenNotLogged", "JColors - Guest", "640x600");

	}

	public void goSignup() {
		App.loadScene("LoginScreen", "arrumar", "640x440");

	}
	
	public void goGuest() {
			App.loadScene("MainScreenNotLogged", "JColors - Guest", "640x600");

	}

}