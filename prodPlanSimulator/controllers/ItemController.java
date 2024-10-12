package prodPlanSimulator.controllers;

import prodPlanSimulator.models.ItemModel;

import java.util.LinkedList;
import java.util.List;

public class ItemController {
    private List<ItemModel> items;

    public ItemController() {
        this.items = new LinkedList<>();
    }

    public void addItem(ItemModel item) {
        items.add(item);
    }

    public void removeItem(ItemModel item) {
        items.remove(item);
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public ItemModel getItemByName(String name) {
        for (ItemModel item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public ItemModel getItemByCode(String code) {
        for (ItemModel item : items) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }

    public ItemModel getItemByDescription(String description) {
        for (ItemModel item : items) {
            if (item.getDescription().equals(description)) {
                return item;
            }
        }
        return null;
    }

    public void updateItem(ItemModel item) {
        for (ItemModel i : items) {
            if (i.getCode().equals(item.getCode())) {
                i.setName(item.getName());
                i.setDescription(item.getDescription());
                i.setPrice(item.getPrice());
                i.setProductionTime(item.getProductionTime());
                i.setMachine(item.getMachine());
            }
        }
    }

    public void printItems() {
        for (ItemModel item : items) {
            System.out.println(item);
        }
    }


}
