package _21010310072_Dilek_Dede;

import java.util.ArrayList;
import java.util.List;

public class Hafiza {

	private List<Proses> aktifProsesler;
	private int ramBoyutu;
	private boolean[] hafizaDurumu;
	public static final int isletimboyut = 1024000;

	public Hafiza(int boyut) {
		this.ramBoyutu = 2048 * 1024;
		this.aktifProsesler = new ArrayList<>();
		this.hafizaDurumu = new boolean[this.ramBoyutu];

		for (int i = 0; i < isletimboyut; i++) {
			hafizaDurumu[i] = true;
		}
	}

	public void prosesEkle(Proses proses) {
		int baslangicAdresi = -1;
		int boyut = proses.getToplamBoyutByte();
		

		for (int i = Hafiza.isletimboyut; i <= ramBoyutu - boyut; i++) {
			boolean item = true;
			for (int j = i; j < i + boyut; j++) {
				if (hafizaDurumu[j]) {
					item = false;
					break;
				}
			}
			if (item) {
				baslangicAdresi = i;
				break;
			}
		}

		if (baslangicAdresi != -1) {
			for (int i = baslangicAdresi; i < baslangicAdresi + boyut; i++) {
				hafizaDurumu[i] = true;
			}
			proses.setBaslangicAdresi(baslangicAdresi);
			proses.setBitisAdresi(baslangicAdresi + boyut - 1);
			aktifProsesler.add(proses);
		} else {
			System.out.println("Hafızada proses eklemek için yeterli alan yok!");
		}
	}

	public List<Proses> getAktifProsesler() {
		return aktifProsesler;
	}

}
