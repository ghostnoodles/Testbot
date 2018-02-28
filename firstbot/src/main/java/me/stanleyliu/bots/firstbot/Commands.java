package me.stanleyliu.bots.firstbot;

import java.awt.Color;

import java.util.Random;
import java.io.*;
import java.net.*;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter{
	String discordname;
	Random rand = new Random();
	EmbedBuilder eb = new EmbedBuilder();
	public void onMessageReceived(MessageReceivedEvent event)     {


        User author = event.getAuthor();               
        Message message = event.getMessage();          
        MessageChannel channel = event.getChannel();   

        String msg = message.getContentDisplay();                              

        if (event.isFromType(ChannelType.TEXT))        
        {
            

            Guild guild = event.getGuild();            
            TextChannel textChannel = event.getTextChannel(); 
            Member member = event.getMember();         
            String name;
            if (message.isWebhookMessage())
            {
                name = author.getName();               
            }                                        
            else
            {
                name = member.getEffectiveName();    
                discordname = name;
            }                                          
            System.out.printf("(%s)[%s]<%s>: %s\n", guild.getName(), textChannel.getName(), name, msg);
        }
        if (msg.equals("!ping"))
        {
        	eb.setColor(Color.GREEN);
        	eb.setDescription("!pong");	
            channel.sendMessage(eb.build()).queue();
        }
        else if (msg.equals("!slur"))
        {
        	int  n = rand.nextInt(10) + 1;
        	 String slur;
             switch (n) {
                 case 1:  slur = "I hope you step on Lego " + discordname;
                          break;
                 case 2:  slur = discordname + " your birth certificate is an apology letter from Durex";
                          break;
                 case 3:  slur = "Oh you think your are 10?, " + discordname + " Maybe on the Ph scale cause damn dude you basic";
                          break;
                 case 4:  slur = "I Would like to insult you " + discordname + " But I'm afraid I won't do as well as nature did" ;
                          break;
                 case 5:  slur = "If i was your father " + discordname + " i would still be trying to abort you";
                          break;
                 case 6:  slur = "keep rolling your eyes " + discordname + " maybe you'll find a brain back there";
                          break;
                 case 7:  slur = "I would slap you " + discordname + " but that would be animal abuse";
                          break;
                 case 8:  slur = "You are like the first piece of bread " + discordname + " everybody touches you but no one wants you";
                          break;
                 case 9:  slur = "I bet you will be put in Hufflepuff " + discordname;
                          break;
                 case 10: slur = discordname + " were you born on the highway? because that is the place where most accidents happen";
                          break;
                 default: slur = "Invalid month";
                          break;
             }
             eb.setColor(Color.GREEN);
         	eb.setDescription(slur);	
             channel.sendMessage(eb.build()).queue();
        }

		}
}
