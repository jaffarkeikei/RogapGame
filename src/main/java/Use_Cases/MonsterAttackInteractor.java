package Use_Cases;

import Entities.Enemy;
import Entities.Player;
import Entities.MeleeEnemy;
import Entities.RangedEnemy;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class MonsterAttackInteractor implements MonsterAttackInputBoundary {
    private MonsterAttack monsterAttack;
    private Enemy e1;
    private Enemy e2;
    private Player player;

    public MonsterAttackInteractor(ArrayList<Enemy> enemies, MonsterAttack monsterAttack, Player player) {
        this.monsterAttack = monsterAttack;
        this.e1 = enemies.get(0);
        this.e2 = enemies.get(1);
        this.player = player;
    }


    @Override
    public void attack() {
        Ellipse2D.Float p = playerAttack.getHitRadius();
        if (p.intersects(e1.getVisualX(), e1.getVisualY(), 55, 55)) {
            e1.setAttacking(true);
            playerAttack.setHit(true);
            monsterAttack.takeDamage(e1);
        }

        if (p.intersects(e2.getVisualX(), e2.getVisualY(), 55, 55)) {
            e2.setAttacking(true);
            player.setHit(true);
            monsterAttack.takeDamage(e2);
        }

        if (p.intersects(e2.getVisualX(), e2.getVisualY(), 55, 55)) {
            System.out.println("NOOOOOO");
            e2.setAttacking(true);
            playerAttack.setHit(true);
        }
    }

    @Override
    public BufferedImage getCurrAttackHitAnimation() {
        return monsterAttack.getCurrentImage();
    }

//    public BufferedImage getMonsterAttackAnimation() {
//        return monsterAttack.getCurrentImage();  // TODO this should be called on all melee enemies
//    }

    @Override
    public void drawMonstersHitRadius(Graphics g) {
        e1.drawMonsterHitRadius(g);
        e2.drawMonsterHitRadius(g);
    }

    @Override
    public void drawMonstersAttackRadius(Graphics g) {
        e1.drawMonsterAttackRadius(g);
        e2.drawMonsterAttackRadius(g);
    }

    @Override
    public BufferedImage getCurrAnimation() {
        return null;
    }

    @Override
    public void setAnimations(BufferedImage[][] animations) {
        monsterAttack.setAnimations(animations);
    }

    @Override
    public BufferedImage[][] getAnimations() {
        return monsterAttack.getAnimations();
    }
}


