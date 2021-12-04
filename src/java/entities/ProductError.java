/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ADMIN
 */
public class ProductError {
    private String nameError;
    private String imageError;
    private String priceError;
    private String titleError;

    public ProductError() {
    }

    public ProductError(String nameError, String imageError, String priceError, String titleError) {
        this.nameError = nameError;
        this.imageError = imageError;
        this.priceError = priceError;
        this.titleError = titleError;
    }

    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getImageError() {
        return imageError;
    }

    public void setImageError(String imageError) {
        this.imageError = imageError;
    }

    public String getPriceError() {
        return priceError;
    }

    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

    public String getTitleError() {
        return titleError;
    }

    public void setTitleError(String titleError) {
        this.titleError = titleError;
    }
    
    
    
}
