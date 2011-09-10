/**
 * Copyright (C) 2011 Jacob Scott <jascottytechie@gmail.com>
 * Description: enum to define items & information about them
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package me.jascotty2.lib.bukkit.item;

import me.jascotty2.lib.io.CheckInput;
import java.util.Arrays;
import java.util.LinkedList;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

/**
 * @author jacob
 */
public enum JItems {

    AIR("Air", 0, false),
    STONE("Stone", 1, "4@8+263=8, 4@3+5@2=3"),
    GRASS("Grass", 2, false),
    DIRT("Dirt", 3),
    COBBLESTONE("Cobblestone", 4),
    WOOD("Wood", 5, "17=4"),
    SAPLING("Sapling", 6),
    SPRUCE_SAPLING("Spruce Sapling", 6, (byte) 1),
    PINE_SAPLING("Pine Sapling", 6, (byte) 2),
    BEDROCK("Bedrock", 7, false),
    WATER("Water", 8, false),
    STATIONARY_WATER("Stationary Water", 9, false),
    LAVA("Lava", 10, false),
    STATIONARY_LAVA("Stationary Lava", 11, false),
    SAND("Sand", 12),
    GRAVEL("Gravel", 13),
    GOLD_ORE("Gold Ore", 14),
    IRON_ORE("Iron Ore", 15),
    COAL_ORE("Coal Ore", 16, false),
    LOG("Log", 17),
    REDWOOD_LOG("Redwood", 17, (byte) 1),
    BIRCH_LOG("Birch", 17, (byte) 2),
    LEAVES("Leaves", 18),
    REDWOOD_LEAVES("Redwood Leaves", 18, (byte) 1, false),
    BIRCH_LEAVES("Birch Leaves", 18, (byte) 2, false),
    SPONGE("Sponge", 19, false),
    GLASS("Glass", 20, "12@8+263=8, 12@3+5@2=3"),
    LAPIS_ORE("Lapis Lazuli Ore", 21, false),
    LAPIS_BLOCK("Lapis Lazuli Block", 22, "351:11@9"),
    DISPENSER("Dispenser", 23, "4@7+331+261"),
    SANDSTONE("Sandstone", 24, "12@4"),
    NOTE_BLOCK("Note Block", 25, "5@8+331"),
    BED_BLOCK("Bed Block", 26, false),
    POWERED_RAIL("Powered Rail", 27, "266@6+331+280=6"),
    DETECTOR_RAIL("Detector Rail", 28, "265@6+331+70=6"),
    STICKY_PISTON_BASE("Sticky Piston", 29, "33+341"),
    COBWB("Cobweb", 30, false),
    DEAD_FERN("Dead Fern", 31, (byte) 0, false), // non-natural dead shrub
    TALL_GRASS("Tall Grass", 31, (byte) 1, false),
    FERN("Fern", 31, (byte) 2, false), // or "Living Shrub"
    DEAD_SHRUB("Dead Shrub", 32, false),
    PISTON_BASE("Piston", 33, "5@3+4@4+265+331"),
    PISTON_EXTENSION("Piston Extension", 34, false), // non-placable item
    WOOL("White Wool", 35, "287@9"),
    ORANGE_WOOL("Orange Wool", 35, (byte) 1, "35+351:1"),
    MAGENTA_WOOL("Magenta Wool", 35, (byte) 2, "35+351:2"),
    LIGHT_BLUE_WOOL("Light Blue Wool", 35, (byte) 3, "35+351:3"),
    YELLOW_WOOL("Yellow Wool", 35, (byte) 4, "35+351:4"),
    LIGHT_GREEN_WOOL("Light Green Wool", 35, (byte) 5, "35+351:5"),
    PINK_WOOL("Pink Wool", 35, (byte) 6, "35+351:6"),
    DARK_GRAY_WOOL("Dark Gray Wool", 35, (byte) 7, "35+351:7"),
    LIGHT_GRAY_WOOL("Light Gray Wool", 35, (byte) 8, "35+351:8"),
    CYAN_WOOL("Cyan Wool", 35, (byte) 9, "35+351:9"),
    PURPLE_WOOL("Purple Wool", 35, (byte) 10, "35+351:10"),
    BLUE_WOOL("Blue Wool", 35, (byte) 11, "35+351:11"),
    BROWN_WOOL("Brown Wool", 35, (byte) 12, "35+351:12"),
    DARK_GREEN_WOOL("Dark Green Wool", 35, (byte) 13, "35+351:13"),
    RED_WOOL("Red Wool", 35, (byte) 14, "35+351:14"),
    BLACK_WOOL("Black Wool", 35, (byte) 15, "35+351:15"),
    PISTON_MOVING_PIECE("Piston Moving Piece", 36, false), // non-placable item
    YELLOW_FLOWER("Yellow Flower", 37),
    RED_ROSE("Red Rose", 38),
    BROWN_MUSHROOM("Brown Mushroom", 39),
    RED_MUSHROOM("Red Mushroom", 40),
    GOLD_BLOCK("Gold Block", 41, "266@9"),
    IRON_BLOCK("Iron Block", 42, "265@9"),
    DOUBLE_STEP("Double Step", 43, "44@2", false),
    SANDSTONE_DOUBLE_STEP("Sandstone Double Step", 43, (byte) 1, "44:1@2", false),
    WOOD_DOUBLE_STEP("Wood Double Step", 43, (byte) 2, "44:2@2", false),
    COBBLESTONE_DOUBLE_STEP("Cobblestone Double Step", 43, (byte) 3, "44:3@2"),
    STEP("Step", 44, "1@3"),
    SANDSTONE_STEP("Sandstone Step", 44, (byte) 1, "24@3"),
    WOOD_STEP("Wood Step", 44, (byte) 2, "5@3"),
    COBBLESTONE_STEP("Cobblestone Step", 44, (byte) 3, "4@3"),
    BRICK("Brick Block", 45, "336@4"),
    TNT("TNT", 46, "12@4+289@5"),
    BOOKSHELF("Bookshelf", 47, "5@6+340@3"),
    MOSSY_COBBLESTONE("Moss Stone", 48),
    OBSIDIAN("Obsidian", 49),
    TORCH("Torch", 50, "280+263=4"),
    FIRE("Fire", 51, false),
    //ETERNAL_FIRE("EternalFire", 51, 16, false),
    MOB_SPAWNER("Monster Spawner", 52, false),
    WOOD_STAIRS("Wooden Stairs", 53, "5@6=4"),
    CHEST("Chest", 54, "5@8"),
    REDSTONE_WIRE("Redstone Wire", 55, false),
    DIAMOND_ORE("Diamond Ore", 56, false),
    DIAMOND_BLOCK("Diamond Block", 57, "264@9"),
    WORKBENCH("Crafting Table", 58, "5@4"),
    CROPS("Crops", 59, false),
    SOIL("Soil", 60, false),
    FURNACE("Furnace", 61, "4@8"),
    BURNING_FURNACE("Burning Furnace", 62, false),
    SIGN_POST("Sign Post", 63, false),
    WOODEN_DOOR("Wooden Door Block", 64, false),
    LADDER("Ladder", 65, "280@7=2"),
    RAILS("Rails", 66, "265@6+280=16"),
    COBBLESTONE_STAIRS("Cobblestone Stairs", 67, "4@6"),
    WALL_SIGN("Wall Sign", 68, false),
    LEVER("Lever", 69, "4+280"),
    STONE_PLATE("Stone Pressure Plate", 70, "1@2"),
    IRON_DOOR_BLOCK("Iron Door Block", 71, false),
    WOOD_PLATE("Wooden Pressure Plate", 72, "5@2"),
    REDSTONE_ORE("Redstone Ore", 73, false),
    GLOWING_REDSTONE_ORE("Glowing Redstone Ore", 74, false),
    REDSTONE_TORCH_OFF("Redstone Torch Off", 75, false),
    REDSTONE_TORCH("Redstone Torch", 76, "280+331"),
    STONE_BUTTON("Stone Button", 77, "1@2"),
    SNOW("Snow Covering", 78, false),
    ICE("Ice", 79, false),
    SNOW_BLOCK("Snow Block", 80),
    CACTUS("Cactus", 81),
    CLAY("Clay Block", 82, "337@4"),
    SUGAR_CANE_BLOCK("Sugar Cane Block", 83, false),
    JUKEBOX("Jukebox", 84, "5@8+264"),
    FENCE("Fence", 85, "280@6"),
    PUMPKIN("Pumpkin", 86),
    NETHERRACK("Netherrack", 87),
    SOUL_SAND("Soulsand", 88),
    GLOWSTONE("Glowstone", 89, "348@9"),
    PORTAL("Portal", 90, false),
    JACK_O_LANTERN("Jack O'Lantern", 91),
    CAKE_BLOCK("Cake Block", 92, false),
    DIODE_BLOCK_OFF("Repeater Block Off", 93, false),
    DIODE_BLOCK_ON("Repeater Block On", 94, false),
    LOCKED_CHEST("Locked Chest", 95, false),
    TRAPDOOR("Trapdoor", 96, "5@6=2"),
    IRON_SPADE("Iron Shovel", 256, "280@2+265", (short) 251),
    IRON_PICKAXE("Iron Pickaxe", 257, "280@2+265@3", (short) 251),
    IRON_AXE("Iron Axe", 258, "280@2+265@3", (short) 251),
    FLINT_AND_STEEL("Flint And Steel", 259, "318+265", (short) 65),
    APPLE("Apple", 260, 1),
    BOW("Bow", 261, "280@3+287@3", 1),
    ARROW("Arrow", 262, "280+318+288"),
    COAL("Coal", 263),
    CHARCOAL("Charcoal", 263, (byte) 1),
    DIAMOND("Diamond", 264),
    IRON_INGOT("Iron Ingot", 265, "15@8+263=8, 15@3+5@2=3"),
    GOLD_INGOT("Gold Ingot", 266, "14@8+263=8, 14@3+5@2=3"),
    IRON_SWORD("Iron Sword", 267, "280+265@2", (short) 251),
    WOOD_SWORD("Wooden Sword", 268, "280+5@2", (short) 60),
    WOOD_SPADE("Wooden Shovel", 269, "280@2+5", (short) 60),
    WOOD_PICKAXE("Wooden Pickaxe", 270, "280@2+5@3", (short) 60),
    WOOD_AXE("Wooden Axe", 271, "280@2+5@3", (short) 60),
    STONE_SWORD("Stone Sword", 272, "280+5@2", (short) 132),
    STONE_SPADE("Stone Shovel", 273, "280@2+4", (short) 132),
    STONE_PICKAXE("Stone Pickaxe", 274, "280@2+4@3", (short) 132),
    STONE_AXE("Stone Axe", 275, "280@2+4@3", (short) 132),
    DIAMOND_SWORD("Diamond Sword", 276, "280+264@2", (short) 1562),
    DIAMOND_SPADE("Diamond Shovel", 277, "280@2+264", (short) 1562),
    DIAMOND_PICKAXE("Diamond Pickaxe", 278, "280@2+264@3", (short) 1562),
    DIAMOND_AXE("Diamond Axe", 279, "280@2+264@3", (short) 1562),
    STICK("Stick", 280, "5@2=4"),
    BOWL("Bowl", 281, "5@3=4"),
    MUSHROOM_SOUP("Mushroom Soup", 282, "281+39+40", 1),
    GOLD_SWORD("Gold Sword", 283, "280+266@2", (short) 33),
    GOLD_SPADE("Gold Shovel", 284, "280@2+266", (short) 33),
    GOLD_PICKAXE("Gold Pickaxe", 285, "280@2+266@3", (short) 33),
    GOLD_AXE("Gold Axe", 286, "280@2+266@3", (short) 33),
    STRING("String", 287),
    FEATHER("Feather", 288),
    SULPHUR("Gunpowder", 289),
    WOOD_HOE("WoodenHoe", 290, "280@2+5@2", (short) 60),
    STONE_HOE("StoneHoe", 291, (short) 132),
    IRON_HOE("IronHoe", 292, (short) 251),
    DIAMOND_HOE("Diamond Hoe", 293, (short) 1562),
    GOLD_HOE("Gold Hoe", 294, (short) 33),
    SEEDS("Seeds", 295),
    WHEAT("Wheat", 296),
    BREAD("Bread", 297, "296@3", 1),
    LEATHER_HELMET("Leather Helmet", 298, "334@5", (short) 34),
    LEATHER_CHESTPLATE("Leather Chestplate", 299, "334@8", (short) 49),
    LEATHER_LEGGINGS("Leather Leggings", 300, "334@7", (short) 46),
    LEATHER_BOOTS("Leather Boots", 301, "334@4", (short) 40),
    // chainmail is currently illegal, but should be added later..
    CHAINMAIL_HELMET("Chainmail Helmet", 302, (short) 67, false),
    CHAINMAIL_CHESTPLATE("Chainmail Chestplate", 303, (short) 96, false),
    CHAINMAIL_LEGGINGS("Chainmail Leggings", 304, (short) 92, false),
    CHAINMAIL_BOOTS("Chainmail Boots", 305, (short) 79, false),
    IRON_HELMET("Iron Helmet", 306, "265@5", (short) 136),
    IRON_CHESTPLATE("Iron Chestplate", 307, "265@8", (short) 192),
    IRON_LEGGINGS("Iron Leggings", 308, "265@7", (short) 184),
    IRON_BOOTS("Iron Boots", 309, "265@4", (short) 160),
    DIAMOND_HELMET("Diamond Helmet", 310, "265@5", (short) 272),
    DIAMOND_CHESTPLATE("Diamond Chestplate", 311, "265@8", (short) 285),
    DIAMOND_LEGGINGS("Diamond Leggings", 312, "265@7", (short) 368),
    DIAMOND_BOOTS("Diamond Boots", 313, "265@4", (short) 320),
    GOLD_HELMET("Gold Helmet", 314, "265@5", (short) 68),
    GOLD_CHESTPLATE("Gold Chestplate", 315, "265@8", (short) 96),
    GOLD_LEGGINGS("Gold Leggings", 316, "265@7", (short) 92),
    GOLD_BOOTS("Gold Boots", 317, "265@4", (short) 80),
    FLINT("Flint", 318),
    PORK("Raw Porkchop", 319, 1),
    GRILLED_PORK("Cooked Porkchop", 320, "319@6+263=6", 1), // intentionally less-than-perfect conversion
    PAINTING("Painting", 321, "280@8+15"),
    GOLDEN_APPLE("Golden Apple", 322, "260+41@8", 1),
    SIGN("Sign", 323, "280+5@6", 1),
    WOOD_DOOR("Wooden Door", 324, "5@6", 1),
    BUCKET("Bucket", 325, "265@3", 1),
    WATER_BUCKET("Water Bucket", 326, 1),
    LAVA_BUCKET("Lava Bucket", 327, 1),
    MINECART("Minecart", 328, "265@5", 1),
    SADDLE("Saddle", 329, 1),
    IRON_DOOR("Iron Door", 330, "265@6", 1),
    REDSTONE("Redstone", 331),
    SNOW_BALL("Snowball", 332, 16),
    BOAT("Boat", 333, "5@5", 1),
    LEATHER("Leather", 334),
    MILK_BUCKET("Milk Bucket", 335, 1),
    CLAY_BRICK("Clay Brick", 336, "337@8+263=8, 337@3+5@2=3"),
    CLAY_BALL("Clay Balls", 337),
    SUGAR_CANE("Sugar Cane", 338),
    PAPER("Paper", 339, "338@3=3"),
    BOOK("Book", 340, "339@3"),
    SLIME_BALL("Slimeball", 341),
    STORAGE_MINECART("Storage Minecart", 342, "328+54", 1),
    POWERED_MINECART("Powered Minecart", 343, "328+61", 1),
    EGG("Egg", 344, 16),
    COMPASS("Compass", 345, "265@4+331"),
    FISHING_ROD("Fishing Rod", 346, "280@3+287@2", 33),
    WATCH("Clock", 347, "266@4+331"),
    GLOWSTONE_DUST("Glowstone Dust", 348),
    RAW_FISH("Raw Fish", 349, 1),
    COOKED_FISH("Cooked Fish", 350, "349@6+263=6", 1), // intentionally less-than-perfect conversion
    INK_SACK("Ink Sac", 351),
    RED_DYE("Red Dye", 351, (byte) 1, "38=2"),
    GREEN_DYE("Green Dye", 351, (byte) 2, "81@8+263=8, 81@3+5@2=3"),
    BROWN_DYE("Cocoa Bean", 351, (byte) 3), // no current method for crafting cocoa
    BLUE_DYE("Lapis Lazuli", 351, (byte) 4, "22=9"),
    PURPLE_DYE("Purple Dye", 351, (byte) 5, "351:4+351:1=2"),
    CYAN_DYE("Cyan Dye", 351, (byte) 6, "351:4+351:2=2"),
    LIGHT_GRAY_DYE("Light Gray Dye", 351, (byte) 7, "351:8+351:15=2"),
    GRAY_DYE("Gray Dye", 351, (byte) 8, "351:15+351=2"),
    PINK_DYE("Pink Dye", 351, (byte) 9, "351:1+351=2"),
    LIME_DYE("Lime Dye", 351, (byte) 10, "351:2+351:15=2"),
    YELLOW_DYE("Yellow Dye", 351, (byte) 11, "37=2"),
    LIGHT_BLUE_DYE("Light Blue Dye", 351, (byte) 12, "351:4+351:15=2"),
    MAGENTA_DYE("Magenta Dye", 351, (byte) 13, "351:4+351:9=2"),
    ORANGE_DYE("Orange Dye", 351, (byte) 14, "351:1+351:11=2"),
    BONEMEAL("Bone Meal", 351, (byte) 15, "352=2"),
    BONE("Bone", 352),
    SUGAR("Sugar", 353, "338"),
    CAKE("Cake", 354, "335@3+353@2+344+296@3", 1),
    BED("Bed", 355, "5@3+35@3", 1),
    DIODE("Redstone Repeater", 356, "1@3+76@2+331"),
    COOKIE("Cookie", 357, "296@2+351:3", 8),
    MAP("Map", 358, "339@8+345"),
    SHEARS("Shears", 359, "265@2", (short) 239),
    GOLD_RECORD("Gold Record", 2256, 1),
    GREEN_RECORD("Green Record", 2257, 1);
// Item Information
    private int itemId;
    private byte itemData;
    private boolean isLegal = true; // is is legitemitely obtainable
    private int maxStack = 64;
    private short maxdamage = 0; // indicates that this is a tool
    public String name = null;//, category = null;
    private LinkedList<CraftRecipe> recipes = new LinkedList<CraftRecipe>();

