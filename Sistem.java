package _21010310072_Dilek_Dede;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sistem {
	private Hafiza hafiza;
	private int pidSayaci = 1000;

	public Sistem() {
		hafiza = new Hafiza(1024 * 1024);
	}

	public void okutma(String dosyatxt) {
		try {
			File dosya = new File("girdi.txt");
			Scanner scanner = new Scanner(dosya);
			while (scanner.hasNextLine()) {
				String[] satir = scanner.nextLine().split(" ");
				Proses proses = new Proses(pidSayaci + 3, satir[0], Integer.parseInt(satir[1]),
						Integer.parseInt(satir[2]), Integer.parseInt(satir[3]), Integer.parseInt(satir[4]),
						Integer.parseInt(satir[5]), Integer.parseInt(satir[6]));
				hafiza.prosesEkle(proses);
			}
			scanner.close();
		} catch (FileNotFoundException e) {

		}
	}

	public void ram() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Lütfen RAM’in durumunu görmek istediğiniz saniyeyi giriniz.");
		int saniye = scanner.nextInt();

		System.out.println(saniye + ". Saniyede RAM’in dolu olan kısımları:");
		System.out.println("0. Ve " + (Hafiza.isletimboyut - 1) + ". Adresler arasında işletim sistemi bulunmaktadır.");
		for (Proses proses : hafiza.getAktifProsesler()) {
			if (proses.getBaslangicZamani() <= saniye && proses.getBitisZamani() >= saniye) {
				System.out.println(proses.getBaslangicAdresi() + ". Ve " + proses.getBitisAdresi()
						+ ". Adresler arasında " + proses.getIsim() + " programı bulunmaktadır.");
			}
		}

		System.out.println("PCB’si bulunan Prosesler:");
		StringBuilder pcbListesi = new StringBuilder();
		for (Proses proses : hafiza.getAktifProsesler()) {
			if (proses.getBaslangicZamani() <= saniye && proses.getBitisZamani() >= saniye) {
				pcbListesi.append(proses.getIsim()).append(" ");
			}
		}
		System.out.println(pcbListesi.toString().trim());

		System.out.println(saniye + ". saniyedeki PCB’sini görüntülemek istediğiniz proses ismini giriniz:");
		String isim = scanner.next();

		pcbBilgileriGoster(isim, saniye);
		scanner.close();
	}

	private void pcbBilgileriGoster(String isim, int saniye) {
		boolean found = false;
		for (Proses proses : hafiza.getAktifProsesler()) {
			if (proses.getIsim().equalsIgnoreCase(isim) && proses.getBaslangicZamani() <= saniye
					&& proses.getBitisZamani() >= saniye) {
				System.out.println(isim + " isimli prosesin " + saniye + ". Saniyedeki PCB bilgileri şu şekildedir:");
				System.out.println("Proses numarası: " + proses.getPid());
				System.out.println("Prosesin yaratılma zamanı: " + proses.getBaslangicZamani() + ". saniye");
				System.out.println("Prosesin toplam büyüklüğü: " + proses.getToplamBuyukluk() + " KB");
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Proses mevcut değil");
		}
	}

	public static void main(String[] args) {
		Sistem sistem = new Sistem();
		sistem.okutma("girdi.txt");
		sistem.ram();
	}

}
