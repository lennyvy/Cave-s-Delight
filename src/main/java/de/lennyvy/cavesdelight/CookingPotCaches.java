package de.lennyvy.cavesdelight.util;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomModelData;

public class CookingPotCaches {
    public final CustomModelData cmd;
    public final ItemStack previousOutput;

    public CookingPotCaches(CustomModelData cmd, ItemStack previousOutput) {
        this.cmd = cmd;
        this.previousOutput = previousOutput;
    }
}