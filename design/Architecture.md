com.game.towerdefense

├── Main.java
├── GameApp.java

├── screens/
│   ├── MainMenuScreen.java
│   ├── GameScreen.java
│   ├── PauseScreen.java
│   ├── GameOverScreen.java
│   ├── WinScreen.java

├── entities/
│   ├── Enemy.java
│   ├── Tower.java
│   ├── AdvancedTower.java
│   ├── Bullet.java

├── enemies/
│   ├── BasicEnemy.java
│   ├── FastEnemy.java
│   ├── TankEnemy.java
│   ├── BossEnemy.java

├── towers/
│   ├── ArrowTower.java
│   ├── CannonTower.java
│   ├── IceTower.java
│   ├── SniperTower.java
│   ├── MegaCannonTower.java
│   ├── FreezeAuraTower.java

├── factory/
│   ├── EnemyFactory.java
│   ├── TowerFactory.java
│   ├── MergedTowerFactory.java

├── strategy/
│   ├── AttackStrategy.java
│   ├── FastAttack.java
│   ├── CannonAttack.java
│   ├── FreezeAttack.java
│   ├── SniperAttack.java

├── state/
│   ├── GameState.java
│   ├── PlayingState.java
│   ├── PauseState.java
│   ├── GameOverState.java
│   ├── WinState.java

├── observer/
│   ├── GameObserver.java
│   ├── EventManager.java

├── managers/
│   ├── EnemyManager.java
│   ├── TowerManager.java
│   ├── WaveManager.java
│   ├── MergeManager.java

├── ui/
│   ├── HUD.java
│   ├── TowerMenu.java