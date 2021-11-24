package com.staticFotografie.src;
public class LensElement {

    static int LENS_COUNT = -2; //-2 because of Border-Elements
    LensElement nextElem, prevElem; //for moving through list
    private String lensName;     //for inserting new objects
    private final String SN;
    private int minFocalLength = 0;
    private int maxFocalLength = 0;
    private String connectToCam = null;    //NULL if Lens not connected to Cam

//CONSTRUCTOR
    public LensElement(String lensName, int minFL, int maxFL) {    //initializing objects
        LENS_COUNT++;
        if(minFL < maxFL){
            setMinFocalLength(minFL);
            setMaxFocalLength(maxFL);
        } else {
            setMinFocalLength(maxFL);
            setMaxFocalLength(minFL);
        }
        if(LENS_COUNT < 10){
            this.SN = "SN00" + LENS_COUNT;
        } else if (LENS_COUNT < 100){
            this.SN = "SN0" + LENS_COUNT;
        } else {
            this.SN = "SN" + LENS_COUNT;
        }
        this.lensName = lensName;
        nextElem = null;
    }

//SETTER
    public void setLensName(String lensName) {
        this.lensName = lensName;
    }

    public void setMinFocalLength(int minFocalLength) {
        if (minFocalLength > this.maxFocalLength && this.maxFocalLength != 0){
            System.out.println("Please check Input or set Max Focal Length first!");
        } else{
            this.minFocalLength = minFocalLength;
        }
    }

    public void setMaxFocalLength(int maxFocalLength) {
        if (maxFocalLength < this.minFocalLength){
            System.out.println("Please check Input or set Min Focal Length first!");
        } else{
            this.maxFocalLength = maxFocalLength;
        }
    }

    public void setConnectToCam(String connectToCam) {
        if(this.connectToCam==null || connectToCam==null) {
            this.connectToCam = connectToCam;
        } else {
            System.out.println("Lens is already in use!");
        }
    }

    public void setNextElem(LensElement nextElem) { //for connecting object to next element
        this.nextElem = nextElem;
    }

    public void setPrevElem(LensElement prevElem) { //for connecting object to previous element
        this.prevElem = prevElem;
    }
//GETTER
    public int getMinFocalLength(){
        return minFocalLength;
    }

    public int getMaxFocalLength(){
        return maxFocalLength;
    }

    public String getLensName() {    //for calling current object
        return lensName;
    }

    public static int getLensCount() {
        return LENS_COUNT;
    }

    public String getSN() {
        return SN;
    }

    public String getConnectToCam() {
        return connectToCam;
    }

    public LensElement getNextElem() {  //for calling next element of Object
        return nextElem;
    }

    public LensElement getPrevElem() {  //for calling previous element of object
        return this.prevElem;
    }

//TOSTRING
    @Override
    public String toString() {
        return "SN= " + SN + "\n" +
                "lensObj=" + lensName + "\n" +
                "focalLength= " + minFocalLength + " - " + maxFocalLength + "\n" +
                "connectToCam= " + connectToCam + "\n\n";
    }
}
