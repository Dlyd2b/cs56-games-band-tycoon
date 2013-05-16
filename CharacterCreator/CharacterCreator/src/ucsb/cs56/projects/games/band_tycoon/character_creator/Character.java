package ucsb.cs56.projects.games.band_tycoon.character_creator;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.esotericsoftware.spine.Animation;
import com.esotericsoftware.spine.Bone;
import com.esotericsoftware.spine.Skeleton;
import com.esotericsoftware.spine.SkeletonData;
import com.esotericsoftware.spine.SkeletonJson;
import com.esotericsoftware.spine.Slot;

public class Character extends Actor {
	public static final int MALE=0;
	public static final int FEMALE=1;
	public static final int VOCALS=10;
	public static final int GUITAR=11;
	public static final int BASS=12;
	public static final int DRUMS=13;
	public static final int KEYBOARD=14;
	public static final int VIOLIN=15;
	public static final int RHYTHMGUITAR=16;
	public static final int UNKNOWN_INSTRUMENT = 17;

	String name;
	int gender=0;
	int instrument=UNKNOWN_INSTRUMENT;
	float vocalSkill = 0;
	float guitarSkill = 0;
	float bassSkill = 0;
	float drumSkill = 0;
	float keyboardSkill = 0;
	float violinSkill = 0;
	float rhythmGuitarSkill=0;
	
	int x = 0,y = 0; //Position
	float time;

	SkeletonData skeletonData;
	Skeleton skeleton;
	Animation anim;
	Animation jumpAnimation;
	Bone root;
	float totalTime = 0f;
		
	Random random;
	
	public Character(String name){
		super();
		this.name = name;
		random = new Random();
		create();
	}

	public Character(String name, int gender){
		this(name);
		this.gender = gender;
	}	
	
	/**
	 * Sets the character's position and determines whether they are flipped horizontally
	 * @param x	X-position
	 * @param y	Y-positon
	 * @param flip Boolean for flipped
	 */
	public void setPos(int x, int y, boolean flip){
		this.x = x;
		this.y = y;
		skeleton.setFlipX(flip);
	}
	
	public void changeAttachmentsSuzie(){
		skeleton.findSlot("hairFront").getColor().set(.1f,.35f,.35f,1);
		skeleton.findSlot("hairBack").getColor().set(.1f,.35f,.35f,1);
		skeleton.setAttachment("head", "head_F3");
		skeleton.setAttachment("hairFront", "hairFront_F3Mono");
		skeleton.setAttachment("hairBack", "hairBack_F3Mono");
		//skeleton.setAttachment("hairFront", "hairFront_F1Blonde");
		skeleton.setAttachment("hairSide", null);
		//skeleton.setAttachment("hairBack", "hairBack_F1Blonde");
		skeleton.setAttachment("torso", "torso_F1Black");
		skeleton.setAttachment("torsoBack", "torsoBack_U1Black");
		skeleton.setAttachment("leftUpperArm", "leftUpperArm_U1Black");
		skeleton.setAttachment("rightUpperArm", "rightUpperArm_U1Black");
		skeleton.setAttachment("mouth", "mouth_Happy");
		skeleton.setAttachment("eyes", "eyes_Calvin");
	}
	
	public void changeAttachmentsSunny(){
		skeleton.setAttachment("hairFront", "hairFront_F2Red");
		skeleton.setAttachment("hairSide", null);
		skeleton.setAttachment("hairBack", "hairBack_F2Red");
		skeleton.setAttachment("torso", "torso_F2");
		skeleton.setAttachment("torsoBack", "torsoBack_U1Black");
		skeleton.setAttachment("leftUpperArm", "leftUpperArm_U2");
		skeleton.setAttachment("rightUpperArm", "rightUpperArm_F2");
		skeleton.setAttachment("mouth", "mouth_Happy");
		skeleton.setAttachment("eyes", "eyes_Animeish");
		skeleton.setAttachment("leftFoot", "leftFoot_U2Brown");
		skeleton.setAttachment("rightFoot", "rightFoot_U2Brown");
		skeleton.setAttachment("pelvis", "pelvis_U2");
		skeleton.setAttachment("head", "head_F2");
	}
	
	public void changeAttachmentsJoe(){
		skeleton.setAttachment("hairFront", "hairFront_M1Black");
		skeleton.setAttachment("hairSide", null);
		skeleton.setAttachment("hairBack", null);
		skeleton.setAttachment("torso", "torso_M3");
		skeleton.setAttachment("torsoBack", "torsoBack_U1Black");
		skeleton.setAttachment("leftUpperArm", "leftUpperArm_U3");
		skeleton.setAttachment("rightUpperArm", "rightUpperArm_U3");
		skeleton.setAttachment("leftForearm", "leftForearm_U2");
		skeleton.setAttachment("rightForearm", "rightForearm_U2");
		skeleton.setAttachment("mouth", "mouth_Teardrop");
		skeleton.setAttachment("eyes", "eyes_Plain");
		skeleton.setAttachment("leftFoot", "leftFoot_U2Black");
		skeleton.setAttachment("rightFoot", "rightFoot_U2Black");
		skeleton.setAttachment("pelvis", "pelvis_U3");
		skeleton.setAttachment("leftLowerLeg", "leftLowerLeg_U2");
		skeleton.setAttachment("rightLowerLeg", "rightLowerLeg_U2");
		skeleton.setAttachment("leftUpperLeg", "leftUpperLeg_U2");
		skeleton.setAttachment("rightUpperLeg", "rightUpperLeg_U2");
		skeleton.setAttachment("head", "head_M1");
		
	}
	
