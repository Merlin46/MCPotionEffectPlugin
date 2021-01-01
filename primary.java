package com.gmail.mihir.tad.potionEffectInterval;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.Plugin;

public class primary extends JavaPlugin{
	
	private static Plugin plg;
	
	@Override
	public void onEnable() {
		this.getCommand("IntervalEffectsOn").setExecutor(new cmds());

		//Sets plugin variable to use in other classes
		plg = this;		
	}
	
	@Override
	public void onDisable() {
		
	}
	//Function to use plugin in other classes
	public static Plugin retPlug() {
		
		return plg;
	}

}
