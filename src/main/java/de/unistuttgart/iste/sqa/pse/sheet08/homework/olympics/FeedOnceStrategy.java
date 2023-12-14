package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;

import de.hamstersimulator.objectsfirst.external.model.Hamster;

/**
 * TODO write documentation here.
 *
 * @author Quentin Hadar
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
