///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author tactician
// */
//import java.awt.Color;
//import objectdraw.*;
//
//public class CardInfo extends ActiveObject {
//
//	private DrawingCanvas canvas;
//	private FramedRect propertyRect;
//	private Text propertyName;
//	private String propertyString = "Blank";
//	private Text propertyValue;
//	private int value = 0;
//
//	public CardInfo(DrawingCanvas boardCanvas) {
//		this.canvas = boardCanvas;
//		this.propertyRect = new FramedRect(canvas.getWidth() * 5.5 / 11 + 5, canvas.getHeight() * 7 / 11 + 5,
//				this.canvas.getWidth() * 4.5 / 11 - 5, this.canvas.getHeight() * 3 / 11 - 5, canvas);
//
//		propertyName = new Text("Property Name: " + this.propertyString, propertyRect.getX() + 5,
//				propertyRect.getY() + 5, boardCanvas);
//
//		propertyValue = new Text("Property Value: " + this.value, propertyName.getX() + 5, propertyName.getY() + 25,
//				boardCanvas);
//
//		this.start();
//
//	}
//
//	public void run() {
//
//		while (true) {
//
//			this.propertyRect.moveTo((canvas.getWidth() * 5.5) / 11 + 5, canvas.getHeight() * 7 / 11 + 5);
//			this.propertyRect.setSize(this.canvas.getWidth() * 4.5 / 11 - 5, this.canvas.getHeight() * 3 / 11 - 5);
//
//			propertyName.moveTo(propertyRect.getX() + 5, propertyRect.getY() + 5);
//			propertyName.setText("Property Name is: " + propertyString);
//
//			propertyValue.moveTo(propertyName.getX() + 5, propertyName.getY() + 25);
//			propertyValue.setText("Property Value: " + this.value);
//
//		}
//	}
//	
//	public void setCardInfo(String name, int value)
//	{
//		this.propertyString = name;
//		this.value = value;
//	}
//
//}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tactician
 */


import objectdraw.*;

public class CardInfo {

	private DrawingCanvas canvas;
	private FramedRect propertyRect;
	private Text propertyName;
	private String propertyString = "Blank";
	private Text propertyValue;
	private int value = 0;

	public CardInfo(DrawingCanvas boardCanvas) {
		this.canvas = boardCanvas;
		this.propertyRect = new FramedRect(canvas.getWidth() * 5.5 / 11 + 5, canvas.getHeight() * 5 / 11 + 5,
				this.canvas.getWidth() * 4.5 / 11 - 5, this.canvas.getHeight() * 5 / 11 - 5, canvas);

		propertyName = new Text("Property Name: " + this.propertyString, propertyRect.getX() + 5,
				propertyRect.getY() + 5, boardCanvas);

		propertyValue = new Text("Property Value: " + this.value, propertyName.getX() + 5, propertyName.getY() + 25,
				boardCanvas);

	}

	private void updateText() {

		propertyName.setText("Property Name is: " + propertyString);
		propertyValue.setText("Property Value: " + this.value);

	}

	public void setCardInfo(String name, int value) {
		this.propertyString = name;
		this.value = value;
		this.updateText();

	}

}
