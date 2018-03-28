package inf101.v18.rogue101.objects;

import inf101.v18.gfx.gfxmode.ITurtle;
import inf101.v18.gfx.textmode.BlocksAndBoxes;
import inf101.v18.rogue101.game.IGame;

public class Shadow implements IItem {
	@Override
	public boolean draw(ITurtle painter, double w, double h) {
		return false;
	}

	@Override
	public int getCurrentHealth() {
		return 0;
	}

	@Override
	public int getDefence() {
		return 0;
	}

	@Override
	public int getMaxHealth() {
		return 0;
	}

	@Override
	public String getName() {
		return "shadow";
	}

	@Override
	public int getSize() {
		return Integer.MAX_VALUE;
	}

	@Override
	public String getSymbol() {
		return BlocksAndBoxes.BLOCK_HALF;
	}

	@Override
	public int handleDamage(IGame game, IItem source, int amount) {
		return 0;
	}

}