    private JItems(String name, int id) {
        if (SetID(id)) {
            this.name = name;
        }
    }

    private JItems(String name, int id, boolean legal) {
        if (SetID(id)) {
            this.name = name;
            isLegal = legal;
        }
    }

    private JItems(String name, int id, byte dat) {
        if (SetID(id)) {
            this.name = name;
            itemData = dat;
        }
    }

    private JItems(String name, int id, int maxStack) {
        if (SetID(id)) {
            this.name = name;
            this.maxStack = maxStack;
        }
    }

    private JItems(String name, int id, int maxStack, boolean legal) {
        if (SetID(id)) {
            this.name = name;
            this.maxStack = maxStack;
            isLegal = legal;
        }
    }

    private JItems(String name, int id, byte dat, boolean legal) {
        if (SetID(id)) {
            this.name = name;
            itemData = dat;
            isLegal = legal;
        }
    }

    private JItems(String name, int id, String craftRecipies) {
        if (SetID(id)) {
            this.name = name;
            _setRecipe(craftRecipies);
        }
    }

    private JItems(String name, int id, String craftRecipies, boolean legal) {
        if (SetID(id)) {
            this.name = name;
            isLegal = legal;
            _setRecipe(craftRecipies);
        }
    }

    private JItems(String name, int id, byte dat, String craftRecipies) {
        if (SetID(id)) {
            this.name = name;
            itemData = dat;
            _setRecipe(craftRecipies);
        }
    }

