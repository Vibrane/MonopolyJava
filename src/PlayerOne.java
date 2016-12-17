import java.awt.Color;
import objectdraw.*;

public class PlayerOne extends Player {
	

	public PlayerOne(DrawingCanvas canvas) {
		this.canvas = canvas;

		this.propertyRect = new FilledRect(this.canvas.getWidth() / 11 + 5, this.canvas.getHeight() / 11 + 5,
				this.canvas.getWidth() * 4.5 / 11 - 5, this.canvas.getHeight() * 2 / 11 - 5, this.canvas);
		this.propertyRect.setColor(Color.GRAY);

		this.name = "Team 1";
		//this.money = 2000;
		this.color = "Blue";
		this.canvas = canvas;
		this.diceRoll = 0;
		this.location = 1;
		
		
		this.playerInfoText = new Text(this.name + " is color: " + this.color, propertyRect.getX() + 5,
				propertyRect.getY() + 5, canvas);		

		this.moneyPouch = new Text("Money Value: " + this.money, this.playerInfoText.getX() + 5,
				this.playerInfoText.getY() + 25, this.canvas);

		this.currentLocation = new Text(
				"Current Location: " + MonopolyBoard.propertyCardArray[this.location].getPropertyName(),
				this.moneyPouch.getX() + 5, this.moneyPouch.getY() + 25, this.canvas);		

		
		this.playerInfoText.setColor(Color.BLUE);
		this.moneyPouch.setColor(Color.BLUE);
		this.currentLocation.setColor(Color.BLUE);		

		this.p1 = true;
		this.p2 = false;
		this.p3 = false;
		this.p4 = false;

	}

	
	


	
}
