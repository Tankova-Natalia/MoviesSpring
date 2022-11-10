package controllers;

import model.Director;
import model.Genre;
//import model.Movie;
import model.Movie;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.Model;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Director> list1 = session.createQuery("select d from Director as d").getResultList();
        int i = 0;
        for (Iterator<Director> iterator = list1.iterator(); iterator.hasNext();){
            Director director = iterator.next();
            System.out.println(i + " " + director.getLast_name() + "\t" + director.getMovies().size());
            i++;
        }
/*
        List<Movie> movies = session.createQuery("select m from Movie as m").getResultList();
        int j = 0;
        for (Iterator<Movie> iterator = movies.iterator();iterator.hasNext();){
            Movie movie = iterator.next();
            System.out.println(j + "\t" +movie.getName() + "\t" + movie.getDirectors().size());
            j++;
        }*/

        session.getTransaction().commit();
        session.close();
        System.out.println("OK");
        System.exit(0);
    }
}

