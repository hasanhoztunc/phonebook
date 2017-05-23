
package telefonrehberi;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class islemYap 
{
File veri;
String verial;
String bilgi=" ";
public islemYap(String verial)
{
  this.verial=verial;
  veri=new File("C:\\Users\\Monster\\Desktop\\phonebookproje\\veri3.txt");
  if(!veri.exists())
  {
  Create();    
  }
}

public String veriGoruntule() throws FileNotFoundException
{    
    try 
    {
    System.out.println("Rehberinizdeki kişiler");
    System.out.println("_______________________");
    FileReader fr=new FileReader ("C:\\Users\\Monster\\Desktop\\phonebookproje\\veri3.txt");
    LineNumberReader lr=new LineNumberReader(fr);
    String veritut;       
    bilgi=" ";
    while((veritut=lr.readLine())!=null)
    {
    bilgi+=veritut+"\n";                
    }
    return bilgi;            
    }
    catch(IOException e)
    {
    return e.toString();
    }
} 
public void kisiSil(String isim)
{
   try 
   {
    File verigir = new File(verial);
    File geciciveri = new File(verial);

    BufferedReader br = new BufferedReader(new FileReader(verigir));
    BufferedWriter bw = new BufferedWriter(new FileWriter(geciciveri,true));

    String lineToRemove = isim;
    String currentLine;
			
    String dizi[] = new String[100];
    int i=0;
			
    while((currentLine = br.readLine()) != null) 
    {
    String trimmedLine = currentLine.trim();
    if(trimmedLine.contains(lineToRemove)) 
    continue;
        dizi[i]=currentLine;
        i++;
    }
			
    PrintWriter pw = new PrintWriter(veri);
    pw.print("");
			
    for (String item : dizi) 
    {
        if(item!=null)
        {
	bw.write(item);
	bw.newLine();
        }
    }
			
        bw.close();
	System.out.println("Kişi  rehberden silindi");	
    } 
   catch (IOException e) 
   {
   }
 
}
public void kisiEkle(kisiBilgiler kisi)
{
    try 
    {
    BufferedWriter bw = new BufferedWriter(new FileWriter(new File(verial), true));
    String kayıt = kisi.getIsim() + " " + kisi.getSoyisim() + " telNo:" + kisi.getNumara();
    bw.write(kayıt);
    bw.newLine();
    bw.close();
    System.out.println("Kişi başarıyla rehbere eklendi");
    } 
    catch (IOException e) 
    {
    System.out.print("Bir hata oluştu."+e.toString());
    }
}
	
public void Create()
{
   veri = new File(this.verial);
   try 
   {
   if(veri.createNewFile())
   {
   System.out.print("Yeni dosya oluşturuldu");
   }
   } 
   catch (IOException exc) 
   {
   Logger.getLogger(islemYap.class.getName()).log(Level.SEVERE, null, exc);
   }
}	
}
    
    
    
    
    
    
    
    
    
   
