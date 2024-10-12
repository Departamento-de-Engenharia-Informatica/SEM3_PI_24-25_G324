package prodPlanSimulator.controllers;

import prodPlanSimulator.models.MachineModel;
import java.util.LinkedList;
import java.util.List;

public class MachineController {
    private List<MachineModel> machines;

    public MachineController(List<MachineModel> machines) {
        this.machines = new LinkedList<>();
    }

    public MachineController() {
        this.machines = new LinkedList<>();
    }

    public void addMachine(MachineModel machine) {
        machines.add(machine);
    }

    public void removeMachine(MachineModel machine) {
        machines.remove(machine);
    }

    public List<MachineModel> getMachines() {
        return machines;
    }

    public MachineModel getMachineByName(String name) {
        for (MachineModel machine : machines) {
            if (machine.getName().equals(name)) {
                return machine;
            }
        }
        return null;
    }

    public MachineModel getMachineByModel(String model) {
        for (MachineModel machine : machines) {
            if (machine.getModel().equals(model)) {
                return machine;
            }
        }
        return null;
    }

    public void updateMachine(MachineModel machine) {
        for (MachineModel m : machines) {
            if (m.getName().equals(machine.getName())) {
                m.setModel(machine.getModel());
                m.setYear(machine.getYear());
            }
        }
    }

    public void printMachines() {
        for (MachineModel machine : machines) {
            System.out.println(machine);
        }
    }
}
