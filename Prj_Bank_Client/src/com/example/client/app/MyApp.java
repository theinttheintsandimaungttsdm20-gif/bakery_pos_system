package com.example.client.app;

import com.example.client.controller.MainController;
import com.example.client.view.MainView;

public class MyApp {

	public static void main(String[] args) {
		MainView v=new MainView(); 
		v.setVisible(true);
		new MainController(v);
	}

}
