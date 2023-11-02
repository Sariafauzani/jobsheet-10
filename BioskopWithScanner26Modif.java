import java.util.Scanner;

public class BioskopWithScanner26Modif {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int baris;
        int kolom;
        String nama;
        String next;

        String[][] penonton = new String[4][2];

        int menu;
        while (true) {
            System.out.println("Menu: ");
            System.out.println("1. Input Data Penonton");
            System.out.println("2. Tampilkan Daftar Penonton");
            System.out.println("3. Exit");
            System.out.print("Pilih Menu Yang Akan Dipilih: ");
            menu = input.nextInt();
            input.nextLine();

            switch (menu) {
                case 1:
                    while (true) {
                        System.out.print("Masukkan Nama: ");
                        nama = input.nextLine();

                        do {
                            System.out.print("Masukkan Baris (1-4): ");
                            baris = input.nextInt();
                        } while (baris < 1 || baris > 4);

                        do {
                            System.out.print("Masukkan Kolom (1-2): ");
                            kolom = input.nextInt();
                        } while (kolom < 1 || kolom > 2);

                        input.nextLine(); 

                        if (penonton[baris - 1][kolom - 1] != null) {
                            System.out.println("Maaf, kursi tersebut sudah terisi oleh penonton lain.");
                            continue; 
                        }

                        penonton[baris - 1][kolom - 1] = nama;

                        System.out.print("Input penonton lainnya? (y/t) : ");
                        next = input.nextLine();
                        if (next.equalsIgnoreCase("t")) {
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Daftar Penonton");
                    for (int i = 0; i < penonton.length; i++) {
                        for (int j = 0; j < penonton[i].length; j++) {
                            String namaPenonton = (penonton[i][j] != null) ? penonton[i][j] : "";
                            System.out.println("Penonton pada baris ke-" + (i + 1) + " dan kolom ke-" + (j + 1) + ": " + namaPenonton);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Terima kasih. Program selesai.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang benar.");
            }
        }
    }
}