// package com.mygdx.game;

// import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
// import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
// import com.mygdx.game.MyGdxGame;

// // Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
// public class DesktopLauncher {
// 	public static void main (String[] arg) {
// 		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
// 		config.setForegroundFPS(60);
// 		config.setTitle("My GDX Game");
// 		new Lwjgl3Application(new MyGdxGame(), config);
// 	}
// }
package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.MyGame;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Control.MainGame;

import java.io.UnsupportedEncodingException;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) throws UnsupportedEncodingException {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(640, 640+64);
		config.useVsync(true);
		config.setForegroundFPS(MainGame.getFps());
		config.setTitle("The Lost Bounty");
		System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
		new Lwjgl3Application(new MyGame(), config);
	}
}