    private JItems(String name, int id, String craftRecipies, int maxStack) {
        if (SetID(id)) {
            this.name = name;
            this.maxStack = maxStack;
            _setRecipe(craftRecipies);
        }
    }

    private JItems(String name, int id, String craftRecipies, int maxStack, boolean legal) {
        if (SetID(id)) {
            this.name = name;
            isLegal = legal;
            this.maxStack = maxStack;
            _setRecipe(craftRecipies);
        }
    }

    private JItems(String name, int id, String craftRecipies, short maxDamage) {
        if (SetID(id)) {
            this.name = name;
            this.maxdamage = maxDamage;
            this.maxStack = maxdamage > 0 ? 1 : 64;
            _setRecipe(craftRecipies);
        }
    }

    private JItems(String name, int id, String craftRecipies, short maxDamage, boolean legal) {
        if (SetID(id)) {
            this.name = name;
            isLegal = legal;
            this.maxdamage = maxDamage;
            this.maxStack = maxdamage > 0 ? 1 : 64;
            _setRecipe(craftRecipies);
        }
    }

    private JItems(String name, int id, byte dat, String craftRecipies, int maxStack, short maxDamage) {
        if (SetID(id)) {
            this.name = name;
            itemData = dat;
            this.maxStack = maxStack;
            this.maxdamage = maxDamage;
            _setRecipe(craftRecipies);
        }
    }

