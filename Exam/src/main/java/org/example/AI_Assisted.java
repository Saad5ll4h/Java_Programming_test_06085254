package org.example;

import assessments.AssessmentFeed;

public class AI_Assisted extends Assessment {
    public AI_Assisted(String type) {
        super(type);
    }

    @Override
    public int getResult() {
        return 0;   // in clock steps: hours on an hourly clock, minutes on a minute clock (see "Changing the numbers")
    }

    @Override
    public void getResult(Class<? extends AssessmentFeed> aClass) {

    }
}
