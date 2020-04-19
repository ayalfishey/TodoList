package com.ayal.todo.data;


public enum Progress{
    TODO(0),IN_PROGRESS(1),DONE(2);

    public final int id;

    Progress(int id) {
        this.id = id;
    }

    public static Progress getProgressById(int progressId){
        Progress progress = null;
        switch (progressId) {
            case 0:
                progress = Progress.TODO;
                break;
            case 1:
                progress = Progress.IN_PROGRESS;
                break;
            case 2:
                progress = Progress.DONE;
                break;
        }
        return progress;
    }
}
