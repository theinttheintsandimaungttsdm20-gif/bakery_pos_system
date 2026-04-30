package com.bakery.app;

import com.bakery.controller.MainController;
import com.bakery.view.MainView;

public class MyApp {

	public static void main(String[] args) {
		MainView v=new MainView();
		v.setVisible(true);
		new MainController(v);

	}

}
