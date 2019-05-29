/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook.application;

/**
 *
 * @author bangadam
 */
public class Dokter {
    private long id;
    private String nama;
    private String no_hp_1;
    private String no_hp_2;
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_hp_1() {
        return no_hp_1;
    }

    public void setNo_hp_1(String no_hp_1) {
        this.no_hp_1 = no_hp_1;
    }

    public String getNo_hp_2() {
        return no_hp_2;
    }

    public void setNo_hp_2(String no_hp_2) {
        this.no_hp_2 = (no_hp_2 == null ? " " : no_hp_2);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
