package money;

class Money implements Expression{
    protected int amount;
    protected String currency;
    public Expression times(int multiplier){
        return new Money(this.amount * multiplier, this.currency);
    }
    Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    String currency(){
        return this.currency;
    }
    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount
                && this.currency().equals(money.currency());
    }
    public String toString(){
        return amount + " " + currency;
    }
    static Money dollar(int amount){
        return new Money(amount, "USD");
    }
    static Money franc(int amount){
        return new Money(amount, "CHF");
    }
    public Expression plus(Expression addend){
        return new Sum(this, addend);
    }
    public Money reduce(Bank bank, String to){
        int rate = bank.rate(this.currency, to);
        return new Money(amount / rate, to);
    }
}
