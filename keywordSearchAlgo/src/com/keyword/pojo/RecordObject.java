package com.keyword.pojo;

public class RecordObject {

    //Plain java object class which we use to map the Data either from csv , json.
    
    public RecordObject(int movieId, String movieName, String comment) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.comment = comment;
    }

    private int movieId;

    private String movieName;

    private String comment;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + movieId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RecordObject other = (RecordObject) obj;
        if (movieId != other.movieId)
            return false;
        return true;
    }

}
