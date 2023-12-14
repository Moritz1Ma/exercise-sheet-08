package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;

/**
 * TODO write documentation here.
 *
 * @author your name
 */
public final class RunSteadilyRacePlan implements RacePlan {


    /**
     * @apiNote there is a feature: if one hamster reached the goal, the other hamster
     *          is able to move as fast as he wants to.
     */
    @Override
    public void nextStep(final RunnerHamster hamster) {
        try {
            hamster.runSteadily();
        }catch (IllegalStateException ignored) {
            hamster.setRacePlan(new RunSlowlyRacePlan());
        }
    }
}
