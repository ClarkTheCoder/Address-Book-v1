package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewPersonController {
	
	@FXML private TextField firstNameField, lastNameField, phoneField, cityField, postalField, emailField;
	
	private Stage stage;
	private Main main;
	private Person person;
	
	private Boolean confirmedClicked = false;
	
	public void setMain(Main main, Stage stage, Person person) {
		this.main = main;
		this.stage = stage;
		this.person = person;
		if(person != null) {
			fillPersonDetails();
		}
	}
	
	public boolean isConfirmedClicked(){
		return confirmedClicked;
	}
	
	public void fillPersonDetails(){
		firstNameField.setText(person.getFirstName());
		lastNameField.setText(person.getLastName());
		phoneField.setText(person.getPhone());
		cityField.setText(person.getCity());
		postalField.setText(person.getPostalCode());
		emailField.setText(person.getEmail());
	}
	
	@FXML 
	public void handleConfirm() {
		if (person != null){
			person.setFirstName(firstNameField.getText());
			person.setLastName(lastNameField.getText());
			person.setPhone(phoneField.getText());
			person.setCity(cityField.getText());
			person.setPostalCode(postalField.getText());
			person.setEmail(emailField.getText());
			confirmedClicked = true;
		} else {
		Person newPerson = new Person(
				firstNameField.getText(),
				lastNameField.getText(),
				phoneField.getText(),
				cityField.getText(),
				postalField.getText(),
				emailField.getText()
				);
		
		main.getPersonData().add(newPerson);
		}
		stage.close();
	}
	
	@FXML 
	public void handelCancel() {
		stage.close();
	}

}
