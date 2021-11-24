package com.staticFotografie.src;

public class LensList {
    LensElement startElem = new LensElement("Start", 0, 0);
    LensElement tailElem = new LensElement("Ende", 0, 0);

    public LensList() {   //Link Elements together

        startElem.setNextElem(tailElem);
        tailElem.setPrevElem(startElem);
    }

    public void addLens(LensElement newElem, String brand){  //add new Object at the end

        newElem.setNextElem(tailElem);
        newElem.setPrevElem(tailElem.getPrevElem());
        tailElem.setPrevElem(newElem);
        newElem.getPrevElem().setNextElem(newElem);
        newElem.setConnectToCam(brand);
    }

//    public void getLensList() {
//        LensElement le = startElem.getNextElem();
//        while(le.getNextElem() != null){          //hand out all element
//            System.out.println(le.getLensObj());
//            le = le.getNextElem();
//        }
//    }

    public void getLensListPlus(){
        LensElement le = startElem.getNextElem();
        while(le.getNextElem() != null){          //hand out all element
            System.out.println(le.toString());
            le = le.getNextElem();
        }
    }

    public LensElement getLensElement(LensElement lens){
        LensElement le = startElem.getNextElem(); //first Entry
        while (le.getNextElem() != null){     //while not NULL move forward till entry is found or not available
            if(le.getLensName().equals(lens))
                return le;
            le = le.nextElem;
        }
        System.out.println("Lens not found");   //if not found return False
        return null;
    }

//    public void delete(T o){
//        LensElement le = startElem; //first Entry
//        while (le.getNextElem() != null && !le.getObj().equals(o)){ //search for specific entry and if not at the end of list
//            if(le.getNextElem().getObj().equals(o)){    //if found
//                if(le.getNextElem().getNextElem()!=null){   //and a following entry exists
//                    le.setNextElem(le.getNextElem().getNextElem()); //override Element with next element
//                    le.getNextElem().setPrevElem(le);   //move list entries forward
//                }else{
//                    le.setNextElem(null);   //if found and followed by nothing -- set as NULL
//                    break;  //Nicht ganz Korrekt!!! Tail set loose
//                }
//            }
//            le = le.getNextElem();  //move forward
//        }
//    }

//
//    public LensElement getFirstElem() {
//        return startElem;
//    }
//
//    public LensElement getLastElem() {
//        LensElement le = startElem;
//        while(le.getNextElem() != null){    //search for last Entry and return
//            le = le.getNextElem();
//        }
//        return le;
//    }
//
}
