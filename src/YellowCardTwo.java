/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tactician
 */
import java.awt.Color;
import objectdraw.*;

public class YellowCardTwo extends PropertyCard {

	private DrawingCanvas canvas;
	private FramedRect propertyRect;
	private String propertyName = "Yellow Card Two";
	private FilledRect cardColor, p1, p2, p3, p4, ownedBy;
	private int value = 260;

	public YellowCardTwo(DrawingCanvas boardCanvas) {
		this.canvas = boardCanvas;
		this.propertyRect = new FramedRect((canvas.getWidth() * 7) / 11 + 5, 0 + 5, this.canvas.getWidth() / 11 - 5,
				this.canvas.getHeight() / 11 - 5, canvas);
		this.cardColor = new FilledRect(this.propertyRect.getLocation(), this.propertyRect.getWidth(),
				this.propertyRect.getHeight() / 3, canvas);
		this.cardColor.setColor(Color.YELLOW);
		this.p1 = new FilledRect(this.cardColor.getX(), this.cardColor.getY() + this.cardColor.getHeight(),
				this.propertyRect.getWidth() / 4, this.propertyRect.getHeight() / 3, canvas);
		this.p1.setColor(Color.BLUE);
		this.p2 = new FilledRect(this.p1.getX() + this.p1.getWidth(),
				this.cardColor.getY() + this.cardColor.getHeight(), this.propertyRect.getWidth() / 4,
				this.propertyRect.getHeight() / 3, canvas);
		this.p2.setColor(Color.RED);
		this.p3 = new FilledRect(this.p2.getX() + this.p2.getWidth(),
				this.cardColor.getY() + this.cardColor.getHeight(), this.propertyRect.getWidth() / 4,
				this.propertyRect.getHeight() / 3, canvas);
		this.p3.setColor(Color.YELLOW);
		this.p4 = new FilledRect(this.p3.getX() + this.p3.getWidth(),
				this.cardColor.getY() + this.cardColor.getHeight(), this.propertyRect.getWidth() / 4,
				this.propertyRect.getHeight() / 3, canvas);
		this.p4.setColor(Color.GREEN);
		this.ownedBy = new FilledRect(this.propertyRect.getX(), this.p4.getY() + this.p4.getHeight(),
				this.propertyRect.getWidth(), this.propertyRect.getHeight() / 3, canvas);
		this.ownedBy.setColor(Color.WHITE);

		p1.hide();
		p2.hide();
		p3.hide();
		p4.hide();

		// this.start();

	}

	public FilledRect getP1() {
		return this.p1;
	}

	public FilledRect getP2() {
		return this.p2;
	}

	public FilledRect getP3() {
		return this.p3;
	}

	public FilledRect getP4() {
		return this.p4;

	}

	public int getValue() {
		return this.value;
	}

	@Override
	public FramedRect getCardLocation() {

		return propertyRect;
	}

	@Override
	public String getPropertyName() {

		return propertyName;
	}

	@Override
	public FilledRect getOwnedBy() {

		return this.ownedBy;
	}

	public void updatePropertyColor(Color o) {
		this.ownedBy.setColor(o);
	}

}
