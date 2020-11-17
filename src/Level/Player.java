package Level;

import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.GamePanel;
import GameObject.GameObject;
import GameObject.SpriteSheet;
import Utils.AirGroundState;
import Utils.Direction;
import Engine.Audio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Player extends GameObject {

	// values that affect player movement
	// these should be set in a subclass
	protected float walkSpeed = 0;
	protected float gravity = 0;
	protected float jumpHeight = 0;
	protected float jumpDegrade = 0;
	protected float terminalVelocityY = 0;
	protected float momentumYIncrease = 0;
	protected int currentHealth = 9;
	protected int totalCoins = 0;
	protected int currentCoins = 0;
	protected float knockbackAmount = 0;
	protected float knockMaxHeight = 20;

	// values used to handle player movement
	protected float jumpForce = 0;
	protected float momentumY = 0;
	protected float moveAmountX, moveAmountY;

	// values used to keep track of player's current state
	protected PlayerState playerState;
	protected PlayerState previousPlayerState;
	protected Direction facingDirection;
	protected AirGroundState airGroundState;
	protected AirGroundState previousAirGroundState;
	protected LevelState levelState;

	// classes that listen to player events can be added to this list
	protected ArrayList<PlayerListener> listeners = new ArrayList<>();

	// define keys
	protected KeyLocker keyLocker = new KeyLocker();
	protected Key JUMP_KEY = Key.currentUP;
	protected Key MOVE_LEFT_KEY = Key.currentLEFT;
	protected Key MOVE_RIGHT_KEY = Key.currentRIGHT;
	protected Key CROUCH_KEY = Key.currentDOWN;

	// if true, player cannot be hurt by enemies (good for testing)
	protected boolean isInvincible = false;

	// Each check if the player should be knocked back to the right, left or if the
	// player was just hit
	protected boolean knockRight = false;
	protected boolean knockLeft = false;
	protected boolean justHurt = false;

	protected Audio audio = null;
	protected FileWriter mapWriter;


	public Player(SpriteSheet spriteSheet, float x, float y, String startingAnimationName) {
		super(spriteSheet, x, y, startingAnimationName);
		audio = GamePanel.getAudio();
		facingDirection = Direction.RIGHT;
		airGroundState = AirGroundState.AIR;
		previousAirGroundState = airGroundState;
		playerState = PlayerState.STANDING;
		previousPlayerState = playerState;
		levelState = LevelState.RUNNING;

		try {
			File fileReader = new File("SavedData/MapData.txt");
			Scanner mapReader = null;
			mapReader = new Scanner(fileReader);
			currentCoins = mapReader.nextInt();
			totalCoins = mapReader.nextInt();

			setCoins(totalCoins);


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		moveAmountX = 0;
		moveAmountY = 0;

		// Check if player is hurt and needs to be knocked back, if so perform knockback
		if (knockbackAmount != 0) {
			justHurt = true;
			currentAnimationName = facingDirection == Direction.RIGHT ? "JUMP_RIGHT" : "JUMP_LEFT";
			if (knockLeft == true) {
				moveAmountX = -7;
				knockbackAmount -= 10;
				if (knockMaxHeight != 0) {
					moveAmountY = -7;
					knockMaxHeight -= 10;
				} else {
					moveAmountY = 7;
				}
			} else if (knockRight == true) {
				moveAmountX = 7;
				knockbackAmount -= 10;
				if (knockMaxHeight != 0) {
					moveAmountY = -7;
					knockMaxHeight -= 10;
				} else {
					moveAmountY = 7;
				}
			}

		} else if (knockbackAmount == 0) {
			justHurt = false;
			knockLeft = false;
			knockRight = true;
		}

		// if player is currently playing through level (has not won or lost)
		if (levelState == LevelState.RUNNING) {
			try {
				mapWriter = new FileWriter("SavedData/MapData.txt");
				mapWriter.write("" + currentCoins);
				mapWriter.write("\n" + totalCoins);
				mapWriter.close();


			} catch (IOException e) {
				e.printStackTrace();
			}
			applyGravity();

			// update player's state and current actions, which includes things like
			// determining how much it should move each frame and if its walking or jumping
			do {
				previousPlayerState = playerState;
				handlePlayerState();
			} while (previousPlayerState != playerState);

			previousAirGroundState = airGroundState;

			// update player's animation
			super.update();

			// move player with respect to map collisions based on how much player needs to
			// move this frame
			super.moveYHandleCollision(moveAmountY);
			super.moveXHandleCollision(moveAmountX);

			updateLockedKeys();
		}

		// if player has beaten level
		else if (levelState == LevelState.LEVEL_COMPLETED) {
			audio.startPlayingOnce(1);
			updateLevelCompleted();

			try {
				mapWriter = new FileWriter("SavedData/MapData.txt");
				mapWriter.write("" + (currentCoins));
				mapWriter.write("\n" + (currentCoins));
				mapWriter.close();

			} catch (IOException e) {
				e.printStackTrace();
			}



		}

		// if player has lost level
		else if (levelState == LevelState.PLAYER_DEAD) {
			audio.startPlayingOnce(2);
			updatePlayerDead();
		}

		}



	// add gravity to player, which is a downward force
	protected void applyGravity() {
		moveAmountY += gravity + momentumY;
	}

	// based on player's current state, call appropriate player state handling
	// method
	protected void handlePlayerState() {
		switch (playerState) {
		case STANDING:
			playerStanding();
			break;
		case WALKING:
			playerWalking();
			break;
		case CROUCHING:
			playerCrouching();
			break;
		case JUMPING:
			playerJumping();
			break;
		}
	}

	// player STANDING state logic
	protected void playerStanding() {
		// sets animation to a STAND animation based on which way player is facing
		currentAnimationName = facingDirection == Direction.RIGHT ? "STAND_RIGHT" : "STAND_LEFT";

		// if walk left or walk right key is pressed, player enters WALKING state
		if (Keyboard.isKeyDown(MOVE_LEFT_KEY) || Keyboard.isKeyDown(MOVE_RIGHT_KEY)) {
			playerState = PlayerState.WALKING;
		}

		// if jump key is pressed, player enters JUMPING state
		else if (Keyboard.isKeyDown(JUMP_KEY) && !keyLocker.isKeyLocked(JUMP_KEY)) {
			keyLocker.lockKey(JUMP_KEY);
			playerState = PlayerState.JUMPING;
		}

		// if crouch key is pressed, player enters CROUCHING state
		else if (Keyboard.isKeyDown(CROUCH_KEY)) {
			playerState = PlayerState.CROUCHING;
		}
	}

	// player WALKING state logic
	protected void playerWalking() {
		// sets animation to a WALK animation based on which way player is facing
		currentAnimationName = facingDirection == Direction.RIGHT ? "WALK_RIGHT" : "WALK_LEFT";

		// if walk left key is pressed, move player to the left
		if (Keyboard.isKeyDown(MOVE_LEFT_KEY)) {
			moveAmountX -= walkSpeed;
			facingDirection = Direction.LEFT;
		}

		// if walk right key is pressed, move player to the right
		else if (Keyboard.isKeyDown(MOVE_RIGHT_KEY)) {
			moveAmountX += walkSpeed;
			facingDirection = Direction.RIGHT;
		} else if (Keyboard.isKeyUp(MOVE_LEFT_KEY) && Keyboard.isKeyUp(MOVE_RIGHT_KEY)) {
			playerState = PlayerState.STANDING;
		}

		// if jump key is pressed, player enters JUMPING state
		if (Keyboard.isKeyDown(JUMP_KEY) && !keyLocker.isKeyLocked(JUMP_KEY)) {
			keyLocker.lockKey(JUMP_KEY);
			playerState = PlayerState.JUMPING;
		}

		// if crouch key is pressed,
		else if (Keyboard.isKeyDown(CROUCH_KEY)) {
			playerState = PlayerState.CROUCHING;
		}
	}

	// player CROUCHING state logic
	protected void playerCrouching() {
		// sets animation to a CROUCH animation based on which way player is facing
		currentAnimationName = facingDirection == Direction.RIGHT ? "CROUCH_RIGHT" : "CROUCH_LEFT";

		// if crouch key is released, player enters STANDING state
		if (Keyboard.isKeyUp(CROUCH_KEY)) {
			playerState = PlayerState.STANDING;
		}

		// if jump key is pressed, player enters JUMPING state
		if (Keyboard.isKeyDown(JUMP_KEY) && !keyLocker.isKeyLocked(JUMP_KEY)) {
			keyLocker.lockKey(JUMP_KEY);
			playerState = PlayerState.JUMPING;
		}
	}

	// player JUMPING state logic
	protected void playerJumping() {
		// if last frame player was on ground and this frame player is still on ground,
		// the jump needs to be setup
		if (previousAirGroundState == AirGroundState.GROUND && airGroundState == AirGroundState.GROUND) {
			audio.startPlayingOnce(3);
			// sets animation to a JUMP animation based on which way player is facing
			currentAnimationName = facingDirection == Direction.RIGHT ? "JUMP_RIGHT" : "JUMP_LEFT";

			// player is set to be in air and then player is sent into the air
			airGroundState = AirGroundState.AIR;
			jumpForce = jumpHeight;
			if (jumpForce > 0) {
				moveAmountY -= jumpForce;
				jumpForce -= jumpDegrade;
				if (jumpForce < 0) {
					jumpForce = 0;
				}
			}
		}

		// if player is in air (currently in a jump) and has more jumpForce, continue
		// sending player upwards
		else if (airGroundState == AirGroundState.AIR) {
			if (jumpForce > 0) {
				moveAmountY -= jumpForce;
				jumpForce -= jumpDegrade;
				if (jumpForce < 0) {
					jumpForce = 0;
				}
			}

			// if player is moving upwards, set player's animation to jump. if player moving
			// downwards, set player's animation to fall
			if (previousY > Math.round(y)) {
				currentAnimationName = facingDirection == Direction.RIGHT ? "JUMP_RIGHT" : "JUMP_LEFT";
			} else {
				currentAnimationName = facingDirection == Direction.RIGHT ? "FALL_RIGHT" : "FALL_LEFT";
			}

			// allows you to move left and right while in the air
			if (Keyboard.isKeyDown(MOVE_LEFT_KEY)) {
				moveAmountX -= walkSpeed;
			} else if (Keyboard.isKeyDown(MOVE_RIGHT_KEY)) {
				moveAmountX += walkSpeed;
			}

			// if player is falling, increases momentum as player falls so it falls faster
			// over time
			if (moveAmountY > 0) {
				increaseMomentum();
			}
		}

		// if player last frame was in air and this frame is now on ground, player
		// enters STANDING state
		else if (previousAirGroundState == AirGroundState.AIR && airGroundState == AirGroundState.GROUND) {
			playerState = PlayerState.STANDING;
		}
	}

	// while player is in air, this is called, and will increase momentumY by a set
	// amount until player reaches terminal velocity
	protected void increaseMomentum() {
		momentumY += momentumYIncrease;
		if (momentumY > terminalVelocityY) {
			momentumY = terminalVelocityY;
		}
	}

	protected void updateLockedKeys() {
		if (Keyboard.isKeyUp(JUMP_KEY)) {
			keyLocker.unlockKey(JUMP_KEY);
		}
	}

	@Override
	public void onEndCollisionCheckX(boolean hasCollided, Direction direction) {
		if (hasCollided) {
			if (MapTileCollisionHandler.getCollidedXTile() == null) {
				return;
			} else if (MapTileCollisionHandler.getCollidedXTile().tileType == TileType.CACTUS) {
				decreaseHealth();
			}
		}
	}

	@Override
	public void onEndCollisionCheckY(boolean hasCollided, Direction direction) {
		// if player collides with a map tile below it, it is now on the ground
		// if player does not collide with a map tile below, it is in air
		if (direction == Direction.DOWN) {
			if (hasCollided) {
				momentumY = 0;
				airGroundState = AirGroundState.GROUND;
			} else {
				playerState = PlayerState.JUMPING;
				airGroundState = AirGroundState.AIR;
			}
		}

		// if player collides with map tile upwards, it means it was jumping and then
		// hit into a ceiling -- immediately stop upwards jump velocity
		else if (direction == Direction.UP) {
			if (hasCollided) {
				jumpForce = 0;
			}
		}
	}
	
	// Mainly used to hurt player if comes in contact with sides of cacti
	public void decreaseHealth() {
	    currentHealth = getCurrentHealth() - 1;
	    if (MapTileCollisionHandler.getCollidedXTile().getX2() <= this.getX()) {
    		knockRight = true;
			justHurt = true;
			momentumY = 0;
			knockbackAmount = 100;
			knockMaxHeight = 50;
    	} else if (MapTileCollisionHandler.getCollidedXTile().getX2() > this.getX()) {
    		knockLeft = true;
			justHurt = true;
			momentumY = 0;
			knockbackAmount = 100;
			knockMaxHeight = 50;
    	}
	    if (getCurrentHealth() <= 0) {
	        currentHealth = 0;
	        levelState = LevelState.PLAYER_DEAD;
	    } else {
	        currentAnimationName = "HURT";
	    }
	}
	

	// other entities can call this method to hurt the player
	public void hurtPlayer(MapEntity mapEntity) {

		if (!isInvincible && mapEntity.isActive) {
			// if map entity is an enemy, hurt player on touch and initiate knock back.
			if (justHurt == true) {
				return;
			} else if ((mapEntity instanceof Enemy && currentHealth > 0) && !currentAnimationName.startsWith("HURT")) {
				currentHealth = getCurrentHealth() - 1;
				if (getCurrentHealth() <= 0) {
					currentHealth = 0;
					levelState = LevelState.PLAYER_DEAD;
				} else {
					currentAnimationName = "HURT";
					knockBack(mapEntity);
				}
			} else if (mapEntity instanceof Enemy) {
				currentHealth = getCurrentHealth() - 1;
				if (getCurrentHealth() <= 0) {
					currentHealth = 0;
					levelState = LevelState.PLAYER_DEAD;
				} else {
					currentAnimationName = "HURT";
					knockBack(mapEntity);
				}
			}
		}
	}

	public void knockBack(MapEntity mapEntity) {
		if ((mapEntity instanceof Enemy) && (this.getX() > mapEntity.getX())) {
			knockRight = true;
			justHurt = true;
			momentumY = 0;
			knockbackAmount = 100;
			knockMaxHeight = 50;
		} else if ((mapEntity instanceof Enemy) && (mapEntity.getX() > this.getX())) {
			knockLeft = true;
			justHurt = true;
			momentumY = 0;
			knockbackAmount = 100;
			knockMaxHeight = 50;
		}
	}

	// other entities can call this to tell the player they beat a level
	public void completeLevel() {
		levelState = LevelState.LEVEL_COMPLETED;
	}

	// if player has beaten level, this will be the update cycle
	public void updateLevelCompleted() {
		// if player is not on ground, player should fall until it touches the ground
		if (airGroundState != AirGroundState.GROUND && map.getCamera().containsDraw(this)) {
			currentAnimationName = "FALL_RIGHT";
			applyGravity();
			increaseMomentum();
			super.update();
			moveYHandleCollision(moveAmountY);
			audio.stopPlaying(0);
			audio.startPlayingOnce(1);

		}
		// move player to the right until it walks off screen
		else if (map.getCamera().containsDraw(this)) {
			currentAnimationName = "WALK_RIGHT";
			super.update();
			moveXHandleCollision(walkSpeed);
		} else {
			// tell all player listeners that the player has finished the level
			for (PlayerListener listener : listeners) {
				listener.onLevelCompleted();
			}
		}
	}

	// if player has died, this will be the update cycle
	public void updatePlayerDead() {
		// change player animation to DEATH
		audio.stopPlaying(0);
		// Insert death sound here
		if (!currentAnimationName.startsWith("DEATH")) {
			if (facingDirection == Direction.RIGHT) {
				currentAnimationName = "DEATH_RIGHT";
			} else {
				currentAnimationName = "DEATH_LEFT";
			}
			super.update();
		}
		// if death animation not on last frame yet, continue to play out death
		// animation
		else if (currentFrameIndex != getCurrentAnimation().length - 1) {
			super.update();
		}
		// if death animation on last frame (it is set up not to loop back to start),
		// player should continually fall until it goes off screen
		else if (currentFrameIndex == getCurrentAnimation().length - 1) {
			if (map.getCamera().containsDraw(this)) {
				moveY(3);
			} else {
				// tell all player listeners that the player has died in the level
				for (PlayerListener listener : listeners) {
					listener.onDeath();
				}
			}
		}
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		if (currentHealth > 0 && currentHealth < 10) {
			this.currentHealth = currentHealth;
		}

	}

	public int getCoins() {
		return currentCoins;
	}

	public void setCoins(int coins) {
		currentCoins = coins;

	}

	public PlayerState getPlayerState() {
		return playerState;
	}

	public void setPlayerState(PlayerState playerState) {
		this.playerState = playerState;
	}

	public AirGroundState getAirGroundState() {
		return airGroundState;
	}

	public Direction getFacingDirection() {
		return facingDirection;
	}

	public void setFacingDirection(Direction facingDirection) {
		this.facingDirection = facingDirection;
	}

	public void setLevelState(LevelState levelState) {
		this.levelState = levelState;
	}

	public LevelState getLevelState() {
		return levelState;
	}

	public void addListener(PlayerListener listener) {
		listeners.add(listener);
	}

	public void drownPlayer() {
		if (!isInvincible) {
			// if map entity is an enemy, kill player on touch
			currentHealth = 0;
			levelState = LevelState.PLAYER_DEAD;
		} else {
			return;
		}
	}


}