package es.us.isa.aml.translator.builders.opl.model;

import es.us.isa.aml.model.QualifyingCondition;
import es.us.isa.aml.model.SLO;
import es.us.isa.aml.model.csp.CSPConstraint;

/**
 * @author jdelafuente
 *
 */
public class OPLConstraint extends CSPConstraint {

    /**
	 * @param id
	 * @param slo
	 */
	public OPLConstraint(String id, SLO slo) {
		super(id, slo);
	}

	/**
	 * @param id
	 * @param slo
	 * @param qc
	 */
	public OPLConstraint(String id, SLO slo, QualifyingCondition qc) {
		super(id, slo, qc);
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (getQc() != null) {
            sb.append(getQc().getCondition().toString()).append(" => ");
        }

        String exp = this.getSlo().getExpression().toString();
        exp = exp.replace("AND", "&&");
        exp = exp.replace("OR", "||");

        sb.append(exp);

        return this.getId() + ": " + sb.toString() + ";";
    }
}
