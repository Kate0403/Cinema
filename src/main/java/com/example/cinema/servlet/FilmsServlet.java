package com.example.cinema.servlet;

import com.example.cinema.dto.FilmDto;
import com.example.cinema.service.FilmService;
import com.fasterxml.jackson.core.*;

import com.fasterxml.jackson.databind.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/films")
public class FilmsServlet extends HttpServlet {

    private final FilmService filmService = FilmService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        final String[] json = new String[1];
        filmService.findAll().forEach (FilmDto-> {
        FilmDto Film = new FilmDto(FilmDto.getID(), FilmDto.getTitle(), FilmDto.getDescription(), FilmDto.getGenre(), FilmDto.getDuration(), FilmDto.getCountry());


            try {
                json[0] = new ObjectMapper().writeValueAsString(Film);
            } catch (JsonGenerationException e) {
                throw new RuntimeException(e);
            }catch (JsonMappingException e){
                throw new RuntimeException(e);
            }catch (IOException e){
                throw new RuntimeException(e);
            }




            try {
                        var printWriter = resp.getWriter();
                        printWriter.write(json[0]);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


        });
    }
}
   /*
            filmService.findAll().forEach
                 
                    (FilmDto -> {

            <li>
            <a href="/seance?filmID=%d">%s</a>
            </li>
            """.formatted(FilmDto.getID(), FilmDto.getDescription()));
});
            printWriter.write("</ul>");
        }
        
                     */


