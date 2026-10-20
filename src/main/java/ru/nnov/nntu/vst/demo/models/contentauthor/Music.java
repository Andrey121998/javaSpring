package ru.nnov.nntu.vst.demo.models.contentauthor;

import jakarta.persistence.Entity;

@Entity
public class Music extends Content{
    private int bitrate;

    public int getBitrate() {
        return bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }
}
