package Logic;

abstract class HeroProperty{
	private int Hp,Sp;
	private String name;
	public final static int DAMAGE_OF_BASIC = 100;
	protected final int SPEED = 20;
	private int ATK;
	public HeroProperty(String name,int Hp , int atk) {
		this.Hp = Hp;
		this.name = name;
		this.ATK = atk;
	}
	public int takeDamage(int damage) {
		damage = damage < 0 ? 0 : damage;
		int remain = this.Hp - damage;
		this.Hp = remain < 0 ? 0 : remain;
		return damage;
	}
	public int getHp() {
		return this.Hp;
	}
	public String getName() {
		return this.name;
	}
	public int getATK() {
		return this.ATK;
	}
	public void setSP(int sp) {
		this.Sp += sp;
	}
	public int getSP() {
		return this.Sp;
	}
}
