package inf101.v18.rogue101.objects;

/**
 * An actor is an IItem that can also do something, either controlled by the
 * computer (INonPlayer) or the user (IPlayer).
 * 
 * @author anya
 *
 */
public interface IActor extends IItem {
	
	/**
	 * @return This actor's visibility (used to remove shadow from field)
	 *         
	 */
	default int getVisibility() {
		return 0;
	}

	/**
	 * @return This actor's attack score (used against an item's
	 *         {@link #getDefence()} score to see if an attack is successful)
	 */
	int getAttack();

	/**
	 * @return The damage this actor deals on a successful attack (used together
	 *         with
	 *         {@link #handleDamage(inf101.v18.rogue101.game.IGame, IItem, int)} on
	 *         the target)
	 */
	int getDamage();
}
