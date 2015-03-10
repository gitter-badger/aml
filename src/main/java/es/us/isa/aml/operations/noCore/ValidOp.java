/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.aml.operations.noCore;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.operations.core.csp.ExistInconsistenciesOp;

/**
 *
 * @author AntonioGamez
 */
public class ValidOp extends NoCoreOperation {

    private final ExistInconsistenciesOp existsInconsistenciesOp;
    private final ExistDeadTermsOp existDeadTermsOp;

    public ValidOp() {
        this.existsInconsistenciesOp = new ExistInconsistenciesOp();
        this.existDeadTermsOp = new ExistDeadTermsOp();
    }

    public void analyze(AgreementModel model) {
        existsInconsistenciesOp.analyze(model);
        existDeadTermsOp.analyze(model);

    }

    @Override
    public Boolean getResult() {
        Boolean noInconsistencies = !(Boolean) existsInconsistenciesOp.getResult().getResponseObject(0);
        Boolean noDeadTerms = !existDeadTermsOp.getResult();
        return noInconsistencies && noDeadTerms;
    }

}
