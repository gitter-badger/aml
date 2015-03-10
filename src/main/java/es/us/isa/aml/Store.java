/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.model.AgreementOffer;
import es.us.isa.aml.model.AgreementTemplate;
import es.us.isa.aml.parsers.agreements.AgreementParser;
import es.us.isa.aml.util.AgreementLanguage;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.ParserFactory;
import es.us.isa.aml.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author AntonioGamez
 */
public class Store {

    private static Store instance = null;
    private final Map<String, AgreementModel> agreementModelMap;

    protected Store() {
        agreementModelMap = new HashMap<>();
    }

    public static Store getInstance() {
        if (instance == null) {
            instance = new Store();
        }
        return instance;
    }

    protected static Store getInstance(String json) {
        if (instance == null) {
            instance = new Store();
        }
        return instance;
    }

    //main methods
    //creation
    public AgreementOffer createAgreementOffer(String content, AgreementLanguage lang, AgreementManager manager) {
        AgreementOffer offer = new AgreementOffer();
        offer.loadFromFile(content, lang);
        offer.setAgreementManager(manager);
        return offer;
    }

    public AgreementTemplate createAgreementTemplate(String content, AgreementLanguage lang, AgreementManager manager) {
        AgreementTemplate template = new AgreementTemplate();
        template.loadFromFile(content, lang);
        template.setAgreementManager(manager);
        return template;
    }

    // Registration
    public void registerFromFile(String path) {
        register(parseAgreementFile(Util.loadFile(path)));
    }

    public void register(AgreementModel model) {
        register(model.getID(), model);
    }

    public void register(String name, AgreementModel model) {
        agreementModelMap.put(name, model);
    }

    // Retrieve
    public AgreementTemplate getAgreementTemplate(String name) {
        return (AgreementTemplate) agreementModelMap.get(name);
    }

    public AgreementOffer getAgreementOffer(String name) {
        return (AgreementOffer) agreementModelMap.get(name);
    }

    // Parsing
    public AgreementModel parseAgreementFile(String content) {
        AgreementLanguage lang = AgreementLanguage.valueOf(Config.getProperty("defaultInputFormat"));
        AgreementParser parser = ParserFactory.createParser(lang);
        return parser.doParse(content);
    }

    public AgreementModel parseAgreementFile(String content, AgreementLanguage lang) {
        AgreementParser parser = ParserFactory.createParser(lang);
        return parser.doParse(content);
    }

    //other methods
    public Map<String, AgreementModel> getAgreementMap() {
        return Collections.unmodifiableMap(this.agreementModelMap);
    }
    
    public void removeAgreement(String name) {
        agreementModelMap.remove(name);
    }

}
