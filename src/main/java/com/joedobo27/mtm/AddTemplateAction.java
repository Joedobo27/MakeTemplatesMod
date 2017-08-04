package com.joedobo27.mtm;

import com.wurmonline.server.MiscConstants;
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.items.ItemTemplateFactory;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.BehaviourProvider;
import org.gotti.wurmunlimited.modsupport.actions.ModAction;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;


import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParserFactory;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddTemplateAction implements ModAction, ActionPerformer, BehaviourProvider{

    static short actionId;
    static ActionEntry actionEntry;

    AddTemplateAction(){
        actionId = (short) ModActions.getNextActionId();
        actionEntry = ActionEntry.createEntry(actionId, "new ItemTemplate", "", new int[]{});
        ModActions.registerAction(actionEntry);

    }

    @Override
    public short getActionId() {
        return actionId;
    }

    @Override
    public List<ActionEntry> getBehavioursFor(Creature performer, Item subject, Item target) {
        if (performer.getPower() < 5 || !subject.isWand())
            return null;
        return Collections.singletonList(actionEntry);
    }

    @Override
    public boolean action(final Action act, final Creature performer, final Item source, final Item target, final short action, final float counter) {
        if (actionId != action || performer.getPower() < 5 || !source.isWand())
            return false;
        new TemplateQuestion(
                performer, "Create Item Template", "Create Item Template", 600, source.getWurmId());
        return true;
    }

    static void doNewItemTemplate(String json) {
        int templateId = -1;
        int size = -1;
        String name = "";
        JsonParserFactory jpf = Json.createParserFactory(null);
        JsonParser jsonParser = jpf.createParser(new StringReader(json));
        String keyName;
        Integer coordValue;
        String plural  = "";
        String itemDescriptionSuperb = "";
        String itemDescriptionNormal = "";
        String itemDescriptionBad = "";
        String itemDescriptionRotten = "";
        String itemDescriptionLong = "";
        ArrayList<Short> itemTypes = new ArrayList<>();
        short imageNumber = 0;
        short behaviourType = 0;
        int combatDamage = 0;
        long decayTime = 0L;
        int centimetersX = 0;
        int centimetersY = 0;
        int centimetersZ = 0;
        int primarySkill = 0;
        byte[] bodySpaces = MiscConstants.EMPTY_BYTE_PRIMITIVE_ARRAY;
        String modelName = "";
        long difficulty = 0L;
        int weight = 0;
        byte material = 0;
        int value = 0;
        boolean isTraded = false;
        int armourType = -1;
        int dyeAmountOverrideGrams = 0;
        while (jsonParser.hasNext()) {
            JsonParser.Event event = jsonParser.next();
            if (event == JsonParser.Event.START_OBJECT || event == JsonParser.Event.END_OBJECT)
                continue;
            if (event != JsonParser.Event.KEY_NAME)
                break;
            keyName = jsonParser.getString();
            switch (keyName) {
                case "templateId":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_NUMBER)
                        break;
                    templateId = jsonParser.getInt();
                    break;
                case "size":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_NUMBER)
                        break;
                    size = jsonParser.getInt();
                    break;
                case "name":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_STRING)
                        break;
                    name = jsonParser.getString();
                    break;
                case "plural":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_STRING)
                        break;
                    plural = jsonParser.getString();
                    break;
                case "itemDescriptionSuperb":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_STRING)
                        break;
                    itemDescriptionSuperb = jsonParser.getString();
                    break;
                case "itemDescriptionNormal":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_STRING)
                        break;
                    itemDescriptionNormal = jsonParser.getString();
                    break;
                case "itemDescriptionBad":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_STRING)
                        break;
                    itemDescriptionBad = jsonParser.getString();
                    break;
                case "itemDescriptionRotten":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_STRING)
                        break;
                    itemDescriptionRotten = jsonParser.getString();
                    break;
                case "itemDescriptionLong":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_STRING)
                        break;
                    itemDescriptionLong = jsonParser.getString();
                    break;
                case "itemTypes":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.START_ARRAY)
                        break;
                    event = jsonParser.next();
                    while (event != JsonParser.Event.END_ARRAY) {
                        if (event != JsonParser.Event.VALUE_NUMBER)
                            break;
                        itemTypes.add((short)jsonParser.getInt());
                        event = jsonParser.next();
                    }
                    break;
                case "imageNumber":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_NUMBER)
                        break;
                    imageNumber = (short)jsonParser.getInt();
                    break;
                case "behaviourType":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_NUMBER)
                        break;
                    behaviourType = (short)jsonParser.getInt();
                    break;
                case "combatDamage":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_NUMBER)
                        break;
                    combatDamage = jsonParser.getInt();
                    break;
                case "decayTime":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_NUMBER)
                        break;
                    decayTime = jsonParser.getLong();
                    break;
                case "centimetersX":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_NUMBER)
                        break;
                    centimetersX = jsonParser.getInt();
                    break;
                case "centimetersY":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_NUMBER)
                        break;
                    centimetersY = jsonParser.getInt();
                    break;
                case "centimetersZ":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_NUMBER)
                        break;
                    centimetersZ = jsonParser.getInt();
                    break;
                case "primarySkill":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_NUMBER)
                        break;
                    primarySkill = jsonParser.getInt();
                    break;
                case "bodySpaces":
                    event = jsonParser.next();
                    break;
                case "modelName":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_STRING)
                        break;
                    modelName = jsonParser.getString();
                    break;
                case "difficulty":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_NUMBER)
                        break;
                    difficulty = jsonParser.getLong();
                    break;
                case "weight":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_NUMBER)
                        break;
                    weight = jsonParser.getInt();
                    break;
                case "material":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_NUMBER)
                        break;
                    material = (byte)jsonParser.getInt();
                    break;
                case "value":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_NUMBER)
                        break;
                    value = jsonParser.getInt();
                    break;
                case "isTraded":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_STRING)
                        break;
                    isTraded = Boolean.parseBoolean(jsonParser.getString());
                    break;
                case "armourType":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_NUMBER)
                        break;
                    armourType = jsonParser.getInt();
                    break;
                case "dyeAmountOverrideGrams":
                    event = jsonParser.next();
                    if (event != JsonParser.Event.VALUE_NUMBER)
                        break;
                    dyeAmountOverrideGrams = jsonParser.getInt();
                    break;
            }
        }
        short[] shorts = new short[itemTypes.size()];
        for (int i=0; i<itemTypes.size();i++){
            shorts[i] = itemTypes.get(i);
        }
        try {
            ItemTemplateFactory.getInstance().createItemTemplate(templateId, size, name, plural, itemDescriptionSuperb, itemDescriptionNormal,
                    itemDescriptionBad, itemDescriptionRotten, itemDescriptionLong, shorts, imageNumber, behaviourType, combatDamage,
                    decayTime, centimetersX, centimetersY, centimetersZ, primarySkill, bodySpaces, modelName, difficulty, weight,
                    material, value, isTraded, armourType, dyeAmountOverrideGrams);
        }catch (IOException e) {
            MakeTemplatesMod.logger.warning(e.getMessage());
        }
    }
}
