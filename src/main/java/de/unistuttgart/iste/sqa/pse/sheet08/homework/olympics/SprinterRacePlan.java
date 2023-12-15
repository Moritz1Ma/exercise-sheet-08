package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;

/**
 * Implements a Race Plan in which the RunnerHamster runs hard
 * till he is exhausted and changes it .
 *
 * @author Quentin Hadar Nora Jasharaj Moritz Mairle
 */
public final class SprinterRacePlan implements RacePlan {

    /**
     * @apiNote there is a feature: if one hamster reached the goal, the other hamster
     *          is able to move as fast as he wants to.
     */
    @Override
    public void nextStep(final RunnerHamster hamster) {
        if(hamster.getEnergyRemaining() >= 3)
            hamster.runHard();
        else
            hamster.setRacePlan(new RunSteadilyRacePlan());

    }
}
