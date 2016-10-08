package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Controlleur{
	
	private Rectangle r0;
	
	public Controlleur(){
	}
	
	public Controlleur(int x){
		r0 = new Rectangle(20, 600, Color.BLACK);
	}

	public void init() {
		
		r0 = new Rectangle(100, 50, Color.AQUAMARINE);	
	}

	public Rectangle getR0() {
		return r0;
	}

	public void setR0(Rectangle r0) {
		this.r0 = r0;
	}
	
	

}
