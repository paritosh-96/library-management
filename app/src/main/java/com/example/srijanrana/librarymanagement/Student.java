package com.example.srijanrana.librarymanagement;

public class Student {

    private String _reg;
    private String _name;
    private String _booklist[]=new String[4];


    public Student() {
    }

    public Student(String _reg, String _name) {
        this._reg = _reg;
        this._name = _name;

    }

    public String[] get_booklist() {
        return _booklist;
    }

    public void set_name(String _name) {

        this._name = _name;
    }

    public void set_booklist(String[] _booklist) {
        this._booklist = _booklist;
    }

    public String get_reg() {
        return _reg;
    }

    public String get_name() {
        return _name;
    }

    public void set_reg(String _reg) {
        this._reg = _reg;
    }
}
