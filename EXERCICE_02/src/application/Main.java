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
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Pane root = new Pane();
			
			Controlleur ct = new Controlleur();
			ct.init();
			Rectangle r0 = ct.getR0();
			
			Rectangle m1 = new Controlleur(2).getR0();
			m1.setLayoutX(200);
			
			Rectangle m2 = new Controlleur(2).getR0();
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
		case RIGHT: r.setX(r.getX() + 1);
		break;
		case B : r.setFill(Color.CORNFLOWERBLUE);
        break;
		case V : r.setFill(Color.BLUEVIOLET);
        break;
		}
		
//		String l = e.getCharacter();
//		System.out.println(l);
//		
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
		 
		System.out.println("évenement souris");
		System.out.println(e.getSceneX());
		
		r.setX(e.getSceneX());
		r.setY(e.getSceneY());
		
		return r;
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
