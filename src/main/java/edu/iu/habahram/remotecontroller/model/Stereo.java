package edu.iu.habahram.remotecontroller.model;

public class Stereo {
    String location = "";

    public Stereo(String location) {
        this.location = location;
    }

    public String on() {
        return location + " stereo is on";
    }

    public String off() {
        return location + " stereo is off";
    }

    public String setCD() {
        return location + " stereo is set for CD input";
    }

    public String setDVD() {
        return location + " stereo is set for DVD input";
    }

    public String setRadio() {
        return location + " stereo is set for Radio";
    }

    public String setVolume(int volume) {
        return location + " stereo volume set to " + volume;
    }

    /*
    Add the following class to the system (all methods return values of type string
    - setVolume takes an integer as the volume to be set).
    - The off command simply invokes the off method of the class but the on command invokes three methods:
    first, turn it on, then set it to play the CD, and finally set the volume to 8.
     */


}
