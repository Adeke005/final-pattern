+----------------+
|    GameApp     |
+----------------+
| +create()      |
| +render()      |
+----------------+
|
v
+----------------+
|   GameScreen   |
+----------------+
| -base          |
| -waveManager   |
| -towers        |
| -enemies       |
| -gold          |
| -waveNumber    |
+----------------+
| +update()      |
| +render()      |
| +placeTower()  |
+----------------+
|        |        |
v        v        v

+---------+   +-------------+   +-------------+
|  Base   |   | WaveManager |   |    Tower    |
+---------+   +-------------+   +-------------+
| -hp     |   | -waveNumber |   | -damage     |
| -maxHp  |   | -enemiesLeft|   | -range      |
+---------+   +-------------+   | -fireRate   |
| +damage()|  | +startWave()|   +-------------+
| +isDead()|  | +spawnEnemy()|  | +attack()   |
+---------+   +-------------+   +-------------+

                      |
                      v
              +---------------+
              | EnemyFactory  |
              +---------------+
              | +createEnemy()|
              +---------------+
                      |
                      v
+----------------+
|     Enemy      |
+----------------+
| -hp            |
| -speed         |
| -reward        |
| -position      |
+----------------+
| +move()        |
| +takeDamage()  |
| +isDead()      |
+----------------+