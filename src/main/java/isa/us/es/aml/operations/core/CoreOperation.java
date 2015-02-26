/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isa.us.es.aml.operations.core;

import isa.us.es.aml.operations.Operation;
import isa.us.es.aml.operations.reasoners.Reasoner;
import isa.us.es.aml.translators.csp.CoreTranslator;
import isa.us.es.aml.util.CoreOperationType;



/**
 *
 * @author AntonioGamez
 */
public abstract class CoreOperation implements Operation {

    private Reasoner reasoner;
    private CoreTranslator coreTranslator;
    private CoreOperationType type;

    public CoreTranslator getCoreTranslator() {
        return coreTranslator;
    }

    public void setCoreTranslator(CoreTranslator coreTranslator) {
        this.coreTranslator = coreTranslator;
    }

    public Reasoner getReasoner() {
        return reasoner;
    }

    public void setReasoner(Reasoner reasoner) {
        this.reasoner = reasoner;
    }

    public CoreOperationType getType() {
        return type;
    }

    public void setType(CoreOperationType type) {
        this.type = type;
    }
    
    

}
