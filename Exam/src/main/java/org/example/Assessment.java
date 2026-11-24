package org.example;

import assessments.AssessmentFeed;

import java.util.Collections;
import java.util.List;

public abstract class Assessment {
    private List CID;
    private String name;
    private String type;
    private int mark = 0;

    public Assessment(String name, String type, List CID) {
        this.name = name;
        this.type = type;
        this.CID = CID;
    }

    public Assessment(String type) {
    }

    public abstract int getResult();

    public String getStudentname() { return name; }
    public String getStudentType() { return type; }
    public List getCID() { return Collections.singletonList(String.valueOf(CID)); }


    public void tick() {
        if (mark > 0) {
            mark--;
        }
    }


    public abstract void getResult(Class<? extends AssessmentFeed> aClass);

    public boolean isActive() {
        return mark > 0;
    }
}
