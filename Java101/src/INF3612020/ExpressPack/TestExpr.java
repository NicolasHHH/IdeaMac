package INF3612020.ExpressPack;

public class TestExpr{
    public static void main(String[] args){
        Expression e, e1;
        e1 = new Expression('I', 2);
        e = new Expression('z', 0);
        e = Expression.multiplier(e1, e);
        e1 = new Expression('I', 1);
        e = Expression.additionner(e, e1);
        e1 = new Expression('y', 0);
        e = Expression.diviser(e1, e);
        e1 = new Expression('x', 0);
        e = Expression.additionner(e1, e);
        e1 = new Expression('t', 0);
        e = Expression.additionner(e, e1);
        System.out.println(e.toString());

        e = Expression.instancier_sans(e, 'x', 5);
        e = Expression.instancier_sans(e, 'y', 2);
        e = Expression.instancier_sans(e, 't', 3);
        e = Expression.instancier_sans(e, 'z', 7);
        //System.out.println(e.toString());
        System.out.println(Expression.evaluer(e));
    }
}
