package org.example;


import assessments.AssessmentFeed;

import java.awt.Color;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Assessment> things = new ArrayList<>();
        things.add(new AI_Assisted("AI Assisted Programming Test"));
        things.add(new Independent("Independent Programming Test"));
        things.add(new Viva("MSC Students Viva"));


        GridWindow grid = new GridWindow("Results Information", 2, 2);
        String[] places = {"Program Mark","Explain Successfully","Functionality Mark", "Verification Mark", "Design Mark", "Explanation Mark"};

        ArrayList<AssessmentFeed> waiting = new ArrayList<>();
        int mark = 0;


        while (true) {
            System.out.println("Mark: " + mark);


            for (Assessment t : things) {
                t.tick();
            }



            for (int i = 0; i < waiting.size(); i++) {
                AssessmentFeed.getResult();
                AssessmentFeed w = waiting.get(i);
                Assessment t = find(things, w.getClass());
                if (t != null && !t.isActive()) {
                    try {
                        AssessmentFeed.getResult();
                        t.getResult(w.getClass());
                        waiting.remove(i);
                        i--;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                }
            for (int p = 0; p < places.length; p++) {
                String text = "<b>" + places[p] + "</b>";
                boolean anyActive = false;
                for (Assessment t : things) {
                    if (t.getStudentType().equals(places[p])) {
                        text += "<br>" + t.getResult();
                        if (t.isActive()) {
                            anyActive = true;
                        }
                    }
                }
                Color colour = anyActive ? Color.GREEN : Color.WHITE;
                grid.setCell(p, text, colour);
            }
            if (mark == AssessmentFeed.getResult()) {
                System.out.println("--- Results mark:  " + mark + " ---");
                for (Assessment t : things) {
                    System.out.println(t.getStudentname() + " in " + t.getResult());
                }
                System.out.println("Waiting: " + waiting.size());
            }
            mark++;
            AssessmentFeed.getResult();
            }
        }

    // Finds a thing by its name; null if there isn't one
    static Assessment find(ArrayList<Assessment> things, Class<? extends AssessmentFeed> name) {
        for (Assessment t : things) {
            if (t.getStudentname().equals(name)) {
                return t;
            }
        }
        return null;
    }
}



