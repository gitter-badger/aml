package es.us.isa.aml.model.csp;

import es.us.isa.aml.model.QualifyingCondition;
import es.us.isa.aml.model.SLO;

/**
 * @author jdelafuente
 *
 */
public class CSPConstraint implements Comparable<CSPConstraint> {

	protected String id;
	protected SLO slo;
	protected QualifyingCondition qc;

    public CSPConstraint(String id, SLO slo) {
        this.id = id;
        this.slo = slo;
        qc = null;
    }

    public CSPConstraint(String id, SLO slo, QualifyingCondition qc) {
        this.id = id;
        this.slo = slo;
        this.qc = qc;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SLO getSlo() {
        return this.slo;
    }

    public void setSlo(SLO slo) {
        this.slo = slo;
    }

    public QualifyingCondition getQc() {
        return qc;
    }

    public void setQc(QualifyingCondition qc) {
        this.qc = qc;
    }

    @Override
    public int compareTo(CSPConstraint o) {
        return getId().compareTo(o.getId());
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
