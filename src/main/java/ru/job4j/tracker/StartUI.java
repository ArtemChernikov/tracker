package ru.job4j.tracker;

import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }
    }

    private static void startSqlTracker(Output output, Input input) {
        try (SqlTracker tracker = new SqlTracker()) {
            tracker.init();
            List<UserAction> actions = List.of(
                    new CreateAction(output),
                    new EditItemAction(output),
                    new DeleteAction(output),
                    new DeleteAllAction(output),
                    new ShowAllAction(output),
                    new FindByIdAction(output),
                    new FindByNameAction(output),
                    new Exit(output)
            );
            new StartUI(output).init(input, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void startMemTracker(Output output, Input input) {
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new CreateAction(output),
                new CreateManyAction(output),
                new EditItemAction(output),
                new DeleteAction(output),
                new DeleteAllAction(output),
                new ShowAllAction(output),
                new FindByIdAction(output),
                new FindByNameAction(output),
                new Exit(output)
        );
        new StartUI(output).init(input, tracker, actions);
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        startMemTracker(output, input);
    }
}
