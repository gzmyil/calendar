package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner klavye=new Scanner(System.in);
        Scanner klavye1=new Scanner(System.in);
        Scanner klavye2=new Scanner(System.in);
        Scanner klavye3=new Scanner(System.in);
        Scanner klavye4=new Scanner(System.in);
        Scanner klavye5=new Scanner(System.in);

        String[][]calendar;
        calendar=new String[10][5];
        int secim=0,index=0;
        String tarih,etkinlik,yer,saat, duzenlenecekbilgi="";
        boolean arananetkinlik=false;

       do {
           System.out.println("Takvim uygulamanız için yapacağınız değişikliği seçiniz:");

        System.out.println("1.Etkinlik Ekle");
        System.out.println("2.Etkinlikleri Göster");
        System.out.println("3.Etkinlik Düzenle");
        System.out.println("4.Etkinlik Sil");
        secim= klavye.nextInt();

        switch (secim) {
            case 1:
                if (index < 10) {
                    System.out.println("Etkinlik tarihi giriniz.");
                    tarih = klavye1.nextLine();
                    System.out.println("Planlanan etkinliği giriniz:");
                    etkinlik = klavye2.nextLine();
                    System.out.println("Etkinlik yerini giriniz");
                    yer = klavye3.nextLine();
                    System.out.println("Etkinlik saatini giriniz.");
                    saat = klavye4.nextLine();

                    calendar[index][0] = index + 1 + "";
                    calendar[index][1] = tarih;
                    calendar[index][2] = etkinlik;
                    calendar[index][3] = yer;
                    calendar[index][4] = saat;
                    index++;

                } else {
                    System.out.println("Takviminiz doludur.Yeni etkinlik eklemek için biten etkinlikleri silebilirsiniz.");
                }
                break;
            case 2:
                if (index > 0) {
                    for (int i = 0; i < index; i++) {

                        System.out.println("Etkinlik Listesi:");
                        System.out.println(calendar[i][0] + ".etkinlik; tarihi:" + calendar[i][1] + " ,etkinlik: " + calendar[i][2] + " ,yer: " + calendar[i][3] + " ,saati: " + calendar[i][4]);
                    }
                } else {
                    System.out.println("Etkinlik bulunamamıştır.");
                }
                break;

            case 3:
                arananetkinlik=false;
                if(index>0){
                    System.out.println("Düzenlenecek etkinliğin adını giriniz");
                    etkinlik= klavye4.nextLine();
                    for(int i=0;i<index;i++){
                        if(etkinlik.equals(calendar[i][2])){
                            System.out.println("Düzenlenecek bilgiyi seçiniz:");
                            System.out.println("tarih, etkinlik, yer, saat ");
                            duzenlenecekbilgi= klavye4.nextLine();
                            if(duzenlenecekbilgi.equals("tarih")){
                                System.out.println("Yeni tarih bilgisi giriniz.");
                                calendar[i][1]= klavye4.nextLine();
                            }else if(duzenlenecekbilgi.equals("etkinlik")){
                                System.out.println("Yeni etkinlik bilgisi giriniz.");
                                calendar[i][2]= klavye4.nextLine();
                            }else if(duzenlenecekbilgi.equals("yer")){
                                System.out.println("Yeni yer bilgisi giriniz.");
                                calendar[i][3]=klavye4.nextLine();
                            }else if(duzenlenecekbilgi.equals("saat")){
                                System.out.println("Yeni saat bilgisi giriniz.");
                                calendar[i][4]= klavye4.nextLine();
                            }else{
                                System.out.println("Hatalı giriş yapıldı.");
                            }arananetkinlik=true;
                            break;

                        }

                    }
                }
            case 4:
                arananetkinlik=false;
                if(index!=0){
                    System.out.println("Silinecek etkinliği giriniz:");
                    etkinlik=klavye4.nextLine();

                    for(int i=0;i<index;i++){
                        if(etkinlik.equals(calendar[i][2])){
                            for(int j=0;j<index-1;j++){
                            calendar[j][0]=(Integer.parseInt(calendar[j+1][0]-1))+" ";
                            calendar[j][1]=calendar[j+1][1];
                            calendar[j][2]=calendar[j+1][2];
                            calendar[j][3]=calendar[j+1][3];
                            calendar[j][4]=calendar[j+1][4];
                            index--;

                        }arananetkinlik=true;
                            break;
                    }
                }}
        }
       }while(secim!=6);

    }
}