	public void switchToDrums(){
		anim = skeletonData.findAnimation("Drums");
		skeleton.setAttachment("bassDrum", "bassDrum");
		skeleton.setAttachment("cymbalStandKnob", "cymbalStandKnob");
		skeleton.setAttachment("cymbalSmallStand", "cymbalSmallStand");
		skeleton.setAttachment("cymbalSmallStandKnob", "cymbalSmallStandKnob");
		skeleton.setAttachment("cymbalStand", "cymbalStand");
		skeleton.setAttachment("floorTomTom", "floorTomTom");
		skeleton.setAttachment("hiHatCymbal", "hiHatCymbal");
		skeleton.setAttachment("snareDrum", "snareDrum");
		skeleton.setAttachment("cymbal", "cymbal");
		skeleton.setAttachment("hiHatCymbalTop", "hiHatCymbalTop");
		skeleton.setAttachment("cymbalSmall", "cymbalSmall");
		skeleton.setAttachment("leftFingers", "leftFingers_U2Drums");
		skeleton.setAttachment("leftPalm", "leftPalm_U2Drums");
		skeleton.setAttachment("rightObject", "rightDrumstick_U1");
		skeleton.setAttachment("leftObject", "leftDrumstick_U1");
		skeleton.setAttachment("guitar", null);
		skeleton.setAttachment("micStand", null);
		skeleton.setAttachment("mic", null);
	}
		
	public void switchToGuitar(){
		anim = skeletonData.findAnimation("Guitar");
		skeleton.setAttachment("bassDrum", null);
		skeleton.setAttachment("cymbalStandKnob", null);
		skeleton.setAttachment("cymbalSmallStand", null);
		skeleton.setAttachment("cymbalSmallStandKnob", null);
		skeleton.setAttachment("cymbalStand", null);
		skeleton.setAttachment("floorTomTom", null);
		skeleton.setAttachment("hiHatCymbal", null);
		skeleton.setAttachment("snareDrum", null);
		skeleton.setAttachment("cymbal", null);
		skeleton.setAttachment("hiHatCymbalTop", null);
		skeleton.setAttachment("cymbalSmall", null);
		skeleton.setAttachment("leftFingers", "leftFingers_U1");
		skeleton.setAttachment("leftPalm", "leftPalm_U1");
		skeleton.setAttachment("rightObject", null);
		skeleton.setAttachment("leftObject", null);
		skeleton.setAttachment("guitar", "guitar");
		skeleton.setAttachment("micStand", null);
		skeleton.setAttachment("mic", null);
	}
	
	public void switchToBass(){
		anim = skeletonData.findAnimation("Bass");
		skeleton.setAttachment("bassDrum", null);
		skeleton.setAttachment("cymbalStandKnob", null);
		skeleton.setAttachment("cymbalSmallStand", null);
		skeleton.setAttachment("cymbalSmallStandKnob", null);
		skeleton.setAttachment("cymbalStand", null);
		skeleton.setAttachment("floorTomTom", null);
		skeleton.setAttachment("hiHatCymbal", null);
		skeleton.setAttachment("snareDrum", null);
		skeleton.setAttachment("cymbal", null);
		skeleton.setAttachment("hiHatCymbalTop", null);
		skeleton.setAttachment("cymbalSmall", null);
		skeleton.setAttachment("leftFingers", "leftFingers_U1");
		skeleton.setAttachment("leftPalm", "leftPalm_U1");
		skeleton.setAttachment("rightObject", null);
		skeleton.setAttachment("leftObject", null);
		skeleton.setAttachment("guitar", "guitar");
		skeleton.setAttachment("micStand", null);
		skeleton.setAttachment("mic", null);
	}
	
	public void switchToVocals(){
		anim = skeletonData.findAnimation("Vocals");
		skeleton.setAttachment("bassDrum", null);
		skeleton.setAttachment("cymbalStandKnob", null);
		skeleton.setAttachment("cymbalSmallStand", null);
		skeleton.setAttachment("cymbalSmallStandKnob", null);
		skeleton.setAttachment("cymbalStand", null);
		skeleton.setAttachment("floorTomTom", null);
		skeleton.setAttachment("hiHatCymbal", null);
		skeleton.setAttachment("snareDrum", null);
		skeleton.setAttachment("cymbal", null);
		skeleton.setAttachment("hiHatCymbalTop", null);
		skeleton.setAttachment("cymbalSmall", null);
		skeleton.setAttachment("leftFingers", "leftFingers_U1");
		skeleton.setAttachment("leftPalm", "leftPalm_U1");
		skeleton.setAttachment("rightObject", null);
		skeleton.setAttachment("leftObject", null);
		skeleton.setAttachment("guitar", null);
		skeleton.setAttachment("micStand", "micStand");
		skeleton.setAttachment("mic", "mic");
	}
	
