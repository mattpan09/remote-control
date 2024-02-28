package edu.iu.habahram.remotecontroller.repository;

import edu.iu.habahram.remotecontroller.model.DeviceData;
import edu.iu.habahram.remotecontroller.model.Light;
import edu.iu.habahram.remotecontroller.model.RemoteControl;
import edu.iu.habahram.remotecontroller.model.Stereo;

import java.util.HashMap;
import java.util.List;

public class RemoteLoader implements  IRemoteLoader{
    private volatile static RemoteLoader uniqueInstance;
    private RemoteLoader() { //No code needed inside constructor - empty constructor

    } //private constructor needed to prevent everyone else from instantiating
    //private means no one outside of this class can access it
    public static RemoteLoader getInstance() {
        if(uniqueInstance == null) {
            synchronized (RemoteLoader.class) {
                if(uniqueInstance == null) {
                    uniqueInstance = new RemoteLoader();
                }
            }
        }
        return uniqueInstance;
    }


    HashMap<Integer, RemoteControl> remoteControls = new HashMap<>();
    @Override
    public void setup(int id, List<DeviceData> devices) {
        RemoteControl remoteControl = new RemoteControl(devices.size());
        for(DeviceData device : devices) {
            switch (device.type()) {
                case "light":
                    Light light = new Light(device.location());
                    remoteControl.setCommand(device.slot(), () -> light.on(), () -> light.off());
                    break;
                case "stereo":
                    Stereo stereo = new Stereo(device.location());
                    remoteControl.setCommand(device.slot(), () -> stereo.on(), () -> stereo.off());
                    break;
            }
        }
        remoteControls.put(id, remoteControl);
        System.out.println(remoteControl.toString());
    }

    @Override
    public String onButtonWasPushed(int id, int slot) {
         return remoteControls.get(id).onButtonWasPushed(slot);
    }

    @Override
    public String offButtonWasPushed(int id, int slot) {
        return remoteControls.get(id).offButtonWasPushed(slot);

    }
}
