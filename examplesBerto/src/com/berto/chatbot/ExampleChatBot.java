package com.berto.chatbot;

import javax.swing.JOptionPane;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;

public class ExampleChatBot {

	ChatterBotFactory factory = new ChatterBotFactory();

	public static void main(String[] args) throws Exception {
		System.out.println("Inicio de Aplicacion");
		ExampleChatBot chat = new ExampleChatBot();
		chat.conversar();
	}

	public void conversar() throws Exception {
		// creamos nuestros bots;
		ChatterBot bot1 = factory.create(ChatterBotType.JABBERWACKY, "b0dafd24ee35a477");
		// ChatterBot bot1 = factory.create(ChatterBotType.CLEVERBOT);
		// ChatterBot bot1 = factory.create(ChatterBotType.PANDORABOTS, "b0dafd24ee35a477");
		ChatterBotSession bot1session = bot1.createSession();
		// hacemos una pregunta;
		String chat = JOptionPane.showInputDialog("Chat");
		System.out.println("Yo> " + chat);
		// el bot responde;
		chat = bot1session.think(chat);
		System.out.println("Bot> " + chat);
		// y volvemos a repetir;
		conversar();
	}
}
