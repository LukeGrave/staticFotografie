package com.staticFotografie.src;

public class Camera {
    static int CAM_COUNT = 0;

    String brand;

    private int megaPixels;
    private double displaySize;
    private boolean colored;
    private LensElement lens;    //Lens connected to Cam
//CONSTRUCTOR
    public Camera(String brand, int megaPixels, double displaySize,
                  boolean colored, String lensName ,int minFocalLength,
                  int maxFocalLength, LensList myLensList){
        CAM_COUNT++;
        setBrand(brand);
        setMegaPixels(megaPixels);
        setDisplaySize(displaySize);
        setColored(colored);
        LensElement lens = new LensElement(lensName, minFocalLength, maxFocalLength);
        setLens(lens);

//        LensElement newElem = new LensElement(lensName, this.minFL, this.maxFL);
        myLensList.addLens(lens, brand);
    }
//SETTER
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setMegaPixels(int megaPixels) {
        this.megaPixels = megaPixels;
    }

    public void setDisplaySize(double displaySize) {
        this.displaySize = displaySize;
    }

    public void setColored(boolean colored) {
        this.colored = colored;
    }

//    public void setMinFL(int minFL) {
//        if (minFL > this.maxFL && this.maxFL != 0){
//            System.out.println("Please check Input or set Max Focal Length first!");
//        } else{
//            this.minFL = minFL;
//        }
//    }
//
//    public void setMaxFL(int maxFL) {
//        if (maxFL < this.minFL){
//            System.out.println("Please check Input or set Min Focal Length first!");
//        } else{
//            this.maxFL = maxFL;
//        }
//    }

    public void setLens(LensElement lens) {
        this.lens = lens;

    }

    public void setNewLens(LensElement desiredLens){
//        LensElement oldLE = myList.getLensElement(this.lens.getLensName());
        this.lens.setConnectToCam(null);
//        LensElement newLE = desiredLens;
        this.lens = desiredLens;
        desiredLens.setConnectToCam(this.brand);
//        this.lens = newLE;
//        this.minFL = newLE.getMinFocalLength();
//        this.maxFL = newLE.getMaxFocalLength();
    }

//GETTER
    public static int getCamCount() {
    return CAM_COUNT;
}

    public String getBrand() {
        return brand;
    }

    public int getMegaPixels() {
        return megaPixels;
    }

    public double getDisplaySize() {
        return displaySize;
    }

    public boolean isColored() {
        return colored;
    }


    public LensElement getLens() {
        return lens;
    }
//TOSTRING
    @Override
    public String toString() {
        return "brand=" + brand + "\n" +
                "megaPixels=" + megaPixels +
                " | displaySize=" + displaySize + "\n" +
                "colored=" + colored + "\n" +
                "lens=" + lens.getLensName() + "\n" +
                "minFL=" + lens.getMinFocalLength() +
                " | maxFL=" + lens.getMaxFocalLength() + "\n\n";
    }
}
