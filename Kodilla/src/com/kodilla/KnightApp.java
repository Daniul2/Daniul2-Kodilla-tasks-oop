package com.kodilla;

interface Quest {
    String getName();
    void process();
}

class DeadIslandQuest implements Quest {
    @Override
    public String getName() {
        return "Dead Island Quest";
    }

    @Override
    public void process() {
        System.out.println("Quest completed: " + getName());
    }
}

class EliteKnightQuest implements Quest {
    @Override
    public String getName() {
        return "Elite Knight Quest";
    }

    @Override
    public void process() {
        System.out.println("Quest completed: " + getName());
    }
}

class Knight {
    private final Quest quest;

    public Knight(Quest quest) {
        this.quest = quest;
    }

    public void startQuest() {
        quest.process();
    }
}

public class KnightApp {
    public static void main(String[] args) {
        Knight knight1 = new Knight(new DeadIslandQuest());
        knight1.startQuest();

        Knight knight2 = new Knight(new EliteKnightQuest());
        knight2.startQuest();
    }
}
