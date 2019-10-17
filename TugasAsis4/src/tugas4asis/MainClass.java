package tugas4asis;

import java.util.Scanner;

/**
 *
 * @author Johanna
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Pilih bangun datar yg diinginkan \n1. Persegi \n2. Lingkaran \n3. Segitiga");
        System.out.print("Masukkan pilihan Anda: ");
        int shape = input.nextInt();
        
        if(shape==1){
            System.out.print("Masukkan panjang sisi: ");
            Persegi object = new Persegi();
            object.Jenis = "persegi";
            object.Sisi = input.nextInt();
            object.view();
        }
        else if(shape==2){
            System.out.print("Masukkan panjang jari-jari: ");
            Lingkaran object = new Lingkaran();
            object.Jenis = "lingkaran";
            object.jari = input.nextInt();
            object.view();
        }
        else if(shape==3){
            System.out.println("Pilih Segitiga yg diinginkan \n1. Segitiga siku-siku\n2. Segitiga sama sisi");
            System.out.print("Masukkan pilihan Anda: ");
            int triangletype = input.nextInt();
            JenisSegitiga object = new JenisSegitiga();
            System.out.print("Masukkan panjang alas: ");
            object.Alas = input.nextInt();
            System.out.print("Masukkan panjang tinggi: ");
            object.Tinggi = input.nextInt();
            object.Jenis = "Segitiga";
            
            if(triangletype==1){
                object.view(object.Alas, object.Tinggi);
            }
            else if(triangletype==2){
                object.view(object.Alas);
            }
            else
                System.out.println("Tidak ada dalam pilihan");
        }
        else
            System.out.println("Tidak ada dalam pilihan");
    }
}

class BangunDatar{
    protected String Jenis;
    
    public BangunDatar(){
        Jenis = null;
    }
    public BangunDatar(String JenisX){
        Jenis = JenisX;
    }
    public void view(){
        System.out.println("Nama bangun datar adalah "+Jenis);
    }
}

class Persegi extends BangunDatar{
    protected double Sisi;

    public double Luas(double Sisi){
        return (Sisi*Sisi);
    }
    public void view(){
        super.view();
        System.out.println("Luasnya adalah "+Luas(Sisi)+"cm^2 \nKeliling adalah "+(Sisi*4));
    }
}

class Segitiga extends BangunDatar{
    protected double Alas;
    protected double Tinggi;
    public double Luas(double Alas, double Tinggi){
        return (0.5*Alas*Tinggi);
    }
    public void view(){
        super.view();
        System.out.println("Luas segitiga adalah "+Luas(Alas,Tinggi));
    }
}

class JenisSegitiga extends Segitiga{
    public double SisiMiring(double Alas, double Tinggi){
        return Math.sqrt(Math.pow(Alas,2)+Math.pow(Tinggi,2));
    }
    public double keliling(double Alas){ //equilateral triangle
        return (Alas*3);
    }
    public double keliling(double Alas, double Tinggi){ //right-angled triangle
        return (Alas+Tinggi+SisiMiring(Alas, Tinggi)); //!!!!! THIS IS INEFFICIENT JOH!!!!!!!!!!!!!!
    }
    public void view(double Alas){ //equilateral triangle
        super.view();
        System.out.println("Jenis Segitiga adalah Segitiga Sama sisi \nKeliling Segitiga adalah "+(Alas*3));
    }
    public void view(double Alas, double Tinggi){ //right-angled triangle
        super.view();
        System.out.println("Jenis Segitiga adalah Segitiga Siku-siku \nKeliling Segitiga adalah "+(Alas+Tinggi+SisiMiring(Alas,Tinggi)));
    }
}

class Lingkaran extends BangunDatar{
    protected double jari;
    public double Luas(double jari){
        return (jari*jari*Math.PI);
    }
    public void view(){
        super.view();
        System.out.printf("luas Lingkaran adalah "+Luas(jari)+"\nkeliling lingkaran adalah "+"%.2f",(2*Math.PI*jari));
        System.out.println();
    }
}