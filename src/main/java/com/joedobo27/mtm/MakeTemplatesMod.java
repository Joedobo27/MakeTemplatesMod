package com.joedobo27.mtm;

import org.gotti.wurmunlimited.modloader.interfaces.PreInitable;
import org.gotti.wurmunlimited.modloader.interfaces.ServerStartedListener;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;

import java.util.logging.Logger;

public class MakeTemplatesMod implements WurmServerMod, PreInitable, ServerStartedListener{

    static final Logger logger = Logger.getLogger(MakeTemplatesMod.class.getName());

    @Override
    public void preInit() {
        ModActions.init();
    }

    @Override
    public void onServerStarted() {
        ModActions.registerAction(new AddTemplateAction());
    }
}