    private JItems(String name, int id, byte dat, String craftRecipies, boolean legal) {
        if (SetID(id)) {
            this.name = name;
            itemData = dat;
            isLegal = legal;
            _setRecipe(craftRecipies);
        }
    }

    private JItems(int id) {
        if (SetID(id)) {
            AutoName();
        }
    }

    private JItems(int id, byte dat) {
        if (SetID(id)) {
            itemData = dat;
            AutoName();
        }
    }

//    private JItems(ItemStack i) {
//        itemId = i.getTypeId();
//        //if(maxdamage==0)// i.getDurability()<MAX_DATA)
//        itemData = (byte) i.getDurability();
//        name = "";
//    }
    private boolean SetID(int id) {
        if (org.bukkit.Material.getMaterial(id) != null) {
            itemId = id;
            return true;
        } else {
            System.out.println("invalid item: " + id + " (is this plugin up-to-date?)");
            itemId = -1;
            name = "";
            isLegal = false;
            maxStack = 0;
            return false;
        }
    }

    private void AutoName() {
        if (org.bukkit.Material.getMaterial(itemId) != null) {
            name = org.bukkit.Material.getMaterial(itemId).name();
        } else {
            name = "";
        }
    }

    public int ID() {
        return itemId;
    }

    public byte Data() {
        return itemData;
    }

