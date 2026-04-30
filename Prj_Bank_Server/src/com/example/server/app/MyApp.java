package com.example.server.app;

import com.example.server.controller.MainController;
import com.example.server.view.MainView;

public class MyApp {

	public static void main(String[] args) {
		MainView v=new MainView(); 
		v.setVisible(true);
		new MainController(v);
	}

}
