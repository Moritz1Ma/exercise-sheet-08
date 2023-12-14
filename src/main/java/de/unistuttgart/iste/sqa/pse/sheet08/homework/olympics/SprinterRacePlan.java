package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;

/**
 * TODO write documentation here.
 *
 * @author your name
 */
public final class SprinterRacePlan implements RacePlan {

    private int intensityLevel = 2;

    /**
     * @apiNote there is a feature: if one hamster reached the goal, the other hamster
     *          is able to move as fast as he wants to.
     */
    @Override
    public void nextStep(final RunnerHamster hamster) {
        if(!hamster.hasFinished()) {
            try {
                switch (intensityLevel){
                    case 2:
                        hamster.runHard();
                        break;
                    case 1:
                        hamster.runSteadily();
                        break;
                    default:
                        hamster.runSlowly();
                        break;
                }
            }catch (IllegalStateException ignored) {
                intensityLevel--;
            }
        }
    }
}
