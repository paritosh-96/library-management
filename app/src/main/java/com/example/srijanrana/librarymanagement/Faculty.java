package com.example.srijanrana.librarymanagement;

/**
 * Created by Srijan Rana on 11/2/2015.
 */
public class Faculty {


    private int _id;
    private String _name;
    private String _booklist[]=new String[4];

    public Faculty() {
    }

    public Faculty(int _id, String _name) {
        this._id = _id;
        this._name = _name;

    }

    public int get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_name(String _name) {
        this._name = _name;
    }
}
