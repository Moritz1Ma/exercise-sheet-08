package de.unistuttgart.iste.sqa.pse.sheet08.homework.olympics;

import de.hamstersimulator.objectsfirst.datatypes.Direction;
import de.hamstersimulator.objectsfirst.datatypes.Location;
import de.hamstersimulator.objectsfirst.external.simple.game.SimpleHamsterGame;

import java.util.LinkedList;
import java.util.List;

/**
 * This class sets up the race
 *
 * @author Quentin Hadar Nora Jasharaj Moritz Mairle
 */
public final class OlympicsHamsterGame extends SimpleHamsterGame {
    List<RunnerHamster> runners;

    public OlympicsHamsterGame() {
        this.loadTerritoryFromResourceFile("/territories/raceTrackTerritory.ter");
        this.displayInNewGameWindow();
        game.startGame();
        runners = new LinkedList<RunnerHamster>();
    }

    @Override
    protected void run() {
        paule.write("Welcome to the first race of the day!");
        setupTaskC();
        race();

        paule.write("And now for the second race!");
        setupTaskD();
        race();

        paule.write("To top it all off: Speedy`s attempt at beating the WORLD RECORD!");
        recordAttempt();
    }

    /**
     * Speedy runs the course in fewer than 30 turns.
     * <p>
     * To achieve this, speedy switches strategies during the race.
     * <p>
     * Ensures that speedy needed at most 30 actions to reach the goal.
     */

    private void recordAttempt() {
        final RunnerHamster speedy = createRunnerHamster();
        configureRunnerHamster(speedy);

        runRace(speedy);

        if (speedy.hasFinished()) {
            speedy.write("I needed " + speedy.getActionsTaken() + " actions!");
        }
    }

    private RunnerHamster createRunnerHamster() {
        return new RunnerHamster(game.getTerritory(), new Location(1, 1), Direction.EAST);
    }

    private void configureRunnerHamster(RunnerHamster speedy) {
        speedy.setRacePlan(new RunSteadilyRacePlan());
        speedy.setFeedingTactics(new FeedTwiceStrategy());
    }

    private void runRace(RunnerHamster speedy) {
        int sprint = 0;
        while (!speedy.hasFinished() && speedy.getActionsTaken() < 30) {
            if (speedy.isAtFeedZone())
                sprint = 2;
            if (sprint > 0) {
                if (sprint-- == 1)
                    speedy.setFeedingTactics(new FeedOnceStrategy());
                speedy.setRacePlan(new SprinterRacePlan());
            } else
                speedy.setRacePlan(new RunSteadilyRacePlan());
            speedy.executeNextAction();
        }
    }

    /**
     * sets up the runners to take part in a race with strategies as implemented in task (c).
     * <p>
     * Ensures that a steady runner and a sprinting runner both on the tile (1,1) and
     * facing east.
     * <p>
     * The steady runner uses a {@code RunSteadilyRacePlan}.
     * The sprinting runner uses a {@code SprinterRacePlan}.
     */
    private void setupTaskC() {
        runners = new LinkedList<RunnerHamster>();

        final RunnerHamster steadyRunner = new RunnerHamster(game.getTerritory(), new Location(1, 1), Direction.EAST);
        final RunnerHamster sprintingRunner =
                new RunnerHamster(game.getTerritory(), new Location(1, 1), Direction.EAST);

        final RacePlan tacticSteady = new RunSteadilyRacePlan();
        steadyRunner.setRacePlan(tacticSteady);

        final RacePlan tacticSprinting = new SprinterRacePlan();
        sprintingRunner.setRacePlan(tacticSprinting);

        runners.add(steadyRunner);
        runners.add(sprintingRunner);
    }

    /**
     * Sets up the runners to take part in a race with strategies as implemented in task (d).
     * <p>
     * Ensures that a steady runner and a sprinting runner both on the tile (1,1) and
     * facing east.
     * The steady runner uses a {@code FeedOnceStrategy} and a {@code RunSteadilyRacePlan}.
     * The sprinting runner uses a {@code FeedTwiceStrategy} and a {@code SprinterRacePlan}.
     */
    private void setupTaskD() {
        runners = new LinkedList<RunnerHamster>();
        final RunnerHamster steadyRunner = new RunnerHamster(game.getTerritory(), new Location(1, 1), Direction.EAST);
        final RunnerHamster sprintingRunner =
                new RunnerHamster(game.getTerritory(), new Location(1, 1), Direction.EAST);

        final RacePlan tacticSteady = new RunSteadilyRacePlan();
        final FeedingStrategy tacticFeedOnce = new FeedOnceStrategy();
        steadyRunner.setRacePlan(tacticSteady);
        steadyRunner.setFeedingTactics(tacticFeedOnce);

        final RacePlan tacticSprinting = new SprinterRacePlan();
        final FeedingStrategy tacticFeedTwice = new FeedTwiceStrategy();
        sprintingRunner.setRacePlan(tacticSprinting);
        sprintingRunner.setFeedingTactics(tacticFeedTwice);

        runners.add(steadyRunner);
        runners.add(sprintingRunner);
    }

    /**
     * runs a race with the competitors currently in runners.
     * <p>
     * ensures that a new race has been executed
     */
    private void race() {
        final Race race = new Race(runners);
        race.executeRace();
    }
}
