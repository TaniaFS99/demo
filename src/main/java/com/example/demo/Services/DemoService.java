package com.example.demo.Services;

import com.example.demo.Modelos.Noticias;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class DemoService {

    public ArrayList<Noticias> retornaConsulta(String q) throws IOException, Error {

        String urlBuscador = "https://www.adndigital.com.py/?s=";
//      String urlBuscador = "https://www.abc.com.py/buscador/?query=";

        Connection conn = Jsoup.connect(urlBuscador + q);

        Document document = conn.timeout(100000).maxBodySize(0).get();

        System.out.println(document);

        Elements div = document.getElementsByClass("item-list");

        ArrayList<Noticias> noticiasList = new ArrayList<>();

        for (Element element : div){

            String fecha = element.getElementsByClass("post-meta").text();

            String enlaceNoticia = element.select("a").attr("href");

            String enlaceFoto = element.select("img").attr("src");

            String titulo = element.getElementsByClass("post-box-title").text();

            String resumen = element.select(".entry p").text();

            Noticias noticias = new Noticias(fecha, enlaceNoticia, enlaceFoto, titulo, resumen);

            noticiasList.add(noticias);
        }

        if (noticiasList.isEmpty()){
            throw new Error();
        }else{
            return noticiasList;
        }

    }

}
