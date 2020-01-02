package com.atguigu.cloud.bean;

/**
 * @author yutongxue
 * @create 2020-01-02 0:10
 */
public class Movie {

    private Integer id;

    private String movieName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                '}';
    }
}
