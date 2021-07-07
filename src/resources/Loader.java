package resources;


//import java.io.File;


import javax.imageio.ImageIO;

public class Loader {
	public void load(){
        try {  
        	Resources.TEXTURES.add(Resources.TILE, ImageIO.read(getClass().getResource("/image/title.png")));
    		Resources.TEXTURES.add(Resources.WALL, ImageIO.read(getClass().getResource("/image/wall.png")));
    		Resources.TEXTURES.add(Resources.WATER, ImageIO.read(getClass().getResource("/image/water.png")));
    		Resources.TEXTURES.add(Resources.DIRT, ImageIO.read(getClass().getResource("/image/dirt.png")));
            Resources.TEXTURES.add(Resources.TREE, ImageIO.read(getClass().getResource("/image/tree.png")));
            Resources.TEXTURES.add(Resources.STONE, ImageIO.read(getClass().getResource("/image/stone.png")));
            Resources.TEXTURES.add(Resources.GRASS, ImageIO.read(getClass().getResource("/image/grass.png")));              
            Resources.TEXTURES.add(Resources.PLAYER, ImageIO.read(getClass().getResource("/image/player.png")));
            Resources.TEXTURES.add(Resources.PLAYER_2, ImageIO.read(getClass().getResource("/image/player_2.png")));
            Resources.TEXTURES.add(Resources.PLAYER_BACK, ImageIO.read(getClass().getResource("/image/player_back.png")));
            Resources.TEXTURES.add(Resources.PLAYER_BACK_2, ImageIO.read(getClass().getResource("/image/player_back_2.png")));
            Resources.TEXTURES.add(Resources.PLAYER_LEFT, ImageIO.read(getClass().getResource("/image/player_left.png")));
            Resources.TEXTURES.add(Resources.PLAYER_LEFT_2, ImageIO.read(getClass().getResource("/image/player_left_2.png")));
            Resources.TEXTURES.add(Resources.PLAYER_RIGHT, ImageIO.read(getClass().getResource("/image/player_right.png")));
            Resources.TEXTURES.add(Resources.PLAYER_RIGHT_2, ImageIO.read(getClass().getResource("/image/player_right_2.png")));
            Resources.TEXTURES.add(Resources.AD, ImageIO.read(getClass().getResource("/image/AD.png")));
            Resources.TEXTURES.add(Resources.AD_2, ImageIO.read(getClass().getResource("/image/AD_2.png")));
            Resources.TEXTURES.add(Resources.BULLET, ImageIO.read(getClass().getResource("/image/Bullet.png")));
            Resources.TEXTURES.add(Resources.MISSILE, ImageIO.read(getClass().getResource("/image/missile.png")));
            Resources.TEXTURES.add(Resources.MONSTER, ImageIO.read(getClass().getResource("/image/monster.png")));
            Resources.TEXTURES.add(Resources.MONSTER_2, ImageIO.read(getClass().getResource("/image/monster_2.png")));
            Resources.TEXTURES.add(Resources.MONSTER_ATTACK, ImageIO.read(getClass().getResource("/image/monster_attack.png")));
            Resources.TEXTURES.add(Resources.GHOST, ImageIO.read(getClass().getResource("/image/ghost.png")));
            Resources.TEXTURES.add(Resources.GHOST_2, ImageIO.read(getClass().getResource("/image/ghost_2.png")));
            Resources.TEXTURES.add(Resources.GHOST_ATTACK, ImageIO.read(getClass().getResource("/image/ghost_attack.png")));
            Resources.TEXTURES.add(Resources.GHOST_INVISIBLE, ImageIO.read(getClass().getResource("/image/ghost_invi.png")));
            Resources.TEXTURES.add(Resources.GHOST_VISIBLE_2, ImageIO.read(getClass().getResource("/image/ghost_invi2.png")));
            Resources.TEXTURES.add(Resources.ITEM, ImageIO.read(getClass().getResource("/image/item.png")));
            Resources.TEXTURES.add(Resources.OBSTACLE, ImageIO.read(getClass().getResource("/image/obstacel.png")));
            Resources.TEXTURES.add(Resources.OBSTACLE_2, ImageIO.read(getClass().getResource("/image/obstacel_2.png")));
            Resources.TEXTURES.add(Resources.BACKGROUND, ImageIO.read(getClass().getResource("/image/anh_nen.jpg")));
            Resources.TEXTURES.add(Resources.PLAYER_ICE, ImageIO.read(getClass().getResource("/image/ice.png")));
            Resources.TEXTURES.add(Resources.F_MONSTER, ImageIO.read(getClass().getResource("/image/f_monster.png")));
            Resources.TEXTURES.add(Resources.F_MONSTER_2, ImageIO.read(getClass().getResource("/image/f_monster_2.png")));
            Resources.TEXTURES.add(Resources.Q, ImageIO.read(getClass().getResource("/image/Q.png")));
            Resources.TEXTURES.add(Resources.R, ImageIO.read(getClass().getResource("/image/R.png")));
            Resources.TEXTURES.add(Resources.BLOOD, ImageIO.read(getClass().getResource("/image/blood.png")));
            Resources.TEXTURES.add(Resources.DARK, ImageIO.read(getClass().getResource("/image/dark.png")));        
            Resources.TEXTURES.add(Resources.HEART, ImageIO.read(getClass().getResource("/image/heart.png")));
            Resources.TEXTURES.add(Resources.MANA, ImageIO.read(getClass().getResource("/image/mana.png")));
            Resources.TEXTURES.add(Resources.ARMOR, ImageIO.read(getClass().getResource("/image/armor.png")));
            Resources.TEXTURES.add(Resources.ULTI, ImageIO.read(getClass().getResource("/image/ulti.png")));
            Resources.TEXTURES.add(Resources.HEARTB, ImageIO.read(getClass().getResource("/image/HPBar.png")));
            Resources.TEXTURES.add(Resources.MANAB, ImageIO.read(getClass().getResource("/image/MPBar.png")));
            Resources.TEXTURES.add(Resources.ARMORB, ImageIO.read(getClass().getResource("/image/DefBar.png")));
            Resources.TEXTURES.add(Resources.ULTIB, ImageIO.read(getClass().getResource("/image/RBar.png")));
            Resources.TEXTURES.add(Resources.BUTTON_1, ImageIO.read(getClass().getResource("/image/Button_1.png")));
            Resources.TEXTURES.add(Resources.BUTTON, ImageIO.read(getClass().getResource("/image/Button_2.png")));
            Resources.TEXTURES.add(Resources.UFO, ImageIO.read(getClass().getResource("/image/ufo.png")));
            Resources.TEXTURES.add(Resources.PLANET, ImageIO.read(getClass().getResource("/image/planet.png")));
            Resources.TEXTURES.add(Resources.UNIVERSE, ImageIO.read(getClass().getResource("/image/universe.jpg")));
            Resources.TEXTURES.add(Resources.WALL1, ImageIO.read(getClass().getResource("/image/wall1.png")));
            Resources.TEXTURES.add(Resources.WALL2, ImageIO.read(getClass().getResource("/image/wall2.png")));
            Resources.TEXTURES.add(Resources.WALL3, ImageIO.read(getClass().getResource("/image/wall3.png")));
            Resources.TEXTURES.add(Resources.WALL4, ImageIO.read(getClass().getResource("/image/wall4.png")));
            Resources.TEXTURES.add(Resources.WALL5, ImageIO.read(getClass().getResource("/image/wall5.png")));
            Resources.TEXTURES.add(Resources.WALL6, ImageIO.read(getClass().getResource("/image/wall6.png")));
            Resources.TEXTURES.add(Resources.WALL7, ImageIO.read(getClass().getResource("/image/wall7.png")));
            Resources.TEXTURES.add(Resources.WALL8, ImageIO.read(getClass().getResource("/image/wall8.png")));
            Resources.TEXTURES.add(Resources.WALL9, ImageIO.read(getClass().getResource("/image/wall9.png")));
            Resources.TEXTURES.add(Resources.WALL10, ImageIO.read(getClass().getResource("/image/wall10.png")));
            Resources.TEXTURES.add(Resources.WALL11, ImageIO.read(getClass().getResource("/image/wall11.png")));
            Resources.TEXTURES.add(Resources.WALL12, ImageIO.read(getClass().getResource("/image/wall12.png")));
            Resources.TEXTURES.add(Resources.WALL13, ImageIO.read(getClass().getResource("/image/wall13.png")));
            Resources.TEXTURES.add(Resources.WALL14, ImageIO.read(getClass().getResource("/image/wall14.png")));
            Resources.TEXTURES.add(Resources.WALL15, ImageIO.read(getClass().getResource("/image/wall15.png")));
            Resources.TEXTURES.add(Resources.WALL16, ImageIO.read(getClass().getResource("/image/wall16.png")));
            Resources.TEXTURES.add(Resources.WALL17, ImageIO.read(getClass().getResource("/image/wall17.png")));
            Resources.TEXTURES.add(Resources.WALL18, ImageIO.read(getClass().getResource("/image/wall18.png")));
            Resources.TEXTURES.add(Resources.WALL19, ImageIO.read(getClass().getResource("/image/wall19.png")));
            Resources.TEXTURES.add(Resources.WALL20, ImageIO.read(getClass().getResource("/image/wall20.png")));
            Resources.TEXTURES.add(Resources.WALL21, ImageIO.read(getClass().getResource("/image/wall21.png")));
            Resources.TEXTURES.add(Resources.BLOOD_FALL, ImageIO.read(getClass().getResource("/image/blood_fall.png")));
        }catch (Exception e) {
        		System.out.print("Load Failed\n");
                e.printStackTrace();
        }
}
}
