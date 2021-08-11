package INF3612020.ExpressPack;

public class Expression {
    public char type; // ’I’, ’x’, ’+’, ...
    public int n;
    public Expression gauche, droit;
    public Expression(char type, int n, Expression fg, Expression fd){
        this.type = type;
        this.n = n;
        this.gauche = fg;
        this.droit = fd;
    }
    public Expression(char type, int n){
        this.type = type;
        this.n = n;
        this.gauche = null;
        this.droit = null;
    }

    public static String chaineInfixe(Expression e){
        String s = "";
        if(e != null){
            if(e.gauche != null){
                s = "(" + chaineInfixe(e.gauche) + ")";
            }
            if(e.type == 'I')
                s += " " +e.n + " ";
            else
                s += " " +e.type + " ";
            if(e.droit != null){
                s += "(" + chaineInfixe(e.droit) + ")";
            }
        }
        return s;
    }

    public String toString(){
        return chaineInfixe(this);
    }

    // 4 opérations
    public static Expression additionner(Expression e1, Expression e2){
        return new Expression('+', 0, e1, e2);
    }
    public static Expression soustraire(Expression e1,Expression e2){
        return new Expression('-', 0, e1, e2);
    }
    public static Expression multiplier(Expression e1,Expression e2){
        return new Expression('*', 0, e1, e2);
    }
    public static Expression diviser(Expression e1,Expression e2){
        return new Expression('/', 0, e1, e2);
    }

    public static int evaluer(Expression e){
        if(e == null)
            return 0; // convention pratique
        switch(e.type){
            case 'I':
                return e.n;
            case '+':
                return evaluer(e.gauche)+evaluer(e.droit);
            case '*':
                return evaluer(e.gauche)*evaluer(e.droit);
            case '-':
                return evaluer(e.gauche)-evaluer(e.droit);
            case '/':
                return evaluer(e.gauche)/evaluer(e.droit);
            default:
                System.out.println("Erreur");
        }
        return 0;
    }

    public static Expression instancier(Expression e, char v, int n){
        if(e == null)
            return null;
        else{
            Expression g = instancier(e.gauche, v, n);
            Expression d = instancier(e.droit, v, n);
            if(e.type == v)
                return new Expression('I', n, g, d);
            else
                return new Expression(e.type, e.n, g, d);
        }
    }
    public static Expression instancier_sans(Expression e, char v, int n){
        if(e == null)
            return null;
        else{
            if(e.type == v){
                e.type = 'I';
                e.n = n;
            }
            e.gauche = instancier(e.gauche, v, n);
            e.droit = instancier(e.droit, v, n);
            return e;
        }
    }




}
