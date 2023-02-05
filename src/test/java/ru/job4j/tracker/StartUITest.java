package ru.job4j.tracker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(new CreateAction(out), new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenEditItem() {
        Store tracker = new MemTracker();
        Output out = new StubOutput();
        Item item = tracker.add(new Item("Edited item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", Integer.toString(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = List.of(new EditItemAction(out), new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Store tracker = new MemTracker();
        Output out = new StubOutput();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", Integer.toString(item.getId()), "1"}
        );
        List<UserAction> actions = List.of(new DeleteAction(out), new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        Assertions.assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(new Exit(out));
        String ln = System.lineSeparator();
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenEditItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = List.of(new EditItemAction(out), new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenShowAllTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        Item three = tracker.add(new Item("test3"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        List<UserAction> actions = List.of(new ShowAllAction(out), new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + one + ln
                        + two + ln
                        + three + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindByNameTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        Item three = tracker.add(new Item("test3"));
        Input in = new StubInput(
                new String[]{"0", "test2", "1"}
        );
        List<UserAction> actions = List.of(new FindByNameAction(out), new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + two + ln
                        + "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenFindByIdTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        Item three = tracker.add(new Item("test3"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(two.getId()), "1"}
        );
        List<UserAction> actions = List.of(new FindByIdAction(out), new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + two + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit Program ===" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"10", "0"}
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(new Exit(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu:" + ln
                                + "0. Exit Program" + ln
                                + "Wrong input, you can select: 0 .. 0" + ln
                                + "Menu:" + ln
                                + "0. Exit Program" + ln
                                + "=== Exit Program ===" + ln
                )
        );
    }

    @Test
    public void whenFindByNameMockSuccess() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Input input = mock(Input.class);
        FindByNameAction findByNameAction = new FindByNameAction(out);
        String itemName = "NewItem";
        Item addedItem = tracker.add(new Item(itemName));
        when(input.askStr(any(String.class))).thenReturn(itemName);
        findByNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ===" + ln + addedItem + ln));
        assertThat(tracker.findAll().get(0).getName(), is(addedItem.getName()));
    }

    @Test
    public void whenFindByNameMockFailed() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Input input = mock(Input.class);
        FindByNameAction findByNameAction = new FindByNameAction(out);
        String itemName = "NewItem";
        String reqName = "OtherName";
        Item addedItem = tracker.add(new Item(itemName));
        when(input.askStr(any(String.class))).thenReturn(reqName);
        findByNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ===" + ln + "Заявки с именем: " + reqName + " не найдены." + ln));
        assertThat(tracker.findAll().get(0).getName(), is(addedItem.getName()));
    }

    @Test
    public void whenFindByIdMockSuccess() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Input input = mock(Input.class);
        FindByIdAction findByIdAction = new FindByIdAction(out);
        Item addedItem = tracker.add(new Item("NewItem"));
        when(input.askInt(any(String.class))).thenReturn(1);
        findByIdAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ===" + ln + addedItem + ln));
        assertThat(tracker.findAll().get(0).getName(), is(addedItem.getName()));
    }

    @Test
    public void whenFindByIdMockFailed() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Input input = mock(Input.class);
        FindByIdAction findByIdAction = new FindByIdAction(out);
        Item addedItem = tracker.add(new Item("NewItem"));
        int reqId = 2;
        when(input.askInt(any(String.class))).thenReturn(2);
        findByIdAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ===" + ln + "Заявка с введенным id: " + reqId + " не найдена." + ln));
        assertThat(tracker.findAll().get(0).getName(), is(addedItem.getName()));
    }

    @Test
    public void whenDeleteItemMockSuccess() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Input input = mock(Input.class);
        DeleteAction deleteAction = new DeleteAction(out);
        tracker.add(new Item("deleteItem"));
        when(input.askInt(any(String.class))).thenReturn(1);
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Заявка удалена успешно." + ln));
        assertThat(tracker.findAll().isEmpty(), is(true));
    }

    @Test
    public void whenDeleteItemMockFailed() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Input input = mock(Input.class);
        DeleteAction deleteAction = new DeleteAction(out);
        tracker.add(new Item("deleteItem"));
        when(input.askInt(any(String.class))).thenReturn(2);
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Ошибка удаления заявки." + ln));
        assertThat(tracker.findAll().size(), is(1));
    }

    @Test
    public void whenEditItemMockSuccess() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        EditItemAction editItemAction = new EditItemAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        editItemAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Edit item ===" + ln + "Заявка изменена успешно." + ln));
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenEditItemMockFailed() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        EditItemAction editItemAction = new EditItemAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(2);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        editItemAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Edit item ===" + ln + "Ошибка замены заявки." + ln));
        assertThat(tracker.findAll().get(0).getName(), is("Replaced item"));
    }
}