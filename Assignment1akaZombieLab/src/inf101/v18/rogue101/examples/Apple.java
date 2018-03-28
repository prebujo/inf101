//DELOPPG B1
//Kopierte her funksjonaliteten fra Carrot som beskrevet i oppgaven og gjorde noen små endringer ( bl.a. er farge nå RED)
package inf101.v18.rogue101.examples;

import inf101.v18.gfx.gfxmode.ITurtle;
import inf101.v18.rogue101.game.IGame;
import inf101.v18.rogue101.objects.IItem;
import javafx.scene.paint.Color;

public class Apple implements IItem {
	private int hp = getMaxHealth();

	public void doTurn(IGame game) {
		hp = Math.min(hp + 1, getMaxHealth());
	}

	@Override
	public boolean draw(ITurtle painter, double w, double h) {
		painter.save();
		painter.turn(75);
		double size = ((double) hp + getMaxHealth()) / (2.0 * getMaxHealth());
		double carrotLength = size * h * .4;  //endret størrelsen til et mer passende eple størrelse
		double carrotWidth = size * h * .7; //samme som over
		painter.jump(-carrotLength / 6);
		painter.shape().ellipse().width(carrotLength).height(carrotWidth).fillPaint(Color.RED).fill(); //endret farge
		painter.jump(carrotLength / 2);
		painter.setInk(Color.BROWN);  //endret farge på stilken
		for (int i = -1; i < 2; i++) {
			painter.save();
			painter.turn(20 * i);
			painter.draw(carrotLength / 3);
			painter.restore();
		}
		painter.restore();
		return true;
	}

	@Override
	public int getCurrentHealth() {
		return hp;
	}

	@Override
	public int getDefence() {
		return 0;
	}

	@Override
	public double getHealthStatus() {
		return getCurrentHealth() / getMaxHealth();
	}

	@Override
	public int getMaxHealth() {
		return 10;
	}

	@Override
	public String getName() { //endret navn
		return "apple";
	}

	@Override
	public int getSize() {
		return 2;
	}

	@Override
	public String getSymbol() {  //endret symbol til A
		return "A";
	}

	@Override
	public int handleDamage(IGame game, IItem source, int amount) {
		hp -= amount;

		if (hp < 0) {
			// we're all eaten!
			hp = -1;
		}
		return amount;
	}

}