/*
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.comze_instancelabs.bedwars.gui;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.comze_instancelabs.bedwars.IArena;
import com.comze_instancelabs.bedwars.Main;
import com.comze_instancelabs.minigamesapi.ArenaState;
import com.comze_instancelabs.minigamesapi.PluginInstance;
import com.comze_instancelabs.minigamesapi.util.IconMenu;
import com.comze_instancelabs.minigamesapi.util.Util;

public class TeamSelectorGUI {

	Main plugin;
	PluginInstance pli;
	public HashMap<String, IconMenu> lasticonm = new HashMap<String, IconMenu>();

	public TeamSelectorGUI(PluginInstance pli, Main plugin) {
		this.plugin = plugin;
		this.pli = pli;
	}

	public void openGUI(final String playername) {
		IconMenu iconm;
		if (lasticonm.containsKey(playername)) {
			iconm = lasticonm.get(playername);
		} else {
			iconm = new IconMenu(this.plugin.msg().teamselector_title, 9, new IconMenu.OptionClickEventHandler() {
				@Override
				public void onOptionClick(IconMenu.OptionClickEvent event) {
					if (event.getPlayer().getName().equalsIgnoreCase(playername)) {
						if (pli.global_players.containsKey(playername)) {
							if (pli.getArenas().contains(pli.global_players.get(playername))) {
								String d = event.getName();
								Player p = event.getPlayer();
								IArena a = (IArena) pli.global_players.get(playername);
								final String team = getTeamFromSelector(d);
								if (Util.isComponentForArenaValid(plugin, a.getInternalName(), "spawns.spawn" + team)) {
									if (plugin.pteam.containsKey(p.getName())) {
										updateTeamCount(playername, a, -1);
									}
									plugin.pteam.put(p.getName(), team);
									updateTeamCount(playername, a, +1);
									p.sendMessage(plugin.msg().teamselector_success.replace("<team>", plugin.msg().getTextFromTeam(team)));
									if (a.checkBalancedTeams() && a.getArenaState() == ArenaState.JOIN && a.getAllPlayers().size() > a.getMinPlayers() - 1)
									{
										a.startLobby();
									}
									plugin.scoreboard.updateScoreboard(a);
								} else {
									p.sendMessage(plugin.msg().teamselector_disabled.replace("<team>", plugin.msg().getTextFromTeam(team)));
								}
							}
						}
					}
					event.setWillClose(true);
				}

				private String getTeamFromSelector(String d) {
					if (d.equals(plugin.msg().teamselector_titleblue)) return "blue";
					if (d.equals(plugin.msg().teamselector_titlegreen)) return "green";
					if (d.equals(plugin.msg().teamselector_titleyellow)) return "yellow";
					if (d.equals(plugin.msg().teamselector_titlered)) return "red";
					return null;
				}
			}, plugin);

		}

		iconm.setOption(1, new ItemStack(Material.WOOL, 1, (byte) 14), plugin.msg().teamselector_titlered, plugin.msg().teamselector_selectred);
		iconm.setOption(3, new ItemStack(Material.WOOL, 1, (byte) 11), plugin.msg().teamselector_titleblue, plugin.msg().teamselector_selectblue);
		iconm.setOption(5, new ItemStack(Material.WOOL, 1, (byte) 5), plugin.msg().teamselector_titlegreen, plugin.msg().teamselector_selectgreen);
		iconm.setOption(7, new ItemStack(Material.WOOL, 1, (byte) 4), plugin.msg().teamselector_titleyellow, plugin.msg().teamselector_selectyellow);

		iconm.open(Bukkit.getPlayerExact(playername));
		lasticonm.put(playername, iconm);
	}

	public void updateTeamCount(String playername, IArena a, int c) {
		String team = plugin.pteam.get(playername);
		if (team.equalsIgnoreCase("red")) {
			a.red += c;
		} else if (team.equalsIgnoreCase("blue")) {
			a.blue += c;
		} else if (team.equalsIgnoreCase("green")) {
			a.green += c;
		} else if (team.equalsIgnoreCase("yellow")) {
			a.yellow += c;
		}
	}

}
