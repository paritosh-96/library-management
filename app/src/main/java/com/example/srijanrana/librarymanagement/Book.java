package com.example.srijanrana.librarymanagement;

/**
 * Created by Srijan Rana on 11/2/2015.
 */
public class Book {

    private int _ref;
    private String _name;
    private String _Status;

    public Book() {

    }

    public Book(int r){
        this._ref=r;
    }
    public Book(int _ref, String _name, String _Status) {
        this._ref = _ref;
        this._name = _name;
        this._Status = _Status;
    }

    public int get_ref() {
        return _ref;
    }

    public String get_name(int r) {

        return _name;
    }

    public String get_Status() {
        return _Status;
    }

    public void set_ref(int _ref) {
        this._ref = _ref;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_Status(String _Status) {
        this._Status = _Status;
    }
}
