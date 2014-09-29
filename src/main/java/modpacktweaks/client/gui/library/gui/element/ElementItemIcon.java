package modpacktweaks.client.gui.library.gui.element;

import java.util.List;

import modpacktweaks.client.gui.library.gui.IGuiBase;
import modpacktweaks.client.gui.library.gui.utils.GuiUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class ElementItemIcon extends ElementBase
{
    ItemStack item;

    public ElementItemIcon(IGuiBase parent, int x, int y, ItemStack stack)
    {
        super(parent, x, y, 16, 16);
        item = stack;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addTooltip(List<String> list)
    {
        if (item != null)
        {
            List<String> stringList = item.getTooltip(Minecraft.getMinecraft().thePlayer, false);

            for (int k = 0; k < stringList.size(); ++k)
            {
                if (k == 0)
                {
                    stringList.set(k, item.getRarity().rarityColor.toString() + stringList.get(k));
                }
                else
                {
                    stringList.set(k, EnumChatFormatting.GRAY + stringList.get(k));
                }
            }

            for (String s : stringList) // Otherwise we're creating a new list - not adding to the existing one
            {
                list.add(s);
            }
        }
    }

    @Override
    public void draw()
    {
        GuiUtils.drawItemStack(gui, item, posX, posY);
    }

    public void setItem(ItemStack stack)
    {
        item = stack;
    }
}
