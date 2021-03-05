import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	// Player is always first
	LinkedList<Sprite> loadedSprites = new LinkedList<>();
	LinkedList<Object> loadedObjects = new LinkedList<>();

	// Update every Sprite and Object
	// checkForComodification potential error, list can't be modified during this loop
	public void tick() {
		LinkedList<Object> oCopy = loadedObjects;
		for (Object tempObject : oCopy) {
			tempObject.tick();
		}
		LinkedList<Sprite> sCopy = loadedSprites;
		for (Sprite tempSprite : sCopy) {
			tempSprite.tick();
		}
	}

	// Render every Entity and Object to the screen
	// Player is the first Sprite rendered
	// TODO: Concurrent Modification
	public void render(Graphics g) {
		LinkedList<Object> oCopy = loadedObjects;
		for (Object tempObject : oCopy) {
			tempObject.render(g);
		}
		LinkedList<Sprite> sCopy = loadedSprites;
		for (Sprite tempSprite : sCopy) {
			tempSprite.render(g);
		}
	}
	
	public boolean playerLoaded() {
		return !loadedSprites.isEmpty() && loadedSprites.getLast().id == SpriteID.Player;
	}
	
	public Sprite getPlayer() {
		return (playerLoaded()) ? loadedSprites.getLast() : null;
	}

	public void addSprite(Sprite sprite) {
		if (sprite.id == SpriteID.Player) {
			this.loadedSprites.addLast(sprite);
		} else {
			this.loadedSprites.addFirst(sprite);
		}
	}

	public void removeSprite(Sprite sprite) {
		this.loadedSprites.remove(sprite);
	}
	
	public void addObject(Object object) {
		this.loadedObjects.add(object);
	}

	public void removeObject(Object object) {
		this.loadedObjects.remove(object);
	}

}
