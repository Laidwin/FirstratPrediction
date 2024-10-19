package org.example.demo;

public class FirstratPrediction {
    private int priceProduct1;
    private int priceProduct2;
    private int quantityProduct1;
    private int quantityProduct2;
    private int quantityRawMaterial1;
    private int quantityRawMaterial2;
    private int numberMachine;
    private int numberHoursforMachine;

    public FirstratPrediction(int priceProduct1, int priceProduct2, int quantityProduct1, int quantityProduct2, int quantityRawMaterial1, int quantityRawMaterial2, int numberMachine) {
        this.priceProduct1 = priceProduct1;
        this.priceProduct2 = priceProduct2;
        this.quantityProduct1 = quantityProduct1;
        this.quantityProduct2 = quantityProduct2;
        this.quantityRawMaterial1 = quantityRawMaterial1;
        this.quantityRawMaterial2 = quantityRawMaterial2;
        this.numberMachine = numberMachine;
        this.numberHoursforMachine = 150 * numberMachine;
    }

    public int getPriceProduct1() {
        return this.priceProduct1;
    }

    public int getPriceProduct2() {
        return this.priceProduct2;
    }

    public int getQuantityProduct1() {
        return this.quantityProduct1;
    }

    public int getQuantityProduct2() {
        return this.quantityProduct2;
    }

    public int getQuantityRawMaterial1() {
        return this.quantityRawMaterial1;
    }

    public int getQuantityRawMaterial2() {
        return this.quantityRawMaterial2;
    }

    public int getNumberMachine() {
        return this.numberMachine;
    }

    public int getNumberHoursforMachine() {
        return this.numberHoursforMachine;
    }

    public void setPriceProduct1(int priceProduct1) {
        this.priceProduct1 = priceProduct1;
    }

    public void setPriceProduct2(int priceProduct2) {
        this.priceProduct2 = priceProduct2;
    }

    public void setQuantityProduct1(int quantityProduct1) {
        this.quantityProduct1 = quantityProduct1;
    }

    public void setQuantityProduct2(int quantityProduct2) {
        this.quantityProduct2 = quantityProduct2;
    }

    public void setQuantityRawMaterial1(int quantityRawMaterial1) {
        this.quantityRawMaterial1 = quantityRawMaterial1;
    }

    public void setQuantityRawMaterial2(int quantityRawMaterial2) {
        this.quantityRawMaterial2 = quantityRawMaterial2;
    }

    public void setNumberMachine(int numberMachine) {
        this.numberMachine = numberMachine;
        this.numberHoursforMachine = 150 * numberMachine;
    }

    public int predictQuantityProduct1() {
        int quantityRawMaterial1 = this.quantityRawMaterial1 - this.quantityProduct2*4;
        int quantityRawMaterial2 = this.quantityRawMaterial2 - this.quantityProduct2*2;
        int numberHoursforMachine = this.numberHoursforMachine - this.quantityProduct2*8;
        while (quantityRawMaterial1 >= 0 && quantityRawMaterial2 >= 0 && numberHoursforMachine >= 0) {
            this.quantityProduct1 += 1;
            quantityRawMaterial1 -= 8;
            quantityRawMaterial2 -= 1;
            numberHoursforMachine -= 4;
        }
        return this.quantityProduct1;
    }

    public int predictQuantityProduct2() {
        int quantityRawMaterial1 = this.quantityRawMaterial1 - this.quantityProduct1*8;
        int quantityRawMaterial2 = this.quantityRawMaterial2 - this.quantityProduct1;
        int numberHoursforMachine = this.numberHoursforMachine - this.quantityProduct1*4;
        while (quantityRawMaterial1 >= 0 && quantityRawMaterial2 >= 0 && numberHoursforMachine >= 0) {
            this.quantityProduct2 += 1;
            quantityRawMaterial1 -= 4;
            quantityRawMaterial2 -= 2;
            numberHoursforMachine -= 8;
        }
        return this.quantityProduct2;
    }

    public int predictQuantityRawMaterial1() {
        return this.quantityRawMaterial1 - this.quantityProduct1*8 - this.quantityProduct2*4;
    }

    public int predictQuantityRawMaterial2() {
        return this.quantityRawMaterial2 - this.quantityProduct1 - this.quantityProduct2*2;
    }
}

