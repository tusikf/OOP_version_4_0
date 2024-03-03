package units;

import java.util.ArrayList;

// Снайпер. Своё свойство - нет уникальностей
public class Sniper extends Unit {
    int countArrow;

    public Sniper(String name, int x, int y) {

        super(name, 150, "slingshot", 40, 2, 15, 50, 100, new Position(x, y));
        countArrow = 20;
    }

    @Override
    public String toString() {
        return super.toString() + ", \u27b6 : " + countArrow;
    }

    @Override
    public void step(ArrayList<Unit> enemy, ArrayList<Unit> friend) {
        if ((health <= 0) || (countArrow == 0)) return;
        Unit target = super.nearestEnemy(enemy);
        if (target == null) return;
        target.getHit(this.powerHit);
        countArrow--;
    }

    public String getInfo(){
        return "Снайпер";
    }
}