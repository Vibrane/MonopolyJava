/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tactician
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import objectdraw.*;

public class MonopolyBoard extends WindowController implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static PropertyCard[] propertyCardArray = new PropertyCard[41];
	static CardInfo cardInfoObject;
	static ArrayList<Player> playersActive;
	static boolean[] playersLost;
	static Question questionBank;
	static InfoBox infoBoxObject;
	static int qCounter, pCounter;
	private JPanel southPanel, southButtonPanel;
	private Container contentPane;
	static JTextField responseTF;
	private JButton responseButton, endTurnButton, specalPowerButton;
	static JTextArea questionArea;
	static int questionNumber;
	static String actualAnswer;

	public void begin() {

		this.contentPane = getContentPane();

		this.southPanel = new JPanel();
		this.southPanel.setLayout(new BorderLayout());

		this.contentPane.add(this.southPanel, BorderLayout.SOUTH);

		MonopolyBoard.responseTF = new JTextField("Response Goes Here");
		this.southPanel.add(responseTF, BorderLayout.NORTH);

		MonopolyBoard.questionArea = new JTextArea(3, 40);
		this.southPanel.add(new JScrollPane(MonopolyBoard.questionArea), BorderLayout.CENTER);
		questionArea.setLineWrap(true);

		this.southButtonPanel = new JPanel();
		this.southPanel.add(this.southButtonPanel, BorderLayout.SOUTH);

		this.responseButton = new JButton("Validate Response");
		this.southButtonPanel.add(this.responseButton);
		this.responseButton.addActionListener(this);

//		this.specalPowerButton = new JButton("Special Power");
//		this.southButtonPanel.add(this.specalPowerButton);
//		this.specalPowerButton.addActionListener(this);

		this.endTurnButton = new JButton("End Turn");
		this.southButtonPanel.add(this.endTurnButton);
		this.endTurnButton.addActionListener(this);

		this.contentPane.validate();
		this.contentPane.setVisible(true);

		MonopolyBoard.propertyCardArray[1] = new Go(this.canvas);
		MonopolyBoard.propertyCardArray[2] = new BrownOne(this.canvas);
		MonopolyBoard.propertyCardArray[3] = new RandomCardFour(this.canvas);
		MonopolyBoard.propertyCardArray[4] = new BrownTwo(this.canvas);
		MonopolyBoard.propertyCardArray[5] = new TaxOne(this.canvas);
		MonopolyBoard.propertyCardArray[6] = new RailRoadThree(this.canvas);
		MonopolyBoard.propertyCardArray[7] = new BlueOne(this.canvas);
		MonopolyBoard.propertyCardArray[8] = new RandomCardThree(this.canvas);
		MonopolyBoard.propertyCardArray[9] = new BlueTwo(this.canvas);
		MonopolyBoard.propertyCardArray[10] = new BlueThree(this.canvas);
		MonopolyBoard.propertyCardArray[11] = new Jail(this.canvas);
		MonopolyBoard.propertyCardArray[12] = new PinkOne(this.canvas);
		MonopolyBoard.propertyCardArray[13] = new GovernmentTwo(this.canvas);
		MonopolyBoard.propertyCardArray[14] = new PinkTwo(this.canvas);
		MonopolyBoard.propertyCardArray[15] = new PinkThree(this.canvas);
		MonopolyBoard.propertyCardArray[16] = new RailRoadTwo(this.canvas);
		MonopolyBoard.propertyCardArray[17] = new OrangeOne(this.canvas);
		MonopolyBoard.propertyCardArray[18] = new RandomCardTwo(this.canvas);
		MonopolyBoard.propertyCardArray[19] = new OrangeTwo(this.canvas);
		MonopolyBoard.propertyCardArray[20] = new OrangeThree(this.canvas);
		MonopolyBoard.propertyCardArray[21] = new FreeParking(this.canvas);
		MonopolyBoard.propertyCardArray[22] = new RedCardOne(this.canvas);
		MonopolyBoard.propertyCardArray[23] = new RandomCardOne(this.canvas);
		MonopolyBoard.propertyCardArray[24] = new RedCardTwo(this.canvas);
		MonopolyBoard.propertyCardArray[25] = new RedCardThree(this.canvas);
		MonopolyBoard.propertyCardArray[26] = new RailRoadOne(this.canvas);
		MonopolyBoard.propertyCardArray[27] = new YellowCardOne(this.canvas);
		MonopolyBoard.propertyCardArray[28] = new YellowCardTwo(this.canvas);
		MonopolyBoard.propertyCardArray[29] = new GovernmentOne(this.canvas);
		MonopolyBoard.propertyCardArray[30] = new YellowCardThree(this.canvas);
		MonopolyBoard.propertyCardArray[31] = new GoToJail(this.canvas);
		MonopolyBoard.propertyCardArray[32] = new GreenOne(this.canvas);
		MonopolyBoard.propertyCardArray[33] = new GreenTwo(this.canvas);
		MonopolyBoard.propertyCardArray[34] = new RandomCardFive(this.canvas);
		MonopolyBoard.propertyCardArray[35] = new GreenThree(this.canvas);
		MonopolyBoard.propertyCardArray[36] = new RailRoadFour(this.canvas);
		MonopolyBoard.propertyCardArray[37] = new RandomCardSix(this.canvas);
		MonopolyBoard.propertyCardArray[38] = new DarkBlueOne(this.canvas);
		MonopolyBoard.propertyCardArray[39] = new TaxTwo(this.canvas);
		MonopolyBoard.propertyCardArray[40] = new DarkBlueTwo(this.canvas);

		MonopolyBoard.cardInfoObject = new CardInfo(this.canvas);
		MonopolyBoard.playersActive = new ArrayList<>();
		MonopolyBoard.playersLost = new boolean[4];
		MonopolyBoard.questionBank = new Question();
		MonopolyBoard.infoBoxObject = new InfoBox(this.canvas);

		qCounter = Question.questions.size();
		pCounter = 0;

		playersActive.add(new PlayerOne(this.canvas));
		playersActive.add(new PlayerTwo(this.canvas));
		playersActive.add(new PlayerThree(this.canvas));
		playersActive.add(new PlayerFour(this.canvas));

		MonopolyBoard.infoBoxObject.updateColor();
		playersActive.get(pCounter).play();
		
		for (int i = 1; i < 41; i++)
		{
			propertyCardArray[i].getP3().setColor(Color.ORANGE);
		}

	}

	public void onMouseClick(Location point) {
		String input;

		if (MonopolyBoard.playersActive.get(0).propertyRect.contains(point)) {

			input = JOptionPane.showInputDialog("Enter Input:");
			playersActive.get(0).money = Integer.parseInt(input);
			MonopolyBoard.playersActive.get(0).moneyPouch
					.setText("Money Value: " + MonopolyBoard.playersActive.get(0).money);

		}

		else if (MonopolyBoard.playersActive.get(1).propertyRect.contains(point)) {

			input = JOptionPane.showInputDialog("Enter Input:");
			playersActive.get(1).money = Integer.parseInt(input);
			MonopolyBoard.playersActive.get(1).moneyPouch
					.setText("Money Value: " + MonopolyBoard.playersActive.get(1).money);

		}

		else if (MonopolyBoard.playersActive.get(2).propertyRect.contains(point)) {

			input = JOptionPane.showInputDialog("Enter Input:");
			playersActive.get(2).money = Integer.parseInt(input);
			MonopolyBoard.playersActive.get(2).moneyPouch
					.setText("Money Value: " + MonopolyBoard.playersActive.get(2).money);

		}

		else if (MonopolyBoard.playersActive.get(3).propertyRect.contains(point)) {

			input = JOptionPane.showInputDialog("Enter Input:");
			playersActive.get(3).money = Integer.parseInt(input);
			MonopolyBoard.playersActive.get(3).moneyPouch
					.setText("Money Value: " + MonopolyBoard.playersActive.get(3).money);

		}

		else {
			for (int counter = 1; counter < MonopolyBoard.propertyCardArray.length; counter++) {
				if (MonopolyBoard.propertyCardArray[counter].getCardLocation().contains(point)) {
					MonopolyBoard.cardInfoObject.setCardInfo(MonopolyBoard.propertyCardArray[counter].getPropertyName(),
							MonopolyBoard.propertyCardArray[counter].getValue());
					break;
				}

			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.responseButton) {
			validateAnswer();
		}

		else if (e.getSource() == this.specalPowerButton) {
			// implement the four powers here

		}

		else if (e.getSource() == this.endTurnButton) {
			nextPlayer();
		}

		else {

		}

	}

	static void nextPlayer() {
		while (true) {
			pCounter++;
			pCounter = MonopolyBoard.pCounter % 4;
			if (!playersLost[pCounter])
				break;
		}
		MonopolyBoard.infoBoxObject.updateColor();
		playersActive.get(pCounter).play();

	}

	static void validateAnswer() {
		String response = "";
		response = MonopolyBoard.responseTF.getText();

		if (response.equals(""))
			JOptionPane.showMessageDialog(null, "Please provide an answer");

		else {
			if (!Question.answered) {

				response = response.toLowerCase();
				response = response.substring(0, 1);

				String answer = "";
				answer = actualAnswer;
				answer = answer.toLowerCase();
				answer = answer.substring(0, 1);

				if (response.equals(answer)) {
					responseTF.setText("Correct. The answer was indeed: " + actualAnswer);
					MonopolyBoard.playersActive
							.get(pCounter).money += MonopolyBoard.propertyCardArray[MonopolyBoard.playersActive
									.get(pCounter).location].getValue();
					if (propertyCardArray[playersActive.get(pCounter).location].getOwnedBy()
							.getColor() != Color.BLACK) {
						if (pCounter == 0)
							MonopolyBoard.propertyCardArray[MonopolyBoard.playersActive.get(pCounter).location]
									.updatePropertyColor(Color.BLUE);
						else if (pCounter == 1)
							MonopolyBoard.propertyCardArray[MonopolyBoard.playersActive.get(pCounter).location]
									.updatePropertyColor(Color.RED);
						else if (pCounter == 2)
							MonopolyBoard.propertyCardArray[MonopolyBoard.playersActive.get(pCounter).location]
									.updatePropertyColor(Color.YELLOW);
						else
							MonopolyBoard.propertyCardArray[MonopolyBoard.playersActive.get(pCounter).location]
									.updatePropertyColor(Color.GREEN);
					}

				}

				else {
					responseTF.setText("Wrong. Correct Answer is: " + actualAnswer);
					MonopolyBoard.playersActive
							.get(pCounter).money -= MonopolyBoard.propertyCardArray[MonopolyBoard.playersActive
									.get(pCounter).location].getValue();
					if (propertyCardArray[playersActive.get(pCounter).location].getOwnedBy().getColor() == Color.BLUE)
						MonopolyBoard.playersActive.get(
								0).money += MonopolyBoard.propertyCardArray[MonopolyBoard.playersActive.get(0).location]
										.getValue();
					else if (propertyCardArray[playersActive.get(pCounter).location].getOwnedBy()
							.getColor() == Color.RED)
						MonopolyBoard.playersActive.get(
								1).money += MonopolyBoard.propertyCardArray[MonopolyBoard.playersActive.get(1).location]
										.getValue();

					else if (propertyCardArray[playersActive.get(pCounter).location].getOwnedBy()
							.getColor() == Color.YELLOW)
						MonopolyBoard.playersActive.get(
								2).money += MonopolyBoard.propertyCardArray[MonopolyBoard.playersActive.get(2).location]
										.getValue();

					else if (propertyCardArray[playersActive.get(pCounter).location].getOwnedBy()
							.getColor() == Color.GREEN)
						MonopolyBoard.playersActive.get(
								3).money += MonopolyBoard.propertyCardArray[MonopolyBoard.playersActive.get(3).location]
										.getValue();
				}
				for (int x = 0; x < 4; x++)
					MonopolyBoard.playersActive.get(x).moneyPouch
							.setText("Money Value: " + MonopolyBoard.playersActive.get(x).money);
				Question.answered = true;
			}

			else
				JOptionPane.showMessageDialog(null, "You already answered this question");

		}

	}

	static void askQuestion() {
		
		if (Question.questions.size() == 0)
			JOptionPane.showMessageDialog(null, "Game is Over");
		else
		{
			Question.answered = false;
			questionNumber = (int) (Math.random() * ((Question.questions.size() - 1) - 0)) + 0;
			MonopolyBoard.questionArea.setText(Question.questions.remove(questionNumber));
			MonopolyBoard.responseTF.setText("");
			actualAnswer = Question.answers.remove(questionNumber);
		}
		
		
	}

}