    public short MaxDamage() {
        return maxdamage;
    }

    public boolean IsTool() {
        return maxdamage > 0;
    }

    public boolean IsLegal() {
        return isLegal;
    }

    public int MaxStackSize() {
        return maxStack;
    }

    public String IdDatStr() {
        return String.format("%d:%d", itemId, itemData);
    }

    public String getName() {
        return name == null ? this.name() : name;
    }

    public void setName(String newname) {
        if (newname != null) {
            this.name = newname;
        }
    }

    protected void setMaxStack(int stack) {
        maxStack = stack;
    }

    private JItem _getIdDat(String datStr) {
        String s1 = datStr.contains(":") ? datStr.substring(0, datStr.indexOf(":")).trim() : datStr,
                s2 = datStr.contains(":") ? datStr.substring(datStr.indexOf(":") + 1).trim() : "";
        JItem r = new JItem();
        r.itemId = CheckInput.GetInt(s1, -1);
        r.itemDat = CheckInput.GetByte(s2, (byte) 0);
        if (r.itemId > 0) {
            return r;
        }
        return null;
    }

    private CraftRecipe _getRecipe(String craftStr) {
        CraftRecipe ret = new CraftRecipe();

        // get result amount
        if (craftStr.contains("=")) {
            if (craftStr.split("=").length > 2 || craftStr.length() == craftStr.indexOf("=")) {
                return null;
            }
            ret.resultAmount = CheckInput.GetInt(craftStr.substring(craftStr.indexOf("=") + 1), 0);
            craftStr = craftStr.substring(0, craftStr.indexOf("="));
        } else {
            ret.resultAmount = 1;
        }
        // extract all items
        for (String i : craftStr.split("\\+")) {
            if (i.contains("@")) {
                if (i.length() > i.indexOf("@")) {
                    ret.AddItem(_getIdDat(i.substring(0, i.indexOf("@"))),
                            CheckInput.GetInt(i.substring(i.indexOf("@") + 1), 0));
                } else {
                    ret.AddItem(_getIdDat(i.substring(0, i.indexOf("@"))));
                }
            } else {
                ret.AddItem(_getIdDat(i));
            }
        }
        return ret.totalItems() == 0 ? null : ret;
    }

