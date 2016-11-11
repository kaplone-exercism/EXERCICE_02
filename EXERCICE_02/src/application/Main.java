package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
		
	int bonus = 0;
	Rectangle r0;
	Rectangle  m1;
	Rectangle  m2;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Pane root = new Pane();
			
			Controlleur ct = new Controlleur();
			ct.init();
			r0 = ct.getR0();
			
			m1 = new Controlleur(2).getR0();
			m1.setLayoutX(200);
			
			m2 = new Controlleur(2).getR0();
			m2.setLayoutX(350);
			
			root.getChildren().addAll( m1, r0, m2);

			Scene scene = new Scene(root,1000,600);
			
			root.setOnMouseClicked(e -> gerer_clicks(r0, e));
			scene.setOnKeyPressed(e1 -> gerer_keys(r0, e1));
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private Rectangle gerer_keys(Rectangle r, KeyEvent e){
		
		
		KeyCode kc = e.getCode();
		
		System.out.println(kc.getName());
		
		switch (kc) {
		case UP: r.setY(r.getY() - 5);			
			break;
		case DOWN: r.setY(r.getY() + 5);			
		break;
		case LEFT: r.setX(r.getX() - 5);
		break;
		case RIGHT: r.setX(r.getX() + 6);
		break;
		case Z: r.setY(r.getY() - 5 - bonus);
		r.setFill(Color.PINK);
		break;
		case S: r.setY(r.getY() + 5 + bonus);
		r.setFill(Color.BLUE);
		break;
		case Q: r.setX(r.getX() - 5 - bonus);
		r.setFill(Color.ORANGE);
		break;
		case D: r.setX(r.getX() + 5 + bonus);
		r.setFill(Color.GREENYELLOW);
		break;
		case NUMPAD9 : r.setFill(Color.BLACK);
        break;
		case NUMPAD8 : r.setFill(Color.CHOCOLATE);
        break;
		case NUMPAD7 : r.setFill(Color.RED);
        break;
		case NUMPAD6 : r.setFill(Color.BLUE);
        break;
		case NUMPAD5 : r.setFill(Color.MAROON);
        break;
		case NUMPAD4 : r.setFill(Color.GREEN);
        break;
		case NUMPAD3 : r.setFill(Color.CORNFLOWERBLUE);
        break;
		case NUMPAD2 : r.setFill(Color.BLUEVIOLET);
        break;
		case NUMPAD1 : r.setFill(Color.YELLOW);
        break;
		case ADD: bonus += 5;
		break;
		case SUBTRACT: bonus -= 5;
		break;
		}
		
		Contact.estEnContact(r0, m1);
//		String l = e.getCharacter();
//		System.out.println(l);
//		
//		switch(l){
//		case "8" : r.setY(r.getY() - 5);
//		           break;
//		case "2" : r.setY(r.getY() + 5);
//        break;
//		case "4" : r.setX(r.getX() - 5);
//        break;
//		case "6" : r.setX(r.getX() + 5);
//        break;
//		case "5" : double temp_X = r.getX();
//			       r.setX(r.getY());
//		           r.setY(temp_X);
//        break;
//		case "b" : r.setFill(Color.CORNFLOWERBLUE);
//        break;
//		case "o" : r.setFill(Color.ORANGE);
//        break;
//		case "v" : r.setFill(Color.MEDIUMPURPLE);
//        break;
//		}

		return r;
		
	}
	
    private Rectangle gerer_clicks(Rectangle r, MouseEvent e){
		 
		System.out.println("Ã©venement souris");
		System.out.println(e.getSceneX());
		
		r.setX(e.getSceneX());
		r.setY(e.getSceneY());
		
		return r;
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
