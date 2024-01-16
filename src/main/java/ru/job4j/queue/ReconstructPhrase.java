package ru.job4j.queue;

import java.util.Deque;

/**
 * @author Artem Chernikov
 * @version 1.0
 * @since 16.01.2024
 */
public class ReconstructPhrase {
    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < evenElements.size(); i++) {
            stringBuilder.append(evenElements.peek());
            evenElements.poll();
            evenElements.poll();
            i--;
        }
        return stringBuilder.toString();
    }

    private String getDescendingElements() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < descendingElements.size(); i++) {
            stringBuilder.append(descendingElements.pollLast());
            i--;
        }
        return stringBuilder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
