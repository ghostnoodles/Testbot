package me.stanleyliu.bots.firstbot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Game.GameType;
import net.dv8tion.jda.core.events.guild.GuildJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;


public class Firstbot extends ListenerAdapter {
	public static JDA api;
	
	
	public static void main(String[] args) {
		
		try {
			api = new JDABuilder(AccountType.BOT).setToken(Ref.TOKEN).buildBlocking();
			api.getPresence().setGame(Game.of(GameType.DEFAULT, "With Traps"));
			api.addEventListener(new Commands()) ;
		} catch (LoginException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public void onGuildJoinEvent(GuildJoinEvent event ) {
		System.out.printf("[+] %s (%s Members)\n", event.getGuild().getName(),event.getGuild().getMembers().size());
	}
}
