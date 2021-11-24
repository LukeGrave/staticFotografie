package com.staticFotografie.src;

public class Main {
    public static void main (String[] args){
/*
        Implementiere die Klassen Camera und Lens.
        Eine Kamera besitzt einige Eigenschaften
        eine Marke brand, eine Anzahl an MegaPixeln megaPixels,
        eine Display Größe displaySize und ein boolsches Flag,
        welches ausdrückt ob schwarz-weiß oder Farb-Fotos (colored).

        Außerdem besitzt eine Kamera ein Objektiv Lens welches eine
        minimale und maximale Brennweite besitzt.

        Verwende bei allen Variablen getter & setter.
        Füge beim Setzen der Brennweiten eines Objektivs bzw beim Konstruieren eines
        Objektivs einen Check hinzu, dass die maximale Brennweite < minimale Brennweite.

        Implementiere statische Zählervariablen für die Kamera und für das Objektiv,
        die mitzählen wieviele Instanzen einer Klasse angelegt wurden.

        Lege in der Main Klasse mehrere Kameras an und wechsle auch auf mindestens einer das Objektiv.
        Überschreibe die To-String Methoden beider Klassen und gib dir ihre Darstellung auf der Konsole nach der Instanzierung aus.
  */
        LensList myLensList = new LensList();
        LensElement tele_lens = new LensElement("Tele_Lens",70,300);
        myLensList.addLens(tele_lens, null);

        Camera nikonD3000 = new Camera("Nikon_D3000", 16, 2.5, true, "Standard_Portrait", 35, 80, myLensList);
        Camera nikonOldSchool = new Camera("Nikon_OldSchool", 8, 0, false, "Standard_Weitwinkel", 24, 70, myLensList);
        Camera nikonD3S = new Camera("Nikon_D3S", 16, 3, true, "Standard_Tele", 30, 200, myLensList);

        LensElement macro_lens = new LensElement("Macro_Lens",105,105);
        myLensList.addLens(macro_lens, null);   //Fix

        LensElement portrait_lens = new LensElement("Portrait_Lens",55,35);
        myLensList.addLens(portrait_lens,null);   //False Entry of FocalLength --- should correct it auto

        //Camera Information plus equipped Lens
        System.out.println(nikonD3000.toString());
        System.out.println(nikonOldSchool.toString());
        System.out.println(nikonD3S.toString());
/*
//        Show List of Lenses
        System.out.println("Available Lenses with connected Camera:");
        myLensList.getLensListPlus();
*/
        //Change Lens
        nikonD3S.setNewLens(macro_lens);
        System.out.println(nikonD3S.toString());

        System.out.println("Available Lenses with connected Camera:");
        myLensList.getLensListPlus();


    }
}
