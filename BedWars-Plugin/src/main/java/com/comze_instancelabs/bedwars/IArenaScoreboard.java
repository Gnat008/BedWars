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
package com.comze_instancelabs.bedwars;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.comze_instancelabs.minigamesapi.Arena;
import com.comze_instancelabs.minigamesapi.MinigamesAPI;
import com.comze_instancelabs.minigamesapi.util.ArenaScoreboard;

public class IArenaScoreboard extends ArenaScoreboard {

	HashMap<String, Scoreboard> ascore = new HashMap<String, Scoreboard>();
	HashMap<String, Objective> aobjective = new HashMap<String, Objective>();

	Main plugin = null;

	public IArenaScoreboard(Main plugin) {
		this.plugin = plugin;
	}

	public void updateScoreboard(final IArena arena) {
		for (String p_ : arena.getAllPlayers()) {
			Player p = Bukkit.getPlayer(p_);
			if (!ascore.containsKey(arena.getInternalName())) {
				ascore.put(arena.getInternalName(), Bukkit.getScoreboardManager().getNewScoreboard());
			}
			if (!aobjective.containsKey(arena.getInternalName())) {
				aobjective.put(arena.getInternalName(), ascore.get(arena.getInternalName()).registerNewObjective(arena.getInternalName(), "dummy"));
			}

			final Objective objective = aobjective.get(arena.getInternalName());
			objective.setDisplaySlot(DisplaySlot.SIDEBAR);

			objective.setDisplayName(MinigamesAPI.getAPI().pinstances.get(plugin).getMessagesConfig().scoreboard_title.replaceAll("<arena>", arena.getDisplayName()));

			get(objective, plugin.msg().BLUE).setScore(arena.blue);
			get(objective, plugin.msg().RED).setScore(arena.red);
			get(objective, plugin.msg().GREEN).setScore(arena.green);
			get(objective, plugin.msg().YELLOW).setScore(arena.yellow);

			p.setScoreboard(ascore.get(arena.getInternalName()));
		}
	}

	@Override
	public void updateScoreboard(JavaPlugin plugin, final Arena arena) {
		IArena a = (IArena) MinigamesAPI.getAPI().pinstances.get(plugin).getArenaByName(arena.getInternalName());
		this.updateScoreboard(a);
	}

	@Override
	public void removeScoreboard(String arena, Player p) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard sc = manager.getNewScoreboard();
		sc.clearSlot(DisplaySlot.SIDEBAR);
		p.setScoreboard(sc);
	}

}
