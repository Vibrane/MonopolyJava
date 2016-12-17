
import java.awt.Color;


import objectdraw.*;

public class PlayerTwo extends Player {
//	DrawingCanvas canvas;
//	private int money;
//	private String name = "";
//	private int location;
//
//	private String color = "";
//	private int diceRoll;
//
//	private FramedRect propertyRect;
//	private Text playerInfoText;
//	private Text moneyPouch;
//	private Text currentLocation;
//	private Text diceRollText;
//	private Scanner reader;

	public PlayerTwo(DrawingCanvas canvas) {
		this.canvas = canvas;

		this.propertyRect = new FilledRect(this.canvas.getWidth() * 5.5 / 11 + 5, this.canvas.getHeight() / 11 + 5,
				this.canvas.getWidth() * 4.5 / 11 - 5, this.canvas.getHeight() * 2 / 11 - 5, this.canvas);
		this.propertyRect.setColor(Color.GRAY);
		
		this.name = "Team 2";
		//this.money = 2000;
		this.color = "Red";
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

		
		this.playerInfoText.setColor(Color.RED);
		this.moneyPouch.setColor(Color.RED);
		this.currentLocation.setColor(Color.RED);
		
		
		
		this.p1 = false;
		this.p2 = true;
		this.p3 = false;
		this.p4 = false;

	}


	
}
