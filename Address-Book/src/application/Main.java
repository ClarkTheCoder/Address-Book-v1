package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private Stage primaryStage; 
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		mainWindow();
	}
	
	public void mainWindow() {
		try {
			
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainWindowView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			
			MainWindowController controller = loader.getController();
			controller.setMain(this);
			
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean newPersonWindow(Person person) {
		try {
			
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("NewPersonView.fxml")); // grab the view file
			AnchorPane pane = loader.load(); // load pane from view file 
			Scene scene = new Scene(pane);	// create a new scene and add pane
			
			// create a new window for adding/editing a new person
			Stage stage = new Stage();
			
			NewPersonController controller = loader.getController(); // connect controller to view 
			controller.setMain(this, stage, person); // connect main method to controller (so we can call methods from the main class)
			
			stage.setScene(scene);
			stage.setResizable(false);
			stage.showAndWait();
			return controller.isConfirmedClicked();
			
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private ObservableList<Person> personData = FXCollections.observableArrayList(); // plain list that contains all of our data *note it's private so we must create a method to call it
	public ObservableList<Person> getPersonData() { // method that returns the private personData list
		return personData;
	}
	
	public Main() { // create the constructor of the main class 
		
		// adds person
		personData.add(new Person("First Name Here", "Last Name Here", "Number Here", "Location Here", "Postal Here", "Email Here")); // a new instance from the person model 

		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
