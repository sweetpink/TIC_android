package com.example.henrik.facebook_test_rightversion;

/**
 * Created by Nicklas on 2016-03-20.
 */
public class Move {
    String characterName;
    String command;
    String hitLevel;
    String damage;
    String startUpFrame;
    String blockFrame;
    String displayBlockFrame;
    String hitFrame;
    String counterHitFrame;
    String primaryAttr;

    public Move(String characterName, String command, String hitLevel, String damage, String startUpFrame, String blockFrame, String displayBlockFrame, String hitFrame, String counterHitFrame, String primaryAttr) {
        this.characterName = characterName;
        this.command = command;
        this.hitLevel = hitLevel;
        this.damage = damage;
        this.startUpFrame = startUpFrame;
        this.blockFrame = blockFrame;
        this.displayBlockFrame = displayBlockFrame;
        this.hitFrame = hitFrame;
        this.counterHitFrame = counterHitFrame;
        this.primaryAttr = primaryAttr;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getHitLevel() {
        return hitLevel;
    }

    public void setHitLevel(String hitLevel) {
        this.hitLevel = hitLevel;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getStartUpFrame() {
        return startUpFrame;
    }

    public void setStartUpFrame(String startUpFrame) {
        this.startUpFrame = startUpFrame;
    }

    public String getBlockFrame() {
        return blockFrame;
    }

    public void setBlockFrame(String blockFrame) {
        this.blockFrame = blockFrame;
    }

    public String getDisplayBlockFrame() {
        return displayBlockFrame;
    }

    public void setDisplayBlockFrame(String displayBlockFrame) {
        this.displayBlockFrame = displayBlockFrame;
    }

    public String getHitFrame() {
        return hitFrame;
    }

    public void setHitFrame(String hitFrame) {
        this.hitFrame = hitFrame;
    }

    public String getCounterHitFrame() {
        return counterHitFrame;
    }

    public void setCounterHitFrame(String counterHitFrame) {
        this.counterHitFrame = counterHitFrame;
    }

    public String getPrimaryAttr() {
        return primaryAttr;
    }

    public void setPrimaryAttr(String primaryAttr) {
        this.primaryAttr = primaryAttr;
    }
}
