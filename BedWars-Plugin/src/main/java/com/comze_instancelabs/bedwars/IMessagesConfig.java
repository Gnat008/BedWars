package com.comze_instancelabs.bedwars;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.comze_instancelabs.minigamesapi.config.MessagesConfig;

public class IMessagesConfig extends MessagesConfig {

	public String bed_destroyed = "&cTeam &4<team>&c's bed was destroyed!";
	public String unbalanced_teams_onlyone = "&4Unbalanced teams! All players selected only one team: <team>";
	public String unbalanced_teams_moreplayers = "&4Unbalanced teams! A team needs more players: <team>";
	public String RED = "&4RED";
	public String GREEN = "§2GREEN";
	public String BLUE = "§9BLUE";
	public String YELLOW = "§eYELLOW";
	
	public String teamselector_title = "TEAM";
	public String teamselector_success = "§2Successfully set team: §4<team>";
	public String teamselector_disabled = "§4That team is not enabled on this map: <team>";
	public String teamselector_selectred = "Select the red team.";
	public String teamselector_selectgreen = "Select the green team.";
	public String teamselector_selectyellow = "Select the yellow team.";
	public String teamselector_selectblue = "Select the blue team.";
	public String teamselector_titlered = RED;
	public String teamselector_titleblue = BLUE;
	public String teamselector_titlegreen = GREEN;
	public String teamselector_titleyellow = YELLOW;

	public IMessagesConfig(JavaPlugin arg0) {
		super(arg0);

		this.getConfig().addDefault("messages.bed_destroyed", this.bed_destroyed);
		this.getConfig().addDefault("messages.unbalanced_teams_onlyone", this.unbalanced_teams_onlyone);
		this.getConfig().addDefault("messages.unbalanced_teams_moreplayers", this.unbalanced_teams_moreplayers);
		this.getConfig().addDefault("messages.red", this.RED);
		this.getConfig().addDefault("messages.green", this.GREEN);
		this.getConfig().addDefault("messages.blue", this.BLUE);
		this.getConfig().addDefault("messages.yellow", this.YELLOW);
		this.getConfig().addDefault("messages.teamselector_title", this.teamselector_title);
		this.getConfig().addDefault("messages.teamselector_success", this.teamselector_success);
		this.getConfig().addDefault("messages.teamselector_disabled", this.teamselector_disabled);
		this.getConfig().addDefault("messages.teamselector_selectred", this.teamselector_selectred);
		this.getConfig().addDefault("messages.teamselector_selectgreen", this.teamselector_selectgreen);
		this.getConfig().addDefault("messages.teamselector_selectyellow", this.teamselector_selectyellow);
		this.getConfig().addDefault("messages.teamselector_selectblue", this.teamselector_selectblue);
		this.getConfig().addDefault("messages.teamselector_titlered", this.teamselector_titlered);
		this.getConfig().addDefault("messages.teamselector_titleblue", this.teamselector_titleblue);
		this.getConfig().addDefault("messages.teamselector_titlegreen", this.teamselector_titlegreen);
		this.getConfig().addDefault("messages.teamselector_titleyellow", this.teamselector_titleyellow);

		this.getConfig().options().copyDefaults(true);
		this.saveConfig();

		this.bed_destroyed = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.bed_destroyed"));
		this.unbalanced_teams_onlyone = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.unbalanced_teams_onlyone"));
		this.unbalanced_teams_moreplayers = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.unbalanced_teams_moreplayers"));
		this.RED = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.red"));
		this.GREEN = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.green"));
		this.BLUE = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.blue"));
		this.YELLOW = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.yellow"));
		this.teamselector_title = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.teamselector_title"));
		this.teamselector_success = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.teamselector_success"));
		this.teamselector_disabled = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.teamselector_disabled"));
		this.teamselector_selectred = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.teamselector_selectred"));
		this.teamselector_selectgreen = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.teamselector_selectgreen"));
		this.teamselector_selectyellow = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.teamselector_selectyellow"));
		this.teamselector_selectblue = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.teamselector_selectblue"));
		this.teamselector_titlered = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.teamselector_titlered"));
		this.teamselector_titleblue = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.teamselector_titleblue"));
		this.teamselector_titlegreen = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.teamselector_titlegreen"));
		this.teamselector_titleyellow = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.teamselector_titleyellow"));
	}
	
	public String getTextFromTeam(String team)
	{
		switch (team)
		{
		case "red":
			return RED;
		case "blue":
			return BLUE;
		case "yellow":
			return YELLOW;
		case "green":
			return GREEN;
		}
		return "";
	}

}
