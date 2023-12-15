package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;

import de.hamstersimulator.objectsfirst.external.model.Hamster;

/**
 * A strategy so that the hamster feeds only once while running
 *
 * @author Quentin Hadar Nora Jasharaj Moritz Mairle
 */
public final class FeedOnceStrategy implements FeedingStrategy {

	private int amount = 1;

	@Override
	public boolean isFeedingRequired() {
		if(this.amount == 1) {
			this.amount--;
			return true;
		}
		this.amount = 1;
		return false;
	}
}
