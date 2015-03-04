/**
 *
 */
package test;

import isa.us.es.aml.model.expression.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jdelafuente
 *
 */
public class TestExpression {

    // Check assignment expressions
    @Test
    public void testAssignmentExpression() {

        Var a = new Var("a", new Atomic(2.0));
        assertEquals(2.0, a.getDoubleValue(), 0.0);

        Var b = new Var("b");
        Expression e = new AssignmentExpression(b, new Atomic(2));
        assertEquals(2, b.getIntegerValue().intValue());

        Var c = new Var("c", new Atomic(false));
        assertFalse(c.getBooleanValue());
    }

    // Check arithmetic expressions
    @Test
    public void testArithmeticExpression() {
        Var a = new Var("a", new Atomic(2));
        assertEquals(2.0, a.getDoubleValue(), 0.0);

        Var b = new Var("b", new ArithmeticExpression(a, new Atomic(1),
                ArithmeticOperator.add));
        assertEquals(3.0, b.getDoubleValue(), 0.0);

        Var c = new Var("c", new ArithmeticExpression(a, b,
                ArithmeticOperator.add));
        assertEquals(5.0, c.getDoubleValue(), 0.0);

        Expression e = new ArithmeticExpression(a, c, ArithmeticOperator.add);
        assertEquals(7.0, (Double) e.calculate(), 0.0);
    }

    // Check relational expressions
    @Test
    public void testRelationalExpression() {
        Var a = new Var("a", new Atomic(2));
        assertEquals(2.0, a.getDoubleValue(), 0.0);

        Var b = new Var("b", new ArithmeticExpression(a, new Atomic(1),
                ArithmeticOperator.add));
        assertEquals(3.0, b.getDoubleValue(), 0.0);

        Var c = new Var("c", new ArithmeticExpression(a, b,
                ArithmeticOperator.add));
        assertEquals(5.0, c.getDoubleValue(), 0.0);

        Expression exp = new ArithmeticExpression(a, b, ArithmeticOperator.add);
        assertEquals(5.0, (double) exp.calculate(), 0.0);

        Expression e = new RelationalExpression(exp, c, RelationalOperator.eq);
        assertTrue((boolean) e.calculate());
    }

    // Check logical expressions
    @Test
    public void testLogicalExpression() {
        Var a = new Var("a", new Atomic(3));
        assertEquals(3.0, a.getDoubleValue(), 0.0);

        Var b = new Var("b", new Atomic(2));
        assertEquals(2.0, b.getDoubleValue(), 0.0);

        Var c = new Var("c", new Atomic(true));
        assertTrue(c.getBooleanValue());

        Expression exp = new RelationalExpression(a, b, RelationalOperator.gt);
        assertTrue((boolean) exp.calculate());

        Expression e = new LogicalExpression(exp, c, LogicalOperator.and);
        assertTrue((boolean) e.calculate());
    }

    // Check uninitialized variables
    @Test(expected = NullPointerException.class)
    public void testNoInitializedVariable() {
        Var a = new Var("a");
        a.getIntegerValue();
    }

}
