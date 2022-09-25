package _04_Optional_1;

import java.util.Optional;

public class OnlineClass {
    private Integer id;
    private String title;
    private boolean closed;

    public Progress progress;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

/*    public Optional<Progress> getProgress() {

        *//**
         * checked exception 를 발생하면 에러처리를 강제하게 됨.
         *  - 필요한 경우에만 써야하는데 로직처리과정에 쓰는건 지양해야 함
         * stack trace 를 담기 때문에 리소스가 낭비됨
         *//*
        if (this.progress == null)
                throw new IllegalMonitorStateException();
        return Optional.ofNullable(progress);
    }*/

    /*
        return type 에 맞게 Optional<T> 타입을 리턴해야 한다.
        결과가 없으면 .empty()를 리턴하도록 하자.
     */
    /*public Optional<Progress> getProgress() {
        //return null;
        return Optional.empty();
    }*/

    public Optional<Progress> getProgress() {
        return Optional.ofNullable(progress);
    }

//    public void setProgress(Progress progress) {
//        this.progress = progress;
//    }

    /**
     * parameter 에 Optional은 지양해야 한다.
     * - 호출자가 null을 입력했을 경우,
     * - Optional 객체 존재여부와 Progress 객체 존재여부도 동시에 예외처리 해야 하기 때문
     */
    public void setProgress(Optional<Progress> progress) {
        if (progress != null)
            progress.ifPresent(p-> this.progress = p);
    }
}
