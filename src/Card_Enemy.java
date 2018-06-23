public class Card_Enemy
{
    private int prize;
    private int card_position;
    private int who_buy;
    private String name_who_buy;
    private boolean flag_buy_card = false;
    public Card_Enemy(int prize, int card_position)
    {
        this.prize = prize;
        this.card_position = card_position;
    }
    public boolean getFlag_buy_card()
    {
        return flag_buy_card;
    }
    public int getCard_position()
    {
        return card_position;
    }
    public void setWho_buy(int who_buy, String name_who_buy)
    {
        this.who_buy = who_buy;
        this.name_who_buy = name_who_buy;
        this.flag_buy_card = true;
    }
    public int getWho_buy()
    {
        return who_buy;
    }
    public String getName_who_buy()
    {
        return name_who_buy;
    }
    public int getPrize()
    {
        return prize;
    }


}
