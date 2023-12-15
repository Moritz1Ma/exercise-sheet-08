package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;

/**
 * A strategy so that the hamster feeds twice while running
 *
 * @author Quentin Hadar Nora Jasharaj Moritz Mairle
 */
public final class FeedTwiceStrategy implements FeedingStrategy {

	private int amount = 2;

	@Override
	public boolean isFeedingRequired() {
		if(this.amount > 0) {
			this.amount--;
			return true;
		}
		this.amount = 2;
		return false;
	}
}
