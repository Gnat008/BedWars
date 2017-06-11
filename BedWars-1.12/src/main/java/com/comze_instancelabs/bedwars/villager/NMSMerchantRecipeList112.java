package com.comze_instancelabs.bedwars.villager;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.server.v1_12_R1.MerchantRecipe;
import net.minecraft.server.v1_12_R1.MerchantRecipeList;

public class NMSMerchantRecipeList112 {
	private MerchantRecipeList handle;

	public NMSMerchantRecipeList112() {
		this.handle = new MerchantRecipeList();
	}

	public MerchantRecipeList getHandle() {
		return this.handle;
	}

	public void clear() {
		this.handle.clear();
	}

	public void add(NMSMerchantRecipe112 recipe) {
		this.handle.add(recipe.getMerchantRecipe());
	}

	public List<NMSMerchantRecipe112> getRecipes() {
		List<NMSMerchantRecipe112> recipeList = new ArrayList<NMSMerchantRecipe112>();
		for (Object obj : handle) {
			recipeList.add(new NMSMerchantRecipe112((MerchantRecipe) obj));
		}
		return recipeList;
	}
}