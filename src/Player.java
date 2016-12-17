import objectdraw.DrawingCanvas;
import objectdraw.FilledRect;
import objectdraw.Text;

public class Player {

	protected DrawingCanvas canvas;
	protected int money;
	protected String name = "";
	protected int location;
	protected String color = "";
	protected int diceRoll;
	protected FilledRect propertyRect;
	protected Text playerInfoText;
	protected Text moneyPouch;
	protected Text currentLocation;
	protected boolean p1, p2, p3, p4;

	public Player() {
		this.money = 2000;

	}

	public void play() {
		MonopolyBoard.responseTF.setText("");
		if (this.money <= 0 && this.p1)
			MonopolyBoard.playersLost[0] = true;
		else if (this.money <= 0 && this.p2)
			MonopolyBoard.playersLost[1] = true;
		else if (this.money <= 0 && this.p3)
			MonopolyBoard.playersLost[2] = true;
		else if (this.money <= 0 && this.p4)
			MonopolyBoard.playersLost[3] = true;
		else
			this.move();

	}

	private void move() {

		int oldLoc = this.location;
		diceRoll = (int) (Math.random() * (12 - 2)) + 2;
		this.location = (this.location + diceRoll) % 40;
		if (this.location == 0)
			this.location = 40;
		if (this.location == 31) {
			this.money -= 500;
			this.location = 11;
			FreeParking.value -= 500;
		}
		if (this.p4) {
			MonopolyBoard.propertyCardArray[oldLoc].getP4().hide();
			MonopolyBoard.propertyCardArray[location].getP4().show();
		}

		else if (this.p3) {
			MonopolyBoard.propertyCardArray[oldLoc].getP3().hide();
			MonopolyBoard.propertyCardArray[location].getP3().show();
		}

		else if (this.p2) {
			MonopolyBoard.propertyCardArray[oldLoc].getP2().hide();
			MonopolyBoard.propertyCardArray[location].getP2().show();
		}

		else {
			MonopolyBoard.propertyCardArray[oldLoc].getP1().hide();
			MonopolyBoard.propertyCardArray[location].getP1().show();
		}

		if (this.location == 3 || this.location == 8 || this.location == 18 || this.location == 23
				|| this.location == 34 || this.location == 37) {
			int val = MonopolyBoard.propertyCardArray[location].getValue();

			MonopolyBoard.playersActive.get(MonopolyBoard.pCounter).money += val;
			FreeParking.value += val;
			
			this.currentLocation
			.setText("Current Location: " + MonopolyBoard.propertyCardArray[this.location].getPropertyName());

			if (val < 0)
				MonopolyBoard.responseTF.setText("You landed on a random card. You lost: " + val + " :(");
			else if (val == 0) {
				MonopolyBoard.responseTF.setText("You landed on a random card. You didnt lose / gain anything");
			}

			else {
				MonopolyBoard.responseTF.setText("You landed on a random card. You gained: " + val + " :)");
			}

			MonopolyBoard.cardInfoObject.setCardInfo(MonopolyBoard.propertyCardArray[this.location].getPropertyName(),
					val);

			MonopolyBoard.playersActive.get(MonopolyBoard.pCounter).moneyPouch
					.setText("Money Value: " + MonopolyBoard.playersActive.get(MonopolyBoard.pCounter).money);
		}

		else if (this.location == 21) {
			MonopolyBoard.playersActive.get(MonopolyBoard.pCounter).money += FreeParking.value;
			MonopolyBoard.responseTF.setText("You landed on Free Parking");
			this.currentLocation
					.setText("Current Location: " + MonopolyBoard.propertyCardArray[this.location].getPropertyName());
			FreeParking.value = 0;
		}

		else {
			MonopolyBoard.askQuestion();
			this.updateInfo();
		}

	}

	private void updateInfo() {

		this.currentLocation
				.setText("Current Location: " + MonopolyBoard.propertyCardArray[this.location].getPropertyName());

		MonopolyBoard.cardInfoObject.setCardInfo(MonopolyBoard.propertyCardArray[this.location].getPropertyName(),
				MonopolyBoard.propertyCardArray[this.location].getValue());
	}

	public void toggle(boolean val) {
		playerInfoText.setBold(val);
		moneyPouch.setBold(val);
		currentLocation.setBold(val);

	}

}
