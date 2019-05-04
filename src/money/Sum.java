package money;

public class Sum implements Expression{
    Expression augend;
    Expression addend;

    Sum(Expression augend, Expression addend){
        this.augend = augend;
        this.addend = addend;
    }
    @Override
    public Expression times(int multiplier){
        return new Sum(this.augend.times(multiplier), this.addend.times(multiplier));
    }
    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }
    public Money reduce(Bank bank, String to){
        int amount = addend.reduce(bank, to).amount + augend.reduce(bank, to).amount;
        return new Money(amount, to);
    }
}
