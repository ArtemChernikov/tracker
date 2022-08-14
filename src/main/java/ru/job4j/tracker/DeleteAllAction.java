package ru.job4j.tracker;

public class DeleteAllAction implements UserAction {
    private final Output out;

    public DeleteAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete all items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete all items ===");
        if (tracker.deleteAll()) {
            out.println("Заявки удалены успешно.");
        } else {
            out.println("Ошибка удаления заявок.");
        }
        return true;
    }
}