    private void _setRecipe(String craft) {
        if (craft != null) {
            for (String i : craft.split(",")) {
                CraftRecipe toAdd = _getRecipe(i);
                if (toAdd != null) {
                    recipes.add(toAdd);
                }
            }
        }
    }

    public boolean HasRecipe() {
        return recipes.size() > 0;
    }

    public Kit[] GetRecipeAsKit(int index) {
        if (index >= 0 && index < recipes.size()) {
            return recipes.get(index).getKits();
        }
        return null;
    }

    public Kit[] GetFullRecipeKits() {
        LinkedList<Kit> ret = new LinkedList<Kit>();
        for (CraftRecipe c : recipes) {
            ret.addAll(Arrays.asList(c.getKits()));
        }
        return ret.toArray(new Kit[0]);
    }

    public CraftRecipe GetRecipe(int index) {
        if (index >= 0 && index < recipes.size()) {
            return recipes.get(index);
        }
        return null;
    }

    public CraftRecipe[] GetRecipes() {
        return recipes.toArray(new CraftRecipe[0]);
    }

    public ItemStack toItemStack() {
        return isEntity() || itemId < 0 ? null : new ItemStack(itemId, 1, (short) 0, itemData);
    }

    public ItemStack toItemStack(int amount) {
        return isEntity() || itemId < 0 ? null : new ItemStack(itemId, amount, (short) 0, itemData);
    }

    // creatures are numbered starting at 4000
    public boolean isEntity() {
        return itemId >= 4000 && itemId < 5000;
    }

    public static JItems getItem(int id) {
        for (JItems i : JItems.values()) {
            if (i.itemId == id && i.itemData == 0) {
                return i;
            }
        }
        return null;
    }

    public static JItems getItem(int id, byte dat) {
        for (JItems i : JItems.values()) {
            if (i.itemId == id && i.itemData == dat) {
                return i;
            }
        }
        return null;
    }

    public static JItems getItem(Material material) {
        for (JItems i : JItems.values()) {
            if (i.itemId == material.getId() && i.itemData == 0) {
                return i;
            }
        }
        return null;
    }

    public static JItems findItem(Item search) {
        if (search == null || search.getItemStack() == null) {
            return null;
        }
        int id = search.getItemStack().getTypeId();
        byte dat = search.getItemStack().getData().getData();
        for (JItems i : JItems.values()) {
            if (i.itemId == id && i.itemData == dat) {
                return i;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("%s (%d:%d)", getName(), itemId, itemData);
    }

    public boolean equals(ItemStack i) {
        return i != null
                && itemId == i.getTypeId()
                && (IsTool() || itemData == i.getDurability());
    }
} // end class JItems

