/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pod.projetoconexao;

/**
 *
 * @author laerton
 */
public class Order {
    private int _id, _salesmanis, _productid, _quantity;

    public Order(int _id, int _salesmanis, int _productid, int _quantity) {
        this._id = _id;
        this._salesmanis = _salesmanis;
        this._productid = _productid;
        this._quantity = _quantity;
    }

    
    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public int getSalesmanis() {
        return _salesmanis;
    }

    public void setSalesmanis(int _salesmanis) {
        this._salesmanis = _salesmanis;
    }

    public int getProductid() {
        return _productid;
    }

    public void setProductid(int _productid) {
        this._productid = _productid;
    }

    public int getQuantity() {
        return _quantity;
    }

    public void setQuantity(int _quantity) {
        this._quantity = _quantity;
    }
}
