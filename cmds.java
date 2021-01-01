package com.gmail.mihir.tad.potionEffectInterval;

import org.apache.commons.lang.math.RandomUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;


public class cmds implements CommandExecutor {
	//Task ID variable to cancel task on command
	BukkitTask applyeffects;
	BukkitTask countdown;
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("IntervalEffectsOn")) {
			if (applyeffects == null && countdown == null) {
				//Gets Plugin to schedule task
				Plugin plg = primary.retPlug();
				//Schedules task and stores task in a variable to retrieve id using another command
				applyeffects = new BukkitRunnable() {
					@Override
					public void run() {
						//Potion effect array to apply an effect from
						PotionEffect[] poteff = new PotionEffect[22];
						poteff[0] = new PotionEffect(PotionEffectType.BLINDNESS, 600, 10);
						poteff[1] = new PotionEffect(PotionEffectType.CONFUSION, 600, 10);
						poteff[2] = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 600, 10);
						poteff[3] = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 600, 10);
						poteff[4] = new PotionEffect(PotionEffectType.HARM, 1, 0);
						poteff[5] = new PotionEffect(PotionEffectType.HEAL, 600, 10);
						poteff[6] = new PotionEffect(PotionEffectType.HUNGER, 600, 10);
						poteff[7] = new PotionEffect(PotionEffectType.INVISIBILITY, 600, 10);
						poteff[8] = new PotionEffect(PotionEffectType.JUMP, 600, 10);
						poteff[9] = new PotionEffect(PotionEffectType.LEVITATION, 600, 10);
						poteff[10] = new PotionEffect(PotionEffectType.LUCK, 600, 10);
						poteff[11] = new PotionEffect(PotionEffectType.NIGHT_VISION, 600, 10);
						poteff[12] = new PotionEffect(PotionEffectType.POISON, 400, 10);
						poteff[13] = new PotionEffect(PotionEffectType.REGENERATION, 600, 10);
						poteff[14] = new PotionEffect(PotionEffectType.SATURATION, 600, 10);
						poteff[15] = new PotionEffect(PotionEffectType.SLOW, 600, 10);
						poteff[16] = new PotionEffect(PotionEffectType.SLOW_DIGGING, 600, 10);
						poteff[17] = new PotionEffect(PotionEffectType.SPEED, 600, 10);
						poteff[18] = new PotionEffect(PotionEffectType.WEAKNESS, 600, 10);
						poteff[19] = new PotionEffect(PotionEffectType.WITHER, 100, 10);
						poteff[20] = new PotionEffect(PotionEffectType.SLOW_FALLING, 600, 10);
						poteff[21] = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600, 10);


						//Loop ensures that each player gets the effect
						for (Player player : Bukkit.getServer().getOnlinePlayers()) {
							//The next two lines select a random effect for each player. If you want both players to have the same random effect
							//Put those two lines outside of the for loop
							int i = RandomUtils.nextInt(22);
							//Applies potion effect
							player.addPotionEffect(poteff[i]);

						}

					}

				}.runTaskTimer(plg, 2400L, 2400L);
				//Broadcasts 10 second warning
				countdown = new BukkitRunnable() {

					@Override
					public void run() {

						Bukkit.broadcastMessage("Next effect applied in 10 seconds");
					}

				}.runTaskTimer(plg, 2200L, 2400L);




			}
			else {
				if (sender instanceof Player){
					Player p = (Player) sender;
					p.sendMessage("This command is already running. Please use IntervalEffectsOff first");
				}
				else {
					sender.sendMessage("This command is already running. Please use IntervalEffectsOff first");
				}
			}
			return true;
		}
		
		return false;
	}





}