package com.tutorial.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.tutorial.main.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler){
		this.game = game;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState==STATE.Menu)
		{
		//play button
			if(mouseOver(mx, my, Game.WIDTH/2-100, 150, 200, 64)){
				game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32,ID.Player, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50),ID.BasicEnemy,handler));
			}
			
			//help button
			if(mouseOver(mx, my, Game.WIDTH/2-100, 250,200, 64)){
				game.gameState = STATE.Help;
			}
			
			//quit button
			if(mouseOver(mx, my, Game.WIDTH/2-100, 350,200, 64)){
				System.exit(0);
			} 
		}
		if(game.gameState == STATE.Help)
		{
			//back button for help
			if(game.gameState == STATE.Help){
				if(mouseOver(mx, my, Game.WIDTH/2-100, 350, 200, 64)){
					game.gameState = STATE.Menu;
					return;
				}
			}
		}
	}
	
	public void mouseReleased(MouseEvent e){
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if(mx > x && mx < x + width){
			if(my > y && my < y + height){
				return true;
			}else return false;
		}else return false;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		
		if(game.gameState == STATE.Menu)
		{
		Font fnt = new Font("MonoSpaced", 1, 50);
		Font fnt2 = new Font("MonoSpaced", 1,30);
		
		g.setFont(fnt);
		g.setColor(Color.WHITE);
		g.drawString("Menu", 265, 75);
		
		g.setFont(fnt2);
		g.drawRect(Game.WIDTH/2-100, 150, 200, 64);
		g.drawString("Play", 287, 193);
		
		g.drawRect(Game.WIDTH/2-100, 250, 200, 64);
		g.drawString("Poop", 287, 293);
		
		g.setColor(Color.WHITE);
		g.drawRect(Game.WIDTH/2-100, 350, 200, 64);
		g.drawString("Quit", 287, 393);
		}
		else if(game.gameState == STATE.Help)
		{
			Font fnt = new Font("MonoSpaced", 1,50);
			Font fnt2 = new Font("MonoSpaced", 1,30);
			Font fnt3 = new Font("MonoSpaced", 1,22);
			
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawString("Instructions", Game.WIDTH/2-55, 70);
			
			g.setFont(fnt3);
			g.drawString("Use WASD keys to move player and dodge enemies", 25, 200);
			
			g.setFont(fnt2);
			g.drawRect(Game.WIDTH/2-100, 350, 200, 64);
			g.drawString("Back", 288, 393);
		}
	}

}