	public void create(){	
		final String name = "data/characters/guitar-female";

        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(name + ".atlas"));
        
		SkeletonJson json = new SkeletonJson(atlas);
		skeletonData = json.readSkeletonData(Gdx.files.internal(name + ".json"));
		
        anim = skeletonData.findAnimation("Guitar");

        skeleton = new Skeleton(skeletonData);
        skeleton.setToBindPose();
        root = skeleton.getRootBone();
	}
	
	@Override
	public void act(float delta){
		super.act(delta);
		
        totalTime += delta;
        
        anim.apply(skeleton, totalTime, true);
        
        root.setX(root.getX() + x);
        root.setY(root.getY() + y);
        root.setScaleX(.6f);
        root.setScaleY(.6f);
        
        skeleton.updateWorldTransform(); 
		
		skeleton.update(delta);
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha){
		super.draw(batch, parentAlpha); 
        skeleton.draw(batch);
	}
	
	
	
	/**
	 * 
	 * @return Integer representing character's instrument. ex.) Character.GUITAR
	 */
	public int getInstrument(){
		return this.instrument;
	}
	
	/**
	 * Set gender for this character.
	 * @param g 0 for male, 1 for female. Can use Character.MALE and Character.FEMALE for clarity.
	 */
	public void setGender(int g){
		this.gender = g;
	}

	/**
	 * Sets the intial instrument of the character
	 * @param instrument Integer representing instrument. Use Character.VOCAL, Character.GUITAR, etc.
	 */
	public void setInstrument(int instrument){
		switch (instrument){
			case VOCALS:
				this.instrument=VOCALS; this.vocalSkill = 10; 
				switchToVocals();
				break;
			case GUITAR: 
				this.instrument=GUITAR; this.guitarSkill = 10;
				switchToGuitar();
				break;
			case BASS:
				this.instrument = BASS; this.bassSkill = 10; 
				switchToBass();
				break;
			case DRUMS:
				this.instrument = DRUMS; this.drumSkill = 10;
				switchToDrums();
				break;
			case KEYBOARD:
				this.instrument = KEYBOARD; this.keyboardSkill = 10; 
				break;
			case VIOLIN: 
				this.instrument = VIOLIN; this.violinSkill = 10; 
				break;
			case RHYTHMGUITAR: 
				this.instrument = RHYTHMGUITAR; this.rhythmGuitarSkill = 10;
				break;
			default: 
				this.instrument = UNKNOWN_INSTRUMENT;
		}
	}
	
	//=======================================================
	//The following are methods used to help generate strings.
	//=======================================================
	
	/**
	 * 
	 * @return Name of character
	 */
	public String name(){
		return name;
	}
	
	/**
	 * 
	 * @return Possessive form of name. ex: "John's", "Steve's", "Sally's", "Ellis's"
	 */
	public String possessive(){
		return name + "'s";
	}
	
	/**
	 * 
	 * @return Capital form of gender pronoun. ex: "She", "He"
	 */
	public String He(){
		if (gender == Character.MALE){
			return "He";
		}
		else{
			return "She";
		}
	}
	
	/**
	 * 
	 * @return Lowercase gender pronoun. ex: "she", "he"
	 */
	public String he(){
		if (gender == Character.MALE){
			return "he";
		}
		else{
			return "she";
		}
	}	
	
	/**
	 * 
	 * @return Capital gender possessive pronoun. ex: "His", "Her"
	 */
	public String His(){
		if (gender == Character.MALE){
			return "His";
		}
		else{
			return "Her";
		}
	}
	
	/**
	 * 
	 * @return Lowercase gender possessive pronoun. ex: "his", "her"
	 */
	public String his(){
		if (gender == Character.MALE){
			return "his";
		}
		else{
			return "her";
		}
	}
	
	/**
	 * 
	 * @return "guy" or "girl", depending on gender
	 */
	public String guy(){
		if (gender == Character.MALE){
			return "guy";
		}
		else{
			return "girl";
		}
	}
	
	/**
	 * 
	 * @return Instrument position as string. "vocalist", "guitarist", etc
	 */
	public String instrument(){
		String s;
		switch (instrument){
			case (VOCALS):
				s= "vocalist"; break;
			case (GUITAR):
				s= "guitarist"; break;
			case (BASS):
				s= "bassist"; break;
			case (DRUMS):
				s= "drummer"; break;
			case (KEYBOARD):
				s= "keyboardist"; break;
			case (VIOLIN):
				s= "violinist"; break;
			case (RHYTHMGUITAR):
				s="rhythm guitarist"; break;
			default:
				s= "nobody"; break;
		}
		return s;
	}
}
