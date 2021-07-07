package main;

import resources.Loader;

public class Main {
	public static void main(String[] argv) {
		Loader loader = new Loader();
		loader.load();
		Engine.init();
		Engine.start();
	}
}
