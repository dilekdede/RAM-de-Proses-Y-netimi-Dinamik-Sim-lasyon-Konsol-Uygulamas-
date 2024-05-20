package _21010310072_Dilek_Dede;

public class Proses {

	private int pid;
	private String isim;
	private int baslangic;
	private int bitis;
	private int kodBuyuklugu;
	private int stack;
	private int dataBuyuklugu;
	private int stackBuyuklugu;
	private int baslangicAdresi;
	private int bitisAdresi;

	public Proses(int pid, String isim, int baslangic, int bitis, int dataBuyuklugu, int kodBuyuklugu, int stack,
			int stackBuyuklugu) {
		this.pid = pid;
		this.isim = isim;
		this.baslangic = baslangic;
		this.bitis = bitis;
		this.dataBuyuklugu = dataBuyuklugu;
		this.kodBuyuklugu = kodBuyuklugu;
		this.stack = stack;
		this.stackBuyuklugu = stackBuyuklugu;
	}

	public int getToplamBoyutByte() {
		return (dataBuyuklugu + kodBuyuklugu + stack + stackBuyuklugu) * 1024;
	}

	public int getPid() {
		return pid;
	}

	public String getIsim() {
		return isim;
	}

	public int getBaslangicZamani() {
		return baslangic;
	}

	public int getBitisZamani() {
		return bitis;
	}

	public int getToplamBuyukluk() {
		return dataBuyuklugu + kodBuyuklugu + stack + stackBuyuklugu;
	}

	public int getBaslangicAdresi() {
		return baslangicAdresi;
	}

	public int getBitisAdresi() {
		return bitisAdresi;
	}

	public void setBaslangicAdresi(int adres) {
		this.baslangicAdresi = adres;
	}

	public void setBitisAdresi(int adres) {
		this.bitisAdresi = adres;
	}

	public int getKodBuyuklugu() {
		return kodBuyuklugu;
	}

	public void setKodBuyuklugu(int kodBuyuklugu) {
		this.kodBuyuklugu = kodBuyuklugu;
	}

	public int getYiginBuyuklugu() {
		return stack;
	}

	public void setYiginBuyuklugu(int yiginBuyuklugu) {
		this.stack = yiginBuyuklugu;
	}

	public int getDataBuyuklugu() {
		return dataBuyuklugu;
	}

	public void setDataBuyuklugu(int dataBuyuklugu) {
		this.dataBuyuklugu = dataBuyuklugu;
	}

	public int getYiginTepesiBuyuklugu() {
		return stackBuyuklugu;
	}

	public void setYiginTepesiBuyuklugu(int yiginTepesiBuyuklugu) {
		this.stackBuyuklugu = yiginTepesiBuyuklugu;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public void setBaslangicZamani(int baslangic) {
		this.baslangic = baslangic;
	}

	public void setBitisZamani(int bitis) {
		this.bitis = bitis;
	}

}
