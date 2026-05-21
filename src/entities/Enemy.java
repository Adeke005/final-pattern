package entities;

import com.badlogic.gdx.math.Vector2;
import java.util.List;

public abstract class Enemy {
    protected Vector2 position;
    protected int hp;
    protected int damageToBase;
    protected int rewardGold;
    protected float speed;

    protected int currentPathIndex = 0;
    protected boolean reachedBase = false;

    public Enemy(float x, float y, int hp, float speed, int damageToBase, int rewardGold) {
        this.position = new Vector2(x, y);
        this.hp = hp;
        this.speed = speed;
        this.damageToBase = damageToBase;
        this.rewardGold = rewardGold;
    }

    public void update(float delta, List<Vector2> pathPoints) {
        if (isDead() || reachedBase || pathPoints.isEmpty()) return;

        if (currentPathIndex >= pathPoints.size()) {
            reachedBase = true;
            return;
        }

        Vector2 target = pathPoints.get(currentPathIndex);
        Vector2 direction = new Vector2(target).sub(position);

        if (direction.len() < 5f) {
            currentPathIndex++;
        } else {
            direction.nor();
            position.add(direction.scl(speed * delta));
        }
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
    }

    public void slowDown() {
        speed *= 0.7f;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public boolean hasReachedBase() {
        return reachedBase;
    }

    public Vector2 getPosition() {
        return position;
    }

    public int getDamageToBase() {
        return damageToBase;
    }

    public int getRewardGold() {
        return rewardGold;
    }

    public int getHp() {
        return hp;
    }
}