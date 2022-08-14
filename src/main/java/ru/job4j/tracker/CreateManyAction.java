package ru.job4j.tracker;

public class CreateManyAction implements UserAction {
    private final Output out;

    public CreateManyAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add many items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create new Items ====");
        int count = input.askInt("Enter amount: ");
        String name = input.askStr("Enter name: ");
        for (int i = 0; i < count; i++) {
            Item item = new Item(name);
            tracker.add(item);
        }
        out.println("Количество добавленных заявок: " + count);
        return true;
    }
}
