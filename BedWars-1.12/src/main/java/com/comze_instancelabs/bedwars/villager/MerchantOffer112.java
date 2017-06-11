package com.comze_instancelabs.bedwars.villager;

import org.bukkit.inventory.ItemStack;

public class MerchantOffer112 {
	
	private ItemStack[] items = new ItemStack[3];
	
	public MerchantOffer112(ItemStack is1, ItemStack is2, ItemStack re) {
		this.items[0] = is1;
		this.items[1] = is2;
		this.items[2] = re;
	}
	
	public MerchantOffer112(ItemStack is, ItemStack re) {
		this(is, null, re);
	}
	
	protected MerchantOffer112(NMSMerchantRecipe112 handle) {
		this.items[0] = OBCCraftItemStack112.asBukkitCopy(handle.getBuyItem1());
		this.items[1] = (handle.getBuyItem2() == null) ? null : OBCCraftItemStack112.asBukkitCopy(handle.getBuyItem2());
		this.items[2] = OBCCraftItemStack112.asBukkitCopy(handle.getBuyItem3());
	}
	
	protected NMSMerchantRecipe112 getHandle() {
		if (this.items[1] == null)
			return new NMSMerchantRecipe112(
					(net.minecraft.server.v1_12_R1.ItemStack) OBCCraftItemStack112.asNMSCopy(this.items[0]),
					(net.minecraft.server.v1_12_R1.ItemStack) OBCCraftItemStack112.asNMSCopy(this.items[2]));
		else
			return new NMSMerchantRecipe112(
					(net.minecraft.server.v1_12_R1.ItemStack) OBCCraftItemStack112.asNMSCopy(this.items[0]),
					(net.minecraft.server.v1_12_R1.ItemStack) OBCCraftItemStack112.asNMSCopy(this.items[1]),
					(net.minecraft.server.v1_12_R1.ItemStack) OBCCraftItemStack112.asNMSCopy(this.items[2]));
	}
	
	public ItemStack getFirstInput() {
		return this.items[0];
	}
	
	public ItemStack getSecondInput() {
		return this.items[1];
	}
	
	public ItemStack getOutput() {
		return this.items[2];
	}
	
}
