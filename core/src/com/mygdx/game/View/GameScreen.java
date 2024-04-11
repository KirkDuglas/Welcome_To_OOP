package com.mygdx.game.View;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.Render;
import com.mygdx.game.Actions.Teams;
import com.mygdx.game.Control.MainGame;

public class GameScreen extends MainScreen {

    Teams teams;
    Render render;
    MainGame config;

    public GameScreen(Game game)
    {
        super(game);
        config = new MainGame();
    }

    @Override
    public void show() {
        this.teams = new Teams();
        teams.createTeams(10);
        render = new Render();
    }

    @Override
    public void render(float delta) {
        teams.update(delta);
        render.render(delta, teams.getAllPersons(), teams.actionObjects);

        boolean blue = teams.checkBlueCommand();
        boolean red = teams.checkRedCommand();
        // Gdx.input.isKeyPressed(Input.Keys.ESCAPE)
        if (!blue || !red || Gdx.input.isButtonJustPressed(Input.Buttons.LEFT) || Gdx.input.justTouched())
        {
            render.dispose();
            String s = "Game break.";
            if (red && !blue)
                s = "Red wins!!!";
            else if (blue && !red)
                s = "Blue wins!!!";
            game.setScreen(new OtherScreens(game, s));
        }
    }

    @Override
    public void resize(int width, int height)
    {
        config.configMap(width, height);
        render.resize(width, height);
    }

    @Override
    public void dispose() {
        render.dispose();
    }
}